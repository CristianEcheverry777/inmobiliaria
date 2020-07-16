package co.com.udem.inmobiliaria;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import co.com.udem.inmobiliaria.util.ConvertUsuario;



@SpringBootApplication
@EnableAutoConfiguration //levanta contexto spring
@ComponentScan(basePackages="co.com.udem.inmobiliaria") //busca 
@EnableJpaRepositories(basePackages="co.com.udem.inmobiliaria.repositories") //
@EnableTransactionManagement //manejar transaciones a bd y persistencia
@EntityScan(basePackages="co.com.udem.inmobiliaria.entities") //escanear 
public class InmobiliariaUdeMApplication {

	public static void main(String[] args) {
		SpringApplication.run(InmobiliariaUdeMApplication.class, args);
	}
	
	@Bean
	public ConvertUsuario convertClubFutbol() {
		return new ConvertUsuario();
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
