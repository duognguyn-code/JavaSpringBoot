package com.example.manageprojectemployeeretro;

import com.example.manageprojectemployeeretro.config.Config;
import com.example.manageprojectemployeeretro.config.Girl;
import com.example.manageprojectemployeeretro.config.Menu;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
public class ManageProjectEmployeeRetroApplication implements CommandLineRunner {

    @Autowired
    Menu menu;

    @Autowired
    Config config;




    @Autowired
    UserRepository userRepository;


    public static void main(String[] args) {
        System.out.println("> Trước khi IoC Container được khởi tạo");
        ApplicationContext context = SpringApplication.run(ManageProjectEmployeeRetroApplication.class, args);
        System.out.println("> Sau khi IoC Container được khởi tạo");
        Girl girl = context.getBean(Girl.class);
        ((ConfigurableApplicationContext)context).getBeanFactory().destroyBean(girl);
        System.out.println("sau khi ioc destroy girl");
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("\t mail: "+ menu.getEmail());
        System.out.println("\t menus: "+ menu.getGoogleAnalyticsId());


//        User user = userRepository.findUserById(1);
//        System.out.println(user.getFirstName());
//        System.out.println(user.getRole());
    }


}
