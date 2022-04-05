package ru.alsu.springweb.repositories;

import ru.alsu.springweb.entity.Position;

import java.util.List;

public interface PositionRepository {
    public List<Position> getList() ;
    public void add(Position position);
    public Position show(int id);
    public void update(Position position);
    public void delete(int id);

}
