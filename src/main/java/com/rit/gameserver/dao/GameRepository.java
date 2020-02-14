package com.rit.gameserver.dao;

import com.rit.gameserver.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameRepository{

    void insertGame(String id, Game game);
    default void insertGame(Game game){
        String id = UUID.randomUUID().toString();
        insertGame(id, game);
    }

    List <Game> selectAllGames();

    List<Game> selectGameByName();

    int deleteGameById(UUID id);

    Optional <Game> selectGameById(UUID id);

    int updateGameById(UUID id, Game person);

}
