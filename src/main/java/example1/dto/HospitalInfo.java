package example1.dto;




import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HospitalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hospitalId;
    private String hospitalName;


    // 연관관계 주인(Member) 변수
    //연관관계에 주인은 fk : member(Many) 를 기준으로 해야함
    @OneToMany(mappedBy = "hospitalInfo")
    private List<Member> adminList = new ArrayList<>();




    /*
    * 영속 상태에서 HospitalInfo를 설정 안하더라도 1차 캐시에 member 데이터가 들어있기 때문에
    * 조회됨, 그러나 em.clear 시 1차캐시가 지워지기 때문에
    * 조회할수없음. 따라서 member에 HospitalInfo를 지정해줘야 제대로 fk가 들어감
    * */
    public void addMember(Member member) {
        adminList.add(member);
        member.setHospitalInfo(this);
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public List<Member> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Member> adminList) {
        this.adminList = adminList;
    }

    public long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(long hospitalId) {
        this.hospitalId = hospitalId;
    }
}
