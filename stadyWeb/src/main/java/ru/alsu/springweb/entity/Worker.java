package ru.alsu.springweb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "patronymic")
    private String patronymic;
    @ManyToOne (fetch = FetchType.LAZY)
    private Division divisions;
    private int idOrganization=1;
    @ManyToOne (fetch = FetchType.LAZY)
    private Position position;
    //@ManyToMany (mappedBy = "executor")
    //private Set<Document> document;
    public Worker(){}

    public int getId() {
        return id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    public Division getDivisions() {
        return divisions;
    }

    public void setDivisions(Division divisions) {
        this.divisions = divisions;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


}
