package example2.dto;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("POST")
public class Post extends Content{

    private String postCategory;
    private String thumbnailUrl;

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
