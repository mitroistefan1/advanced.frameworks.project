package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pca.service.data.CommentData;
import pca.service.data.ProblemData;
import pca.service.comment.CommentService;
import pca.service.data.SolutionData;
import pca.service.exception.WebServiceException;
import pca.service.problem.ProblemService;
import pca.service.solution.SolutionService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class ProblemController {

  @Autowired
  ProblemService problemService;
  @Autowired
  CommentService commentService;
  @Autowired
  SolutionService solutionService;


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
    List<CommentData> list = commentService.findAllComments(problemData);

    model.addAttribute("comments", list);
    return "problem-details";
  }


  @RequestMapping(value = "/problems/{problemName}", method = RequestMethod.POST)
  public String addSolutionAndComment(@PathVariable String problemName, @ModelAttribute("comment") CommentData commentData,
                                      @ModelAttribute("solution") SolutionData solutionData, Principal principal) {

    if (commentData.getBody() != null) {
      commentService.addComment(commentData, problemName, principal.getName());
    }


    if (solutionData.getText() != null) {
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

  @RequestMapping(value = "/problems/addproblem", method = RequestMethod.POST)
  public String addProblem(@ModelAttribute("problem") ProblemData problem, Principal principal) {
    String name = principal.getName();
    problemService.addProblem(problem);
    return "redirect:/problems";
  }

  @RequestMapping(value = "/problems/edit/{problemName}", method = RequestMethod.GET)
  public String showEditProblem(Model model, @PathVariable String problemName) throws WebServiceException {
    ProblemData oldProblem = problemService.findProblem(problemName);
    model.addAttribute("problem", oldProblem);

    return "editproblem";
  }

  @RequestMapping(value = "/problems/solutions/{problemName}", method = RequestMethod.GET)
  public String showProblemSolution(Model model, @PathVariable String problemName) throws WebServiceException {

    model.addAttribute("solutions", solutionService.findAllSolutions(problemService.findProblem(problemName)));
    return "problem-solutions";
  }

  @RequestMapping(value = "/problems/edit/{problemName}", method = RequestMethod.POST)
  public String editProblem(@ModelAttribute("problem") ProblemData problem) {

    problemService.addProblem(problem);
    return "redirect:/problems";
  }


  @ExceptionHandler(WebServiceException.class)
  @ResponseStatus(value= HttpStatus.NOT_FOUND)
  public ModelAndView handleProblemNotFoundException(HttpServletRequest request, Exception ex){


    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", ex.getMessage());
    modelAndView.setViewName("error");
    return modelAndView;
  }
}
