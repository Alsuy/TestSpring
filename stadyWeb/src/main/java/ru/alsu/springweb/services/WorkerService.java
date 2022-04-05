package ru.alsu.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alsu.springweb.entity.User;
import ru.alsu.springweb.entity.Worker;
import ru.alsu.springweb.repositories.WorkerRepository;

import java.util.List;

@Component
public class WorkerService {
    private final WorkerRepository repository;
    //private Worker user;

    @Autowired
    public WorkerService(WorkerRepository repository) {
        this.repository = repository;
    }
//
//    public Worker getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public List<Worker> getList() {
        return this.repository.getList();
    }

    public void save(Worker worker) {
        this.repository.add(worker);
    }

    public Object show(int id) {
        return this.repository.show(id);
    }

    public void update(int id, Worker worker) {
        this.repository.update(worker);
    }

    public void delete(int id) {
        this.repository.delete(id);
    }
}
