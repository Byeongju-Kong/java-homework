package hw.hello.member.domain;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private int idNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private RoleType roleType;

    protected Member() {
    }

    public Member(Long id, String name, int idNumber, String password, String phoneNumber, String roleType) {
        this.id = id;
        this.name = name;
        this.idNumber = idNumber;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.roleType = RoleType.from(roleType);
    }

    public static Member newMember(String name, int idNumber, String password, String phoneNumber, String roleType) {
        return new Member(null, name, idNumber, password, phoneNumber, roleType);
    }

    public boolean isAdmin() {
        return roleType.isAdmin();
    }

    public boolean isProfessor() {
        return roleType.isProfessor();
    }

    public boolean isStudent() {
        return roleType.isStudent();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RoleType getRole() {
        return roleType;
    }

    public boolean hasPassword(String password) {
        return this.password.equals(password);
    }
}
