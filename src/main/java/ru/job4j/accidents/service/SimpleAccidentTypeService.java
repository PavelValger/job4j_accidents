package ru.job4j.accidents.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.repository.AccidentTypeRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class SimpleAccidentTypeService implements AccidentTypeService {
    private final AccidentTypeRepository jdbcAccidentTypeRepository;

    @Override
    public Collection<AccidentType> findAll() {
        return jdbcAccidentTypeRepository.findAll();
    }

    @Override
    public AccidentType findById(int accidentTypeId) {
        return jdbcAccidentTypeRepository.findById(accidentTypeId);
    }
}
