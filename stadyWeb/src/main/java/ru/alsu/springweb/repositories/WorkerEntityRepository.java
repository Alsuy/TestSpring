package ru.alsu.springweb.repositories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.alsu.springweb.bl.SessionUtil;
import ru.alsu.springweb.entity.Position;
import ru.alsu.springweb.entity.Worker;

import java.util.List;

@Component
public class WorkerEntityRepository extends SessionUtil implements WorkerRepository {
    @Override
    public List<Worker> getList() {
        openTransactionSession();
        String sql = "SELECT * FROM worker";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Worker.class);
        List<Worker> workerList = query.list();
        closeTransactionSession();
        return workerList;
    }

    @Override
    public void add(Worker worker) {
        openTransactionSession();
        Session session = getSession();
        session.save(worker);
        closeTransactionSession();
    }

    @Override
    public Worker show(int id) {
        openTransactionSession();
        String sql = "SELECT * FROM worker WHERE ID = :id";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Position.class);
        query.setParameter("id", id);
        Worker worker = (Worker) query.uniqueResult();
        closeTransactionSession();
        return worker;
    }

    @Override
    public void update(Worker worker) {
        openTransactionSession();
        Session session = getSession();
        session.update(worker);
        closeTransactionSession();
    }

    @Override
    public void delete(int id) {
        openTransactionSession();
        String sql = "SELECT * FROM worker WHERE ID = :id";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Position.class);
        query.setParameter("id", id);
        Worker worker = (Worker) query.uniqueResult();
        session.delete(worker);
        closeTransactionSession();
    }
}
