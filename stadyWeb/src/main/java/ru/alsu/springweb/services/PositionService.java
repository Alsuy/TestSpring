package ru.alsu.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alsu.springweb.entity.Position;
import ru.alsu.springweb.repositories.PositionRepository;

import java.util.List;

@Component
public class PositionService {
    private final PositionRepository repository;

    @Autowired
    public PositionService(PositionRepository repository) {
        this.repository = repository;
    }

    public List<Position> getList() {
        return this.repository.getList();
    }

    public void save(Position position) {
        this.repository.add(position);
    }

    public Object show(int id) {
        return this.repository.show(id);
    }

    public void update(int id, Position position) {
        this.repository.update(position);
    }

    public void delete(int id) {
        this.repository.delete(id);
    }
}
