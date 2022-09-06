package fr.m2i.fil_rouge_spring.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calendrier")
public class Calendrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalendrier")
    private Integer _id;

    @Basic
    @Column(name = "mois")
    private Integer mois;

    @Basic
    @Column(name = "date")
    private String date;

    public Calendrier() {

    }

    public Calendrier(Integer mois, String date) {
        super();
        this.mois = mois;
        this.date = date;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}