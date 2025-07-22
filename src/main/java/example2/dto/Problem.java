package example2.dto;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PROBLEM")
public class Problem extends Content{

    private String difficulty;
    private String tags;
}
