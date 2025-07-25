package lab.padroes.de.projeto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LabPadroesDeProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesDeProjetoSpringApplication.class, args);
	}

}
