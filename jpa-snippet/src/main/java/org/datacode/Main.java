package org.datacode;

import org.datacode.entity.Address;
import org.datacode.entity.Customer;
import org.datacode.repo.AddressRepository;
import org.datacode.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootApplication
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository, AddressRepository addressRepository,
                                  EntityManager entityManager) {
        return new CommandLineRunner() {
            @Override
            @Transactional()
            public void run(String... args) throws Exception {
                // save a few customers
                Customer jack = customerRepository.save(new Customer("Jack", "Bauer"));
                entityManager.flush();

                //This is the price we pay - re read object to get db_id
                entityManager.refresh(jack);

                log.info("Loaded customer entity");
                log.info(jack.toString());

                log.info("Add a couple of addresses");
                addressRepository.save(new Address(jack, "123 Heestorm Ln", "19002"));
                addressRepository.save(new Address(jack, "456 Another Str", "18002"));

                entityManager.flush();
                entityManager.refresh(jack);

                jack = customerRepository.findById(jack.getId()).get();
                log.info("Loaded customer entity");
                log.info(jack.toString());
                for (Address address : jack.getAddresses()) {
                    log.info(address.toString());
                }
            }
        };
    }
}
