package com.digitalinnovationone.heroesapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class HeroesapiApplication {

	public static void main(String[] args) {
		//Subir servidor dynamoDB
		//java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -help

		//Verificar tabelas no dynamoDB
		//aws dynamodb list-tables --endpoint-url http://localhost:8000

		//GitHub da instrutora Kamilah Santos
		//https://github.com/Kamilahsantos/Heroes-SpringWebflux-API/blob/master/livecoding/src/main/java/com/digitalinnovation/livecoding/config/HeroesData.java

		SpringApplication.run(HeroesapiApplication.class, args);
		System.out.println("Super poderes com webflux");


	}

}
