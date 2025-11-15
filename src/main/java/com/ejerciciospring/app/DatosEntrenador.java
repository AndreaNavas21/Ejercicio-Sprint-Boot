package com.ejerciciospring.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ejerciciospring.app.model.Club;
import com.ejerciciospring.app.model.Entrenador;
import com.ejerciciospring.app.repository.ClubRepository;

@Configuration
public class DatosEntrenador {
	
	@Bean
    CommandLineRunner seed(ClubRepository clubs) {
        return args -> {
            if (clubs.count() == 0) {
                Entrenador e = new Entrenador();
                e.setNombre("Rafael");
                e.setApellido("Dudamel");
                e.setEdad(51);
                e.setNacionalidad("Venezolana");

                Club c = new Club();
                c.setNombre("Atlético Bucaramanga");
                c.setCiudad("Bucaramanga");
                c.setFundacion(1949);
                c.setEstadio("Alfonso López");
                c.setEntrenador(e);

                clubs.save(c);
            }
        };
    }

}
