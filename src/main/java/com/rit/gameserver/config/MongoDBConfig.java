package com.rit.gameserver.config;

import com.rit.gameserver.dao.Repository;
import com.rit.gameserver.model.Game;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.UUID;

@EnableMongoRepositories(basePackageClasses = Game.class)
@Configuration()
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(Repository repository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            }
        };
    }
}
