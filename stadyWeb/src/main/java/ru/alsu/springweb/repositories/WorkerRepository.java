package ru.alsu.springweb.repositories;

import ru.alsu.springweb.entity.Position;
import ru.alsu.springweb.entity.Worker;

import java.util.List;

public interface WorkerRepository {
    public List<Worker> getList() ;
    public void add(Worker worker);
    public Worker show(int id);
    public void update(Worker worker);
    public void delete(int id);
}
