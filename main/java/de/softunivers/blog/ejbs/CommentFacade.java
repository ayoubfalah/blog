
package de.softunivers.blog.ejbs;

import de.softunivers.blog.models.Comment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ayoubfalah
 */
@Stateless 
public class CommentFacade extends AbstractFacade<Comment> 
{

    @PersistenceContext(unitName = "blogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentFacade() {
        super(Comment.class);
    }

}
