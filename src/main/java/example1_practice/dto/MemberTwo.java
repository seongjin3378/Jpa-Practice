package example1_practice.dto;


import javax.persistence.*;

@Entity
public class MemberTwo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;


    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;

    }
}
