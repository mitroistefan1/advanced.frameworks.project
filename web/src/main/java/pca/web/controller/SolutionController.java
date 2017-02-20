package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pca.service.solution.SolutionService;

@Controller
public class SolutionController {

  @Autowired
  SolutionService solutionService;

  @RequestMapping(value = "/solution/{solutionId}", method = RequestMethod.GET)
  public String showProblem(Model model, @PathVariable int solutionId) {
    model.addAttribute("solution", solutionService.findSolution(solutionId));
    return "solution-details";
  }

}
