package com.rit.gameserver.api;

import com.rit.gameserver.model.Game;
import com.rit.gameserver.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/game")
@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/add")
    public void addGame(@Valid @NotBlank @RequestBody Game game){
        gameService.addGame(game);
    }

    @GetMapping("/getAll")
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping(path = "{id}")
    public Optional <Game> getGameById(@PathVariable("id") String id){
        return gameService.getGameById(id);
    }

    @DeleteMapping(path = "/deleteGame/{id}")
    public void deleteGameById(@PathVariable("id") String id){
         gameService.deleteGame(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllGames(){ gameService.deleteAllGames();}

    @PutMapping(path = "/{id}")
    public void updateGameById(@PathVariable("id") String id, Game game){ gameService.updateGame(id, game); }


}
