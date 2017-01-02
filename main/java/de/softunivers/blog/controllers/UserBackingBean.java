
package de.softunivers.blog.controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
public class UserBackingBean implements Serializable
{
    private int id;
    private String fname;
    private String lname;
}
