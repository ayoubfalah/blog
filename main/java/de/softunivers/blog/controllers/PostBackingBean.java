
package de.softunivers.blog.controllers;

import de.softunivers.blog.models.Post;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ayoubfalah
 */
@Named
@SessionScoped
public class PostBackingBean extends  Post {}
