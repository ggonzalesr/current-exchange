package pe.ggonzales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
public class ExchangerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangerateApplication.class, args);
	}
	/*@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
	    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
	    initializer.setConnectionFactory(connectionFactory);
	    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.addScript(new ClassPathResource("schema.sql"));
	    populator.addScript(new ClassPathResource("data.sql"));
	    initializer.setDatabasePopulator(populator);
	    return initializer;
	}*/
	/*@Bean
    public CommandLineRunner initData(ExchangeRateRepository rateRepo, UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            // Datos iniciales
            rateRepo.saveAll(Flux.just(
                new ExchangeRate("USD", "PEN", new BigDecimal("3.75")),
                new ExchangeRate("PEN", "USD", new BigDecimal("0.27")),
                new ExchangeRate("EUR", "PEN", new BigDecimal("4.10")),
                new ExchangeRate("PEN", "EUR", new BigDecimal("0.24"))
            )).subscribe();
            
            userRepo.save(new User("admin", encoder.encode("password"), "ADMIN")).subscribe();
        };
    }*/
}
