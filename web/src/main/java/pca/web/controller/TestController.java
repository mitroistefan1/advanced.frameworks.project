package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pca.service.data.TestData;
import pca.service.problem.ProblemService;
import pca.service.test.TestService;


@Controller
public class TestController {

  @Autowired
  private ProblemService problemService;
  @Autowired
  private TestService testService;


  @ModelAttribute("test")
  public TestData consturct() {
    return new TestData();
  }


  @RequestMapping(value = "/problems/addtest/{problemName}", method = RequestMethod.GET)
  public String showAddTest( @PathVariable String problemName) {
    // ProblemData oldProblem = problemService.findProblem(problemName);
    // model.addAttribute("problem", oldProblem);

    return "addtest";
  }
  @RequestMapping(value = "/problems/addtest/{problemName}", method = RequestMethod.POST)
  public String addTest(@ModelAttribute("test") TestData test,@PathVariable String problemName) {
    //String name = principal.getName();
    testService.addTest(problemName,test);

    return "redirect:/problems/{problemName}";
  }
}
