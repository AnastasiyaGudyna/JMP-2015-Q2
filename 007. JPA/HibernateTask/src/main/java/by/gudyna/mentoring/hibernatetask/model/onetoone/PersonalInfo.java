package by.gudyna.mentoring.hibernatetask.model.onetoone;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "personal_info", schema = "gudyna")
public class PersonalInfo
{
    private long id;
    private FullName fullname;

    @Id
    @SequenceGenerator(name = "personal_info_seq", sequenceName = "GUDYNA.PERSONAL_INFO_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personal_info_seq")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Embedded
    public FullName getFullname() {
        return fullname;
    }

    public void setFullname(FullName fullname) {
        this.fullname = fullname;
    }
}
