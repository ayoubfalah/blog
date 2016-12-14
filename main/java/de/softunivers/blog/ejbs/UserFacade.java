
package de.softunivers.blog.ejbs;

import de.softunivers.blog.models.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ayoubfalah
 */
@Stateless 
public class UserFacade extends AbstractFacade<User> 
{

    @PersistenceContext(unitName = "blogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

}