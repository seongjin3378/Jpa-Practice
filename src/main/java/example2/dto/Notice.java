package example2.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("NOTICE")
public class Notice extends Content{

    private LocalDateTime publishedAt;

    private boolean important;




}
