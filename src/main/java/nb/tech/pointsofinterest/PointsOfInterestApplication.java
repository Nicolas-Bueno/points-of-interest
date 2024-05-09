package nb.tech.pointsofinterest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nb.tech.pointsofinterest.entity.PointInterest;
import nb.tech.pointsofinterest.repository.PointInterestRepository;

@SpringBootApplication
public class PointsOfInterestApplication implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(PointsOfInterestApplication.class, args);
	}

	@Autowired
	private PointInterestRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new PointInterest("Lanchonete", 27L, 12L));
		repository.save(new PointInterest("Posto", 31L, 18L));
		repository.save(new PointInterest("Joalheria", 15L, 12L));
		repository.save(new PointInterest("Floricultura", 19L, 21L));
		repository.save(new PointInterest("Pub", 12L, 8L));
		repository.save(new PointInterest("Supermercado", 23L, 6L));
		repository.save(new PointInterest("Churrascaria", 28L, 2L));

	}

}
