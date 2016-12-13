
package de.softunivers.blog.ejbs;

import de.softunivers.blog.models.Post;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ayoubfalah
 */
@Stateless 
public class PostFacade extends AbstractFacade<Post> 
{

    @PersistenceContext(unitName = "blogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }

}
