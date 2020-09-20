package org.appMain.config;

import org.appMain.entities.Seller;
import org.appMain.repo.SellerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Date;

@Configuration
public class AppConfig {
    @Bean
    public CommandLineRunner demo(final SellerRepository sellerRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Seller seller1 = new Seller("Kolya", "Frolov");
                sellerRepository.save(seller1);

            }
        };
    }
}
