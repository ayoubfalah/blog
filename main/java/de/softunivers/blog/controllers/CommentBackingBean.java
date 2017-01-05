
package de.softunivers.blog.controllers;

import de.softunivers.blog.models.Comment;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ayoubfalah
 */
@Getter
@Setter
@Named
@SessionScoped
public class CommentBackingBean extends Comment
{
    @NotNull(message = "The comment must have a user id")
    private Integer userId;
    @NotNull(message = "The comment must have a post id")
    private Integer postId;
}