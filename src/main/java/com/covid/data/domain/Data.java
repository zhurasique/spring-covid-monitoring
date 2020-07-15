package com.covid.data.domain;

import javax.persistence.*;
import lombok.ToString;

@Entity
@Table
@ToString(of = {"id", "name"})
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private int cases;

    @Column(nullable = false)
    private int deaths;

    @Column(nullable = false)
    private int recovered;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }
}
