package pca.web.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pca.service.data.CommentData;
import pca.service.data.ProblemData;
import pca.service.comment.CommentService;
import pca.service.data.SolutionData;
import pca.service.data.TestData;
import pca.service.exception.WebServiceException;
import pca.service.problem.ProblemService;
import pca.service.solution.SolutionService;
import pca.service.test.TestService;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProblemController {

  @Autowired
  ProblemService problemService;
  @Autowired
  CommentService commentService;
  @Autowired
  SolutionService solutionService;
  @Autowired
  TestService testService;


  @ModelAttribute("problem")
  public ProblemData consturct() {
    return new ProblemData();
  }

  @ModelAttribute("comment")
  public CommentData consturctComment() {
    return new CommentData();
  }

  @ModelAttribute("solution")
  public SolutionData consturctSolution() {
    return new SolutionData();
  }


  @RequestMapping(value = "/problems", method = RequestMethod.GET)
  public String showProblems(Model model) {

    model.addAttribute("problems", problemService.findAllProblems());
    return "problems";
  }

  @RequestMapping(value = "/problems/{problemName}", method = RequestMethod.GET)
  public String showProblem(Model model, @PathVariable String problemName) throws WebServiceException {

    ProblemData problemData = problemService.findProblem(problemName);
    model.addAttribute("problem", problemData);
    List<CommentData> list = commentService.findAllComments(problemName);
    model.addAttribute("comments", list);

    return "problem-details";
  }


  @RequestMapping(value = "/problems/{problemName}", method = RequestMethod.POST)
  public String addSolutionAndComment(@PathVariable String problemName, @ModelAttribute("comment") CommentData commentData,
                                      @ModelAttribute("solution") SolutionData solutionData, Principal principal) throws WebServiceException {

    if (commentData.getBody() != null) {
      commentData.setUserName(principal.getName());
      commentData.setProblemName(problemName);
      commentService.addComment(commentData);
    }


    if (solutionData.getText() != null) {
      solutionData.setProblemName(problemName);
      solutionData.setUserName(principal.getName());
      solutionService.addSolution(solutionData, problemName, principal.getName());

    }
    return "redirect:/problems/{problemName}";
  }

  @RequestMapping(value = "/problems/remove/{problemName}", method = RequestMethod.GET)
  public String removeProblem(@PathVariable String problemName) {
    problemService.removeProblem(problemName);
    return "redirect:/problems";
  }

  @RequestMapping(value = "/problems/addproblem", method = RequestMethod.GET)
  public String showAddProblem() {
    return "addproblem";
  }


  @RequestMapping(value = "/problems/addproblem/", method = RequestMethod.POST)
  public String addProblem(Model model, @RequestParam("problemName") String problemName,
                           @RequestParam("problemStatement") String problemStatement,
                           @RequestParam("file") MultipartFile[] files) throws WebServiceException {

    List<String> testList = new ArrayList<String>(10);
    ProblemData problemData = new ProblemData();

    for (int i = 0; i < files.length; i++) {

      MultipartFile file = files[i];
      try {
        ByteArrayInputStream stream = new ByteArrayInputStream(file.getBytes());
        String fileContent = IOUtils.toString(stream, "UTF-8");
        if (i == 0) {
          problemData.setOfficialSolution(fileContent);
        } else {
          testList.add(fileContent);
        }
      } catch (Exception e) {
        throw new WebServiceException("You failed to upload " + file.getName() + " => " + e.getMessage());
      }
    }

    problemData.setProblemName(problemName);
    problemData.setProblemStatement(problemStatement);
    problemService.addProblem(problemData);
    TestData testData = new TestData();
    List<String> outputs = problemService.validateProblem(problemData, testList);
    for (int i = 0; i < testList.size(); i++) {
      testData.setProblemName(problemName);
      testData.setInputData(testList.get(i));
      testData.setOutputData(outputs.get(i));
      testService.addTest(testData);
    }
    model.addAttribute("problem", problemData);
    model.addAttribute("inputs", testList);
    model.addAttribute("outputs", outputs);
    return "validate_problem";
  }


  @RequestMapping(value = "/problems/edit/{problemName}", method = RequestMethod.GET)
  public String showEditProblem(Model model, @PathVariable String problemName) throws WebServiceException {

    ProblemData oldProblem = problemService.findProblem(problemName);
    model.addAttribute("problem", oldProblem);

    return "editproblem";
  }

  @RequestMapping(value = "/problems/edit/{problemName}", method = RequestMethod.POST)
  public String editProblem(@ModelAttribute("problem") ProblemData problem) {

    problemService.updateProblem(problem);
    return "redirect:/problems";
  }

  @RequestMapping(value = "/problems/solutions/{problemName}", method = RequestMethod.GET)
  public String showProblemSolution(Model model, @PathVariable String problemName) throws WebServiceException {

    model.addAttribute("solutions", solutionService.findAllSolutions(problemName));
    return "problem-solutions";
  }

  @ExceptionHandler(WebServiceException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ModelAndView handleProblemNotFoundException(HttpServletRequest request, Exception ex) {

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", ex.getMessage());
    modelAndView.setViewName("error");
    return modelAndView;
  }
}
