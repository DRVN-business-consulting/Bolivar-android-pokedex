package com.bolivar.myapplication.model;

public class pokemon {
    private int id;
    private String name;
    private int imageResId;
    private int pokemonType;
    private String type;
    private String description;


    public pokemon(int id, String name, int imageResId, int pokemonType,String type, String description) {
        this.id = id;
        this.name = name;
        this.imageResId = imageResId;
        this.pokemonType = pokemonType;
        this.type = type;
        this.description = description;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public int getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(int pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
