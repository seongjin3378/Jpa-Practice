package example1.dto;


import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String name;


    // 단방향 1:1 매핑 — Member 테이블에만 외래키(bank_id)가 생깁니다.
    @ManyToOne
    @JoinColumn(name = "bank_id")   // 외래 키 컬럼
    private BankInfo bankInfo;



    public void setHospitalInfo(HospitalInfo hospitalInfo) {
        this.hospitalInfo = hospitalInfo;
    }

    @ManyToOne
    @JoinColumn(name = "HOSPITALID")
    private HospitalInfo hospitalInfo;



    public HospitalInfo getHospitalInfo() {
        return hospitalInfo;
    }

    public void changeHospitalInfo(HospitalInfo newHospitalInfo) {
        this.hospitalInfo = newHospitalInfo;
        hospitalInfo.addMember(this);
        //1차 캐시가 살아있을 경우
        //HospitalInfo에 아무값도 안넣었기 때문에 insert 쿼리가 안들어감
        //그러나 준영속 상태에서 다시 조회할 경우
        //db에서 불러오기 때문에 fk 가 걸려있어 자동으로 entity 값을 불러옴

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }
}
