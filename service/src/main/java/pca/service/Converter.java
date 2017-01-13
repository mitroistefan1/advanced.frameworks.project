package pca.service;


import pca.persistence.dto.CommentDto;
import pca.persistence.dto.ProblemDto;
import pca.persistence.dto.UserTokenDto;
import pca.persistence.dto.UserDto;
import pca.persistence.model.Comment;
import pca.persistence.model.Problem;
import pca.persistence.model.User;
import pca.persistence.model.UserToken;

public class Converter {

    public User getUser(UserDto userDto) {
        User returnUser = new User();

        returnUser.setUserName(userDto.getUserName());
        returnUser.setEmail(userDto.getEmail());
        returnUser.setPassword(userDto.getPassword());
        returnUser.setRole(userDto.getRole());
        return returnUser;
    }

    public UserDto getUserDto(User user) {
        UserDto returnUserDto = new UserDto();

        returnUserDto.setUserName(user.getUserName());
        returnUserDto.setEmail(user.getEmail());
        returnUserDto.setPassword(user.getPassword());
        returnUserDto.setRole(user.getRole());
        return returnUserDto;
    }

    public UserToken getUserToken(UserTokenDto userTokenDto) {
        UserToken userToken = new UserToken();

        userToken.setUserName(userToken.getUserName());
        userToken.setSeries(userToken.getSeries());
        userToken.setToken(userToken.getToken());
        userToken.setDate(userToken.getDate());
        return userToken;
    }

    public UserTokenDto getUserTokenDto(UserToken userToken) {
        UserTokenDto returnUserDto = new UserTokenDto();

        returnUserDto.setUserName(userToken.getUserName());
        returnUserDto.setSeries(userToken.getSeries());
        returnUserDto.setToken(userToken.getToken());
        returnUserDto.setDate(userToken.getDate());
        return returnUserDto;
    }

    public Problem getProblem(ProblemDto problemDto){
        Problem problem = new Problem();
        problem.setProblemName(problemDto.getProblemName());
        problem.setProblemStatement(problemDto.getProblemStatement());
        return problem;
    }
    public ProblemDto getProblemDto(Problem problem){
        ProblemDto problemDto = new ProblemDto();
        problemDto.setProblemName(problem.getProblemName());
        problemDto.setProblemStatement(problem.getProblemStatement());
        return problemDto;
    }

    public Comment getComment(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setBody(commentDto.getBody());
        comment.setProblem(commentDto.getProblem());
        comment.setAuthor(commentDto.getAuthor());
        return comment;
    }
    public CommentDto getCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setBody(comment.getBody());
        commentDto.setProblem(comment.getProblem());
        commentDto.setAuthor(comment.getAuthor());
        return commentDto;

    }

}
