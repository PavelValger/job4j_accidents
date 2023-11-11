package ru.job4j.accidents.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.accidents.model.Accident;

public interface DataAccidentRepository extends CrudRepository<Accident, Integer> {

    @EntityGraph(value = Accident.RULES)
    @Query("from Accident where id = :id")
    Accident findByIdFetchRules(@Param("id") int id);
}
