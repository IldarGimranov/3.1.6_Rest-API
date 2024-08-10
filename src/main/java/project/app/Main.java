package project.app;

import project.Communication;
import project.model.User;
import project.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        List<User> allUsers = communication.getAllUsers();
        System.out.println(allUsers);
        communication.saveUser(new User(3L, "James", "Brown", (byte) 3));
        communication.updateUser(new User(3L, "Thomas", "Shelby", (byte) 3));
        communication.deleteUser(new User(3L, "Thomas", "Shelby", (byte) 3), 3L);
    }
}
