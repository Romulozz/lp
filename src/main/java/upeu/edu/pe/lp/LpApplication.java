package upeu.edu.pe.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootTest
@ActiveProfiles("test")
public class LpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LpApplication.class, args);
	}

}
