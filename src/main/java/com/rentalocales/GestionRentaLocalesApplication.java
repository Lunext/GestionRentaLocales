package com.rentalocales;

import com.rentalocales.models.Local;
import com.rentalocales.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionRentaLocalesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GestionRentaLocalesApplication.class, args);






    }




    @Autowired
    private LocalRepository repository;

    @Override
    public void run(String... args) throws Exception {
     /*   Local l1= new Local("Leandro Almanzar", "Lea@gmail.com","Fiesta","06-19-2022", "06-21-2022",5500.50,"Monte Plata", "La Matica",true);
        repository.save(l1); */




    }
}
