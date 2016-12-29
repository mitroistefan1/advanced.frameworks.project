package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pca.persistence.dto.ProblemDto;
import pca.service.authentication.ProblemService;

import java.security.Principal;

@Controller
public class ProblemController {

    @Autowired
    ProblemService problemService;

    @ModelAttribute("problem")
    public ProblemDto consturct() {
        return new ProblemDto();
    }

    @RequestMapping(value = "/problems", method = RequestMethod.GET)
    public String showProblems(Model model) {
        model.addAttribute("problems", problemService.findAllProblems());
        return "problems";
    }

    @RequestMapping(value = "/problems/{problemName}", method = RequestMethod.GET)
    public String showProblem(Model model, @PathVariable String problemName) {
        model.addAttribute("problem", problemService.findProblem(problemName));
        return "problem-details";
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
    public String addProblem(@ModelAttribute("problem") ProblemDto problem, Principal principal) {
        String name = principal.getName();
        System.out.println(name);
        problemService.addProblem(problem);
        return "redirect:/problems";
    }

    @RequestMapping(value = "/problems/edit/{problemName}", method = RequestMethod.GET)
    public String showEditProblem(Model model, @PathVariable String problemName) {
        ProblemDto oldProblem = problemService.findProblem(problemName);
        model.addAttribute("problem", oldProblem);
        problemService.removeProblem(oldProblem.getProblemName());
        return "editproblem";
    }

    @RequestMapping(value = "/problems/edit/{problemName}", method = RequestMethod.POST)
    public String editProblem(@ModelAttribute("problem") ProblemDto problem) {
        problemService.addProblem(problem);
        return "redirect:/problems";
    }
}
