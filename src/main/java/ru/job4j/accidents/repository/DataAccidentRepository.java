package ru.job4j.accidents.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.accidents.model.Accident;

import java.util.Collection;
import java.util.Optional;

public interface DataAccidentRepository extends CrudRepository<Accident, Integer> {

    @Override
    Collection<Accident> findAll();

    @Override
    @EntityGraph(value = Accident.RULES, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Accident> findById(Integer id);
}
