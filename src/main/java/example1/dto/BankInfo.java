package example1.dto;




import javax.persistence.*;

@Entity

public class BankInfo {
    @Id
    @GeneratedValue
    private Long bankId;
    private String bankName;



    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    private String accountNumber;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
