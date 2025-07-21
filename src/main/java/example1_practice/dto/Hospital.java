package example1_practice.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;

    private String name;

    @OneToMany(mappedBy = "hospital")
    private List<MemberTwo> members = new ArrayList<>(); //직원들



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberTwo> getMembers() {
        return members;
    }

    public void setMembers(List<MemberTwo> members) {
        this.members = members;
    }

    public void addMember(MemberTwo member) {
        members.add(member); //1차캐시
    }
}
