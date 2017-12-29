package com.example.recipe.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    // ID is necessaary
    // IDENTITY is going to leverage the underlying persistence framework to generate an id value for us.
    // IDENTITY is a special type for relational dbs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    // mappedBy the property called "recipe"
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingedient> ingedients;

    // will be generated as a BLOB (binary large object) in the database
    @Lob
    private Byte[] image;

    // EnumType.Ordinal is the default, it would number the values (so HARD would be 3 for example)
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    // Creates the relationship for the OneToOne mapping
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Set<Ingedient> getIngedients() {
        return ingedients;
    }

    public void setIngedients(Set<Ingedient> ingedients) {
        this.ingedients = ingedients;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
