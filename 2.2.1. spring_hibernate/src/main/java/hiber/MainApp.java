package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//        Car car3 = new Car("BMW", 3);
//        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
//        user3.setCar(car3);
//        userService.add(user3);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = model: " + user.getCar().getModel() + ", " + "series: " + user.getCar().getSeries());
            System.out.println();
        }

        User user = userService.getUserByCarModelAndSeries("BMW", 3);
        System.out.println(user.toString());

        context.close();
    }
}
