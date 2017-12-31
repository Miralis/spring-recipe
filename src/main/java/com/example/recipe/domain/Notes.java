package com.example.recipe.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // we don't want a cascade here
    @OneToOne
    private Recipe recipe;

    // Lob is for large object storage
    // Lob helps to increase the number of characters possible for the notes
    @Lob
    private String recipeNotes;

}
