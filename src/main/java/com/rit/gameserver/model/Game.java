package com.rit.gameserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.lang.String;

@Document(collection = "games")
public class Game {

    @NotBlank
    private String name;

    @Id
    private String id;

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    private String category;

    @NotBlank

    private String url_game;
    private String url_image;

    private String description;


    public Game(@JsonProperty("id") String id,
                @JsonProperty("name") @NotBlank String name,
                @JsonProperty("category") String category ,
                @JsonProperty("url_game") @NotBlank String url_game ,
                @JsonProperty("url_image") String url_image,
                @JsonProperty("description") String description) {

        this.name = name;
        this.id = id;
        this.category = category;
        this.url_game = url_game;
        this.url_image = url_image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(@JsonProperty("category") String category) {
        this.category = category;
    }

    public String getUrl_game() {
        return url_game;
    }

    public void setUrl_game(@JsonProperty("url_game") String url_game) {
        this.url_game = url_game;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(@JsonProperty("url_image") String url_image) {
        this.url_image = url_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(@JsonProperty("description") String description) {
        this.description = description;
    }
}
