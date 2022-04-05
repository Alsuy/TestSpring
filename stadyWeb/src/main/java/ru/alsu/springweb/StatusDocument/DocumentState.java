package ru.alsu.springweb.StatusDocument;
import ru.alsu.springweb.entity.Document;

public interface DocumentState {
    String getStatusName();
    void nextDocumStatus(Document document);

}
