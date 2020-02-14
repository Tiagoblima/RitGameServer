package com.rit.gameserver.dao;

import com.rit.gameserver.model.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Repository("DataAccess")
public class DataAccess implements GameRepository {

    private static List<Game> DB = new ArrayList <>();

    @Override
    public void insertGame(String id , Game game) {
        DB.add(new Game(id, game.getName(),
                game.getCategory(),
                game.getUrl_game(),
                game.getUrl_image(),
                game.getDescription()
        ));
    }

    @Override
    public List <Game> selectAllGames() {
        return DB;
    }

    @Override
    public List <Game> selectGameByName() {
        return null;
    }

    @Override
    public int deleteGameById(UUID id) {
        Optional<Game> game = selectGameById(id);
       // if(game.isEmpty()){ return 0; }

       // DB.remove(game.get());
        return 1;
    }

    @Override
    public Optional <Game> selectGameById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int updateGameById(UUID id , Game game_update) {
    return  selectGameById(id).map( p -> {
        int indexToUpdate = DB.indexOf(p);
        if(indexToUpdate >= 0){
            DB.set(indexToUpdate, game_update);
        }
        return 0;}).orElse(0);
    }
}
