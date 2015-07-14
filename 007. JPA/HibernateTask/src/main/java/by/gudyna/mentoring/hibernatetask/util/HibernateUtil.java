package by.gudyna.mentoring.hibernatetask.util;

import by.gudyna.mentoring.hibernatetask.model.Employee;
import by.gudyna.mentoring.hibernatetask.model.User;
import by.gudyna.mentoring.hibernatetask.model.onetoone.FullName;
import by.gudyna.mentoring.hibernatetask.model.onetoone.PersonalInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

//This class was used only for testing
public class HibernateUtil
{
    public static void main(String... str)
    {
        SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        PersonalInfo info = new PersonalInfo();
        FullName fullName = new FullName();
        fullName.setName("Raman");
        fullName.setSurname("Palamarchuk");
        info.setFullname(fullName);

        Employee employee = new Employee();
        employee.setNickname("Romchik");
        employee.setRoomNumber(402);
        employee.setPersonalInfo(info);

        session.save(employee);

        List<User> users = session.createCriteria(User.class).list();
        System.out.println(users.size());

        List<User> employees = session.createCriteria(Employee.class).list();
        System.out.println(users.size());

        session.getTransaction().commit();
    }
}
