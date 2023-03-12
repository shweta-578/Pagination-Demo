package com.paginationDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
    public Country(int id, String name, String capital, String currency, Long population) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.currency = currency;
        this.population = population;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  int id;

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    private String name;
    private String capital;
    private  String currency;
    private Long population;

}
