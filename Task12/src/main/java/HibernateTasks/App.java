package HibernateTasks;

import HibernateTasks.entity.*;
import HibernateTasks.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        Task task = Task.builder()
                .name("task")
                .description("description")
                .build();

        City city = City.builder()
                .cityName("city")
                .build();
        Address address = Address.builder()
                .city(city)
                .street("street")
                .build();

        HomeTask homeTask = HomeTask.builder()
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(1)))
                .address(address)
                .build();

        WorkTask workTask = WorkTask.builder()
                .cost("1000")
                .build();

        //get session and transaction
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.getTransaction();

        transaction.begin();
        session.save(task);
        session.save(homeTask);
        session.save(workTask);
        transaction.commit();


    }
}
