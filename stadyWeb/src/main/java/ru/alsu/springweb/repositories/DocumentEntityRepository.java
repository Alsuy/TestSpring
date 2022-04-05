package ru.alsu.springweb.repositories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.alsu.springweb.bl.SessionUtil;
import ru.alsu.springweb.entity.Document;
import ru.alsu.springweb.entity.Position;


import java.util.List;

@Component
public class DocumentEntityRepository extends SessionUtil implements DocumentRepository {

    @Override
    public List<Document> getList() {
        this.openTransactionSession();
        Session session = getSession();
        String sql = "SELECT * FROM document";
        Query query = session.createSQLQuery(sql).addEntity(Document.class);
        List<Document> instructionList = query.list();
        closeTransactionSession();
        return instructionList;
    }

    public void add(Document document) {
        this.openTransactionSession();
        Session session = getSession();
        session.save(document);
        this.closeTransactionSession();
    }

    @Override
    public Document show(int id) {
        this.openTransactionSession();
        String sql = "SELECT * FROM document WHERE ID = :id";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Position.class);
        query.setParameter("id", id);
        Document document = (Document) query.uniqueResult();
        this.closeTransactionSession();
        return document;
    }

    @Override
    public void update(Document document) {
        this.openTransactionSession();
        Session session = getSession();
        session.update(document);
        this.closeTransactionSession();
    }

    @Override
    public void delete(int id) {
        this.openTransactionSession();
        String sql = "SELECT * FROM document WHERE ID = :id";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Position.class);
        query.setParameter("id", id);
        Document document = (Document) query.uniqueResult();
        session.delete(document);
        this.closeTransactionSession();
    }
}
