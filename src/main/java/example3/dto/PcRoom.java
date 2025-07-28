package example3.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PcRoom {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pcRoomId;

    private String name;
    private String city;

    @ElementCollection
    @CollectionTable(name = "Pc_room_customers", joinColumns = @JoinColumn(name = "pc_room_id"))
    private List<Customer> customers = new ArrayList<Customer>();
}
