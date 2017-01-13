package pca.service.comments;

import org.springframework.beans.factory.annotation.Autowired;
import pca.persistence.dao.CommentDao;
import pca.persistence.dao.ProblemDao;
import pca.persistence.dto.CommentDto;
import pca.persistence.dto.ProblemDto;
import pca.persistence.model.Comment;
import pca.service.Converter;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private Converter converter;

    public List<CommentDto> findAllComments(ProblemDto problemDto){
        List<Comment> list=commentDao.findByProblem(converter.getProblem(problemDto));
        List<CommentDto> listDto = new ArrayList<CommentDto>();
        for (Comment c: list) {
            listDto.add(converter.getCommentDto(c));
        }
        return listDto;
    }

    public void addComment(CommentDto commentDto,String problemName,String author){
        commentDto.setProblem(problemDao.findOne(problemName));
        commentDto.setAuthor(author);
        System.out.println("comment service add coment id=" +commentDto.getId());
        commentDao.save(converter.getComment(commentDto));
    }

    public void deleteComment(int commentId){
        commentDao.delete(commentId);
    }
    public void setConverter(Converter converter) {
        this.converter = converter;
    }
}
