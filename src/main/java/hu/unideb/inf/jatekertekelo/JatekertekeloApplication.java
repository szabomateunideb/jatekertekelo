package hu.unideb.inf.jatekertekelo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;

@SpringBootApplication
public class JatekertekeloApplication {

	public static void main(String[] args) {
		SpringApplication.run(JatekertekeloApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	ExecutorService vts(){
		return java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor();
	}

}
