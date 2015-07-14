package by.gudyna.mentoring.hibernatetask.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users", schema = "gudyna")
@DiscriminatorValue(value = "E")
public class Employee extends User
{
    private Date arrivalDate;
    private int roomNumber;

    @Column(name = "arrival_date")
    @Temporal(value = TemporalType.DATE)
    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Column(name = "room_number")
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
