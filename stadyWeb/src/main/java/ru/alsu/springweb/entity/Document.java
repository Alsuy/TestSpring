package ru.alsu.springweb.entity;

import org.springframework.stereotype.Component;
import ru.alsu.springweb.StatusDocument.DocumentState;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Component
@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "object")
    // @NotEmpty(message = "Name should not be empty")
    private String object;

    @Column(name = "day_start")
    private Date dayStart;

    @Column(name = "day_end")
    //@NotEmpty(message = "Name should not be empty")
    private Date dayEnd;

    @Column(name = "status")
    private String statusName;

    @Column(name = "text")
    //@NotEmpty(message = "Name should not be empty")
    private String text;

    @Column(name = "idauthor")
    private int author;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "executor",
            joinColumns = @JoinColumn(name = "instruction_id"),
            inverseJoinColumns = @JoinColumn(name = "worker_id"))
    private Set<Worker> executor;

    private DocumentState documentState;

    private boolean errorDocument;

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

    public void nextDocumStatus() {
        documentState.nextDocumStatus(this);
    }

    public boolean isErrorDocument() {
        return errorDocument;
    }

    public void setErrorDocument(boolean errorDocument) {
        this.errorDocument = errorDocument;
    }

    public String getStatusName() {
        return documentState.getStatusName();
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Set<Worker> getExecutor() {
        return executor;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public void setExecutor(Set<Worker> executor) {
        this.executor = executor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
