
package de.softunivers.blog.controllers;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ayoubfalah
 */
@Getter
@Setter
@Named
@RequestScoped
public class CommentBackingBean implements Serializable
{
    private Integer userId;
    private Integer postId;
    private String openion;
}
