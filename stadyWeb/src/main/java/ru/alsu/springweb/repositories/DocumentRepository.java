package ru.alsu.springweb.repositories;

import ru.alsu.springweb.entity.Document;

import java.util.List;

public interface DocumentRepository {
    public List<Document> getList();
    public void add(Document instruction);
    public Document show(int id);
    public void update(Document instruction);
    public void delete(int id);
}
