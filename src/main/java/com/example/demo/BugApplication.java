package com.example.demo;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "com.example.*")
public class BugApplication {
	@Autowired
	private BugRepository repository;

	private final String hash = "AAAAA";

	@Bean
	CommandLineRunner reproduceBug() {
		return args -> {
			// remove all entities
			repository.deleteAll();

			repository.save(new BugEntity(hash, 2L));

			// wait for TTL to expire
			Thread.sleep(1000);

			Optional<BugEntity> bugEntity = repository.findByHash(hash);

			if (bugEntity.isEmpty()) {
				System.out.println("bugEntity isEmpty");
			} else {
				long someId = bugEntity.get().getSomeId();

				System.out.println(someId);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BugApplication.class, args);
	}

}
