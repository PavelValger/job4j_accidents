package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.AccidentType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryAccidentTypeRepository implements AccidentTypeRepository {
    private final Map<Integer, AccidentType> types = new HashMap<>();

    public MemoryAccidentTypeRepository() {
        types.put(1, new AccidentType(1, "Две машины"));
        types.put(2, new AccidentType(2, "Машина и человек"));
        types.put(3, new AccidentType(3, "Машина и велосипед"));
    }

    @Override
    public Collection<AccidentType> findAll() {
        return types.values();
    }
}