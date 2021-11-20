package MothBalls.Randistrictr;

import MothBalls.Randistrictr.model.Population;
import MothBalls.Randistrictr.repository.PopulationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RandistrictrApplication {

	private static final Logger log = LoggerFactory.getLogger(RandistrictrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RandistrictrApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(PopulationRepository repository) {
//		return (args) -> {
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			Population population = repository.findByGeoID20("240010001001001");
//			log.info(population.toString());
//			log.info("");
//		};
//	}
}
