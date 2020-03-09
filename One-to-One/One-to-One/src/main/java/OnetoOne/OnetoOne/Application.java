package OnetoOne.OnetoOne;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(UserRepository userRepository, AddressRepository addressRepository){
        return args -> {
           User user = new User("John Doe", "john.doe@example.com", "1234abcd");
           Address address = new Address("Lake View 321", "Berlin", "Berlin",
                   "95781", "DE");
            address.setUser(user);
            user.setAddress(address);
            userRepository.save(user);
        };
    }
}
