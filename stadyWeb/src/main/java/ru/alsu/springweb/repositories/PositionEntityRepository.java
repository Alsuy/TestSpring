package ru.alsu.springweb.repositories;

import org.hibernate.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.alsu.springweb.bl.SessionUtil;
import ru.alsu.springweb.entity.Position;

import java.util.List;
@Component
public class PositionEntityRepository extends SessionUtil implements PositionRepository {

    @Override
    public List<Position> getList()  {
        openTransactionSession();
        String sql = "SELECT * FROM position";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Position.class);
        List<Position> positionList = query.list();
        closeTransactionSession();
        return positionList;
    }
    public void add(Position position) {
        openTransactionSession();
        Session session = getSession();
        session.save(position);
        closeTransactionSession();
    }

    @Override
    public Position show(int id) {
        openTransactionSession();
        String sql = "SELECT * FROM position WHERE ID = :id";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Position.class);
        query.setParameter("id", id);
        Position position = (Position) query.uniqueResult();
        closeTransactionSession();
        return position;
    }

    @Override
    public void update(Position position) {
        openTransactionSession();
        Session session = getSession();
        session.update(position);
        closeTransactionSession();
    }

    @Override
    public void delete(int id) {
        openTransactionSession();
        String sql = "SELECT * FROM position WHERE ID = :id";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Position.class);
        query.setParameter("id", id);
        Position position = (Position) query.uniqueResult();
        session.delete(position);
        closeTransactionSession();
    }

}
