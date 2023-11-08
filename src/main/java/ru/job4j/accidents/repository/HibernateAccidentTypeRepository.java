package ru.job4j.accidents.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.AccidentType;

import java.util.Collection;
import java.util.Map;

@Repository
@AllArgsConstructor
public class HibernateAccidentTypeRepository implements AccidentTypeRepository {
    private final CrudRepository crudRepository;

    @Override
    public Collection<AccidentType> findAll() {
        return crudRepository.query(
                "from AccidentType", AccidentType.class);
    }

    @Override
    public AccidentType findById(int accidentTypeId) {
        return crudRepository.getSingleResult(
                "from AccidentType where id = :fId", AccidentType.class,
                Map.of("fId", accidentTypeId)
        );
    }
}
