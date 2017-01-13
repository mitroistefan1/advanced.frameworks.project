package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pca.persistence.dto.CommentDto;
import pca.persistence.dto.ProblemDto;
import pca.service.comments.CommentService;
import pca.service.problems.ProblemService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProblemController {

    @Autowired
    ProblemService problemService;
    @Autowired
    CommentService commentService;


    @ModelAttribute("problem")
    public ProblemDto consturct() {
        return new ProblemDto();
    }

    @ModelAttribute("comment")
    public CommentDto consturctComment() {
        return new CommentDto();
    }

    @RequestMapping(value = "/problems", method = RequestMethod.GET)
    public String showProblems(Model model) {
        model.addAttribute("problems", problemService.findAllProblems());
        return "problems";
    }

    @RequestMapping(value = "/problems/{problemName}", method = RequestMethod.GET)
    public String showProblem(Model model, @PathVariable String problemName) {
        ProblemDto problemDto = problemService.findProblem(problemName);
        model.addAttribute("problem", problemDto);
        List<CommentDto> list = commentService.findAllComments(problemDto);
        for (CommentDto c:list) {
            System.out.println(c.getId()+" "+c.getAuthor()+" "+c.getProblem().getProblemName()+" "+c.getBody());
        }
        model.addAttribute("comments", commentService.findAllComments(problemDto));
        return "problem-details";
    }


    @RequestMapping(value = "/problems/{problemName}", method = RequestMethod.POST)
    public String addComment(@PathVariable String problemName, @ModelAttribute("comment") CommentDto commentDto, Principal principal) {
        ProblemDto problemDto = problemService.findProblem(problemName);

        commentService.addComment(commentDto, problemName,principal.getName());
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
