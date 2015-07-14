package by.gudyna.mentoring.hibernatetask.model;

import by.gudyna.mentoring.hibernatetask.model.manytoone.Hardware;
import by.gudyna.mentoring.hibernatetask.model.onetoone.PersonalInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users", schema = "gudyna")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "U")
public class User implements Serializable
{
    private long id;
    private String nickname;
    private PersonalInfo personalInfo;
    private Set<Hardware> hardwares;

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "USERS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 25)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id")
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Hardware> getHardwares() {
        return hardwares;
    }

    public void setHardwares(Set<Hardware> hardwares) {
        this.hardwares = hardwares;
    }
}
