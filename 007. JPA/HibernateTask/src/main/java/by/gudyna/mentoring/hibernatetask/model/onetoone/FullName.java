package by.gudyna.mentoring.hibernatetask.model.onetoone;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FullName
{
    private String name;
    private String surname;

    @Column(nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false, length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
