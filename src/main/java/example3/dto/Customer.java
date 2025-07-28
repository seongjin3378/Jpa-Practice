package example3.dto;

import javax.persistence.*;


@Embeddable
public class Customer {

    private String personName;
    private String city;
    private String Job;
    private String playGameName;

    public Customer() {}
    public Customer(String personName, String city, String job, String playGameName) {
        this.personName = personName;
        this.city = city;
        Job = job;
        this.playGameName = playGameName;
    }
}
