package example3.dto;


import javax.persistence.Embeddable;

@Embeddable
public class ContactInfo {

    private String phone;
    private String email;
    private String fax;

    public ContactInfo() {

    }

    public ContactInfo(String phone, String email, String fax) {
        this.phone = phone;
        this.email = email;
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
