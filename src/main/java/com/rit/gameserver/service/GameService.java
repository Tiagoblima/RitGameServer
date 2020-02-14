package com.rit.gameserver.service;

import com.rit.gameserver.dao.GameRepository;
import com.rit.gameserver.dao.Repository;
import com.rit.gameserver.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service


public class GameService {

    public final GameRepository gameRepository;
    @Autowired
    public final Repository repository;


    @Autowired
    public GameService(@Qualifier("DataAccess") GameRepository gameRepository , Repository repository){

        this.gameRepository = gameRepository;
        this.repository = repository;
    }

    public List<Game> getAllGames(){
        return this.repository.findAll();
    }

    public void addGame(Game game){
        if  (game.getUrl_image() == null) {
            game.setUrl_image("https://seeklogo.net/wp-content/themes/seeklogo-2017/images/not-available.jpg");
        }
        if(game.getDescription() == null){
            game.setDescription("No description available.");
        }
        this.repository.save(game);
    }

    public Optional<Game> getGameById(String id){
        return this.repository.findById(id);
    }
    public void deleteGame(String id){   this.repository.deleteById(id); }

    public void deleteAllGames(){ this.repository.deleteAll(); }


    public void updateGame(String id, Game game){

      this.repository.deleteById(id);
      this.repository.save(game);
    }
}
