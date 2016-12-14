
package de.softunivers.blog.controllers;

import de.softunivers.blog.ejbs.CommentFacade;
import de.softunivers.blog.ejbs.PostFacade;
import de.softunivers.blog.models.Comment;
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
        Comment comment = new Comment();
        Integer postId = commentBackingBean.getPostId();
        Post post = postFacade.find(postId);
        comment.setPost(post);
        comment.setOpenion(commentBackingBean.getOpenion());
        
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
