package org.test.springblogricette.model;

import jakarta.persistence.*;

@Entity
public class Ricette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titolo;

    @Lob
    private String ingredienti;
    private String urlFoto;
    private int tempoPreparazione;
    private int porzioni;
    @Lob
    private String testoRicetta;


}
