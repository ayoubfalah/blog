
package de.softunivers.blog.controllers;

import de.softunivers.blog.ejbs.UserFacade;
import de.softunivers.blog.models.User;
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
public class UsersController implements Serializable
{
    @EJB
    UserFacade userFacade;
    
    @Inject
    UserBackingBean userBackingBean;
    
    public List<User> getAll()
    {
        return userFacade.findAll();
    }
    
    public int count()
    {
        return userFacade.count();
    }
    
    public String delete(User user)
    {
        userFacade.remove(user);
        return null;        
    }
    
    public String add()
    {
        User user = new User();
        user.setFname(userBackingBean.getFname());
        user.setLname(userBackingBean.getLname());
        
        userFacade.create(user);
        
        return "users";
    }
    
    public String edit(User user)
    {
        userBackingBean.setId(user.getId());
        userBackingBean.setFname(user.getFname());
        userBackingBean.setLname(user.getLname());
        
        return "update";
    }
    
    public String save()
    {
        User user = new User(userBackingBean.getId());
        user.setFname(userBackingBean.getFname());
        user.setLname(userBackingBean.getLname());
        
        userFacade.edit(user);
        
        return "users";
    }
}