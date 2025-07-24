package example3.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String zip;

    public Address() {

    }
    public Address(String city, String zip) {
        this.city = city;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
