
package de.softunivers.blog.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ayoubfalah
 */
@Embeddable 
public class CommentPK implements Serializable 
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "User_Id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Post_Id")
    private int postId;

    public CommentPK() {
    }

    public CommentPK(int userId, int postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) postId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentPK)) {
            return false;
        }
        CommentPK other = (CommentPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.postId != other.postId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.softunivers.blog.models.CommentPK[ userId=" + userId + ", postId=" + postId + " ]";
    }

}
