package com.digitalinnovationone.heroesapi;

import com.digitalinnovationone.heroesapi.repository.HeroesRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinnovationone.heroesapi.constants.HeroesConstants.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesapiApplicationTests {

	private final int ID_FOUND = 5;
	private final int ID_NOTFOUND = 10;

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroesRepository heroesRepository;

	@Test
	public void GetOneHeroByIdWithSuccess(){
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),ID_FOUND)
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}
	@Test
	public void GetOneHeroByIdWithError(){
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),ID_NOTFOUND)
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deleteHero(){

		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),ID_NOTFOUND)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}
}
