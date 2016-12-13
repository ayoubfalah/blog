
package de.softunivers.blog.controllers;

import de.softunivers.blog.ejbs.PostFacade;
import de.softunivers.blog.models.Post;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author ayoubfalah
 */
@Named
@RequestScoped
public class PostsController
{
    @EJB
    PostFacade postFacade;
    
    @Inject
    PostBackingBean postBackingBean;
    
    public List<Post> getAll()
    {
        return postFacade.findAll();
    }
    
    public int count()
    {
        return postFacade.count();
    }
    
    public String delete(Post post)
    {
        postFacade.remove(post);
        return null;        
    }
    
    public String add()
    {
        Post post = new Post();
        post.setTitle(postBackingBean.getTitle());
        post.setDescription(postBackingBean.getDescription());
        
        postFacade.create(post);
        
        return "posts";
    }
    
    public String edit(Post post)
    {
        postBackingBean.setId(post.getId());
        postBackingBean.setTitle(post.getTitle());
        postBackingBean.setDescription(post.getDescription());
        
        return "update";
    }
    
    public String save()
    {
        Post post = new Post(postBackingBean.getId());
        post.setTitle(postBackingBean.getTitle());
        post.setDescription(postBackingBean.getDescription());
        
        postFacade.edit(post);
        
        return "posts";
    }

}
