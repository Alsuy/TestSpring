package ru.alsu.springweb.entity;
//Отдел

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name ="name")
    private String name;
    @Column (name ="contracts")
    private String contracts;
    @ManyToOne (fetch = FetchType.LAZY)
   private Worker boss;
    public int getId() {
        return id;
    }

    public Division() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public Worker getBoss() {
        return boss;
    }

    public void setBoss(Worker boss) {
        this.boss = boss;
    }
}
