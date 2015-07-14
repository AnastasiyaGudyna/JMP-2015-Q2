package by.gudyna.mentoring.hibernatetask.model.manytoone;

import by.gudyna.mentoring.hibernatetask.model.User;

import javax.persistence.*;

@Entity
@Table(name = "hardware", schema = "gudyna")
public class Hardware
{
    private long id;
    private String name;
    private int releaseYear;
    private User user;

    @Id
    @SequenceGenerator(name = "hardware_seq", sequenceName = "GUDYNA.HARDWARE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hardware_seq")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "release_year")
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
