package ru.alsu.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alsu.springweb.StatusDocument.DocumentState;
import ru.alsu.springweb.StatusDocument.PreparationDocument;
import ru.alsu.springweb.entity.Document;
import ru.alsu.springweb.entity.User;
import ru.alsu.springweb.entity.Worker;
import ru.alsu.springweb.repositories.DocumentRepository;

import java.util.List;

@Component
public class DocumentService {
    private DocumentRepository repository;
    private User user;

    @Autowired
    public DocumentService(DocumentRepository repository, User user) {
        this.repository = repository;
        this.user=user;
    }

    public List<Document> getList()  {
        return this.repository.getList();
    }

    public void save(Document document) {
        document.setAuthor(user.getId());
        PreparationDocument documentState = new PreparationDocument();
        document.setDocumentState(documentState);
        this.repository.add(document);
    }

    public Object show(int id) {
        return this.repository.show(id);
    }

    public void update(int id, Document document) {
        this.repository.update(document);
    }

    public void delete(int id) {
        this.repository.delete(id);
    }
}
