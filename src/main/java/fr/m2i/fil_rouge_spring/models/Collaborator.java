package fr.m2i.fil_rouge_spring.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "collaborator")
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer _id;

    @Basic
    @Column(name = "user_id")
    private Integer user;

    @ManyToOne()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_collabo_id")
    private User user_collabo_id;

    @Basic
    @Column(name = "edit")
    private Boolean edit;

    @Basic
    @Column(name = "see")
    private Boolean see;

    @Basic
    @Column(name = "share")
    private Boolean share;

    public Collaborator() {
        super();
    }

    public Collaborator(Integer user_id, User user_collabo_id, Boolean edit, Boolean see, Boolean share) {
        super();
        this.user = user_id;
        this.user_collabo_id = user_collabo_id;
        this.edit = edit;
        this.see = see;
        this.share = share;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }


    public User getUser_collabo_id() {
        return user_collabo_id;
    }

    public void setUser_collabo_id(User user_collabo_id) {
        this.user_collabo_id = user_collabo_id;
    }

    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    public Boolean getSee() {
        return see;
    }

    public void setSee(Boolean see) {
        this.see = see;
    }

    public Boolean getShare() {
        return share;
    }

    public void setShare(Boolean share) {
        this.share = share;
    }


}