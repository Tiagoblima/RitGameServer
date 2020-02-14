package com.rit.gameserver.dao;

import com.rit.gameserver.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.lang.String;
import java.util.UUID;

public interface Repository extends MongoRepository <Game, String> {


    // void updateGameById(String id , Game game);
}
