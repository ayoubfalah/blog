
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
public class UserBackingBean implements Serializable
{
    private int id;
    private String fname;
    private String lname;
}
