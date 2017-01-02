
package de.softunivers.blog.controllers;

import de.softunivers.blog.ejbs.CommentFacade;
import de.softunivers.blog.ejbs.PostFacade;
import de.softunivers.blog.models.Comment;
import de.softunivers.blog.models.CommentPK;
import de.softunivers.blog.models.Post;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ayoubfalah
 */
@Named
@RequestScoped
public class CommentsController implements Serializable
{
    @EJB
    CommentFacade commentFacade;
    
    @EJB
    PostFacade postFacade;
    
    @Inject
    CommentBackingBean commentBackingBean;
    
    public List<Comment> getAll()
    {
        return commentFacade.findAll();
    }
    
    public int count()
    {
        return commentFacade.count();
    }
    
    public String delete(Comment comment)
    {
        commentFacade.remove(comment);
        return null;        
    }
    
    public String add()
    {
        CommentPK commentPK = new CommentPK();
        Integer userId = commentBackingBean.getUserId();
        commentPK.setUserId(userId);
        Integer postId = commentBackingBean.getPostId();
        commentPK.setPostId(postId);
        Comment comment = new Comment(commentPK);
        String openion = commentBackingBean.getOpenion();
        comment.setOpenion(openion);
        
        commentFacade.create(comment);
        
        return "comments";
    }
    
    public String edit(Comment comment)
    {
        int userId = comment.getCommentPK().getUserId();
        int postId = comment.getCommentPK().getPostId();
        commentBackingBean.setUserId(userId);
        commentBackingBean.setPostId(postId);
        commentBackingBean.setOpenion(comment.getOpenion());
        
        return "update";
    }
    
    public String save()
    {
        Integer userId = commentBackingBean.getUserId();
        Integer postId = commentBackingBean.getPostId();
        Comment comment = new Comment(userId, postId);
        comment.setOpenion(commentBackingBean.getOpenion());
        
        commentFacade.edit(comment);
        
        return "comments";
    }

}
