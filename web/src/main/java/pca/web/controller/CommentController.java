package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pca.service.comment.CommentService;

@Controller
public class CommentController {

  @Autowired
  private CommentService commentService;

  @RequestMapping(value = "/problems/{problemName}/comment/remove/{commentId}", method = RequestMethod.GET)
  public String removeComment(@PathVariable int commentId) {
    commentService.deleteComment(commentId);
    return "redirect:/problems/{problemName}";
  }
}
