package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

//      Car car1 = new Car("Ford", 1);
//      Car car2 = new Car("Mazda", 2);
//
//      carService.add(car1);
//      carService.add(car2);
//
//      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
//      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
//      user1.setCar(car1);
//      user2.setCar(car2);
//
//      userService.add(user1);
//      userService.add(user2);


//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = model: " + user.getCar().getModel() + ", " + "series: " + user.getCar().getSeries());
//         System.out.println();
//      }

      User user3 = userService.getUserByCarModelAndSeries("Ford", 1);

      System.out.println(user3.toString());



      context.close();
   }
}
