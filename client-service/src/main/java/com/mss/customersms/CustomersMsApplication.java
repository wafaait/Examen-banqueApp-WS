package com.mss.customersms;

import com.mss.customersms.entities.Client;
import com.mss.customersms.rep.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomersMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersMsApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepository clientRepository, RepositoryRestConfiguration restConfigration){
        return args->{
            restConfigration.exposeIdsFor(Client.class);
            clientRepository.save(new Client(null , "wafa","wafa@gmail.com"));
            clientRepository.save(new Client(null , "hassna","hassna@gmail.com"));
            clientRepository.save(new Client(null , "karim","karim@gmail.com"));

            clientRepository.findAll().forEach(c->{
                System.out.println(c.getFullName());
            });
        };
    }
}


