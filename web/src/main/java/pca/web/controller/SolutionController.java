package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pca.service.exception.WebServiceException;
import pca.service.solution.SolutionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SolutionController {

  @Autowired
  SolutionService solutionService;

  @RequestMapping(value = "/solution/{solutionId}", method = RequestMethod.GET)
  public String showProblem(Model model, @PathVariable int solutionId) throws WebServiceException {
    model.addAttribute("solution", solutionService.findSolution(solutionId));
    return "solution-details";
  }

  @ExceptionHandler(WebServiceException.class)
  @ResponseStatus(value= HttpStatus.NOT_FOUND)
  public ModelAndView handleSolutionNotFoundException(HttpServletRequest request, Exception ex){


    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", ex.getMessage());
    modelAndView.setViewName("error");
    return modelAndView;
  }

}
