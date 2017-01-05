
package de.softunivers.blog.controllers;

import de.softunivers.blog.models.User;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ayoubfalah
 */
@Named
@SessionScoped
public class UserBackingBean extends User {}