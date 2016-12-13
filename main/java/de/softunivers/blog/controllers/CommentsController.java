
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
        comment.setPostId(post);
        comment.setBody(commentBackingBean.getBody());
        
        commentFacade.create(comment);
        
        return "comments";
    }
    
    public String edit(Comment comment)
    {
        commentBackingBean.setId(comment.getId());
        commentBackingBean.setBody(comment.getBody());
        
        return "update";
    }
    
    public String save()
    {
        Comment comment = new Comment(commentBackingBean.getId());
        comment.setBody(commentBackingBean.getBody());
        
        commentFacade.edit(comment);
        
        return "comments";
    }

}
