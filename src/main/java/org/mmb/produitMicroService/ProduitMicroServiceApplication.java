package org.mmb.produitMicroService;

import org.mmb.produitMicroService.entities.Produit;
import org.mmb.produitMicroService.service.ProduitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ProduitMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitMicroServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProduitService produitService) {
		return args -> {
			/*produitService.save(new Produit(null,"ref-1",20,30.00,"ref-1"));
			produitService.save(new Produit(null,"ref-2",20,30.00,"ref-2"));
			produitService.save(new Produit(null,"ref-3",20,30.00,"ref-3"));
			produitService.save(new Produit(null,"ref-4",20,30.00,"ref-4")); */
		};
	}

}
