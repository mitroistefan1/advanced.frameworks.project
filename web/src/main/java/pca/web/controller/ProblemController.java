package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pca.service.data.CommentData;
import pca.service.data.ProblemData;
import pca.service.comment.CommentService;
import pca.service.problem.ProblemService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProblemController {

  @Autowired
  ProblemService problemService;
  @Autowired
  CommentService commentService;


  @ModelAttribute("problem")
  public ProblemData consturct() {
    return new ProblemData();
  }

  @ModelAttribute("comment")
  public CommentData consturctComment() {
    return new CommentData();
  }

  @RequestMapping(value = "/problems", method = RequestMethod.GET)
  public String showProblems(Model model) {
    model.addAttribute("problems", problemService.findAllProblems());
    return "problems";
  }

  @RequestMapping(value = "/problems/{problemName}", method = RequestMethod.GET)
  public String showProblem(Model model, @PathVariable String problemName) {
    ProblemData problemData = problemService.findProblem(problemName);
    model.addAttribute("problem", problemData);
    List<CommentData> list = commentService.findAllComments(problemData);
    for (CommentData c : list) {
      System.out.println(c.getId() + " " + c.getAuthor() + " " + c.getProblem().getProblemName() + " " + c.getBody());
    }
    model.addAttribute("comments", commentService.findAllComments(problemData));
    return "problem-details";
  }


  @RequestMapping(value = "/problems/{problemName}", method = RequestMethod.POST)
  public String addComment(@PathVariable String problemName, @ModelAttribute("comment") CommentData commentData, Principal principal) {
    ProblemData problemData = problemService.findProblem(problemName);

    commentService.addComment(commentData, problemName, principal.getName());
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
    System.out.println(name);
    problemService.addProblem(problem);
    return "redirect:/problems";
  }

  @RequestMapping(value = "/problems/edit/{problemName}", method = RequestMethod.GET)
  public String showEditProblem(Model model, @PathVariable String problemName) {
    ProblemData oldProblem = problemService.findProblem(problemName);
    model.addAttribute("problem", oldProblem);

    return "editproblem";
  }

  @RequestMapping(value = "/problems/edit/{problemName}", method = RequestMethod.POST)
  public String editProblem(@ModelAttribute("problem") ProblemData problem) {

    problemService.addProblem(problem);
    return "redirect:/problems";
  }
}
