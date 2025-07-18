package hellojpa;


import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String name;


    // 단방향 1:1 매핑 — Member 테이블에만 외래키(bank_id)가 생깁니다.
    @OneToOne
    @JoinColumn(name = "bank_id")   // 외래 키 컬럼
    private BankInfo bankInfo;


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
