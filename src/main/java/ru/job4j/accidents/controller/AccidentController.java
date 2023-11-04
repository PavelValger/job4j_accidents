package ru.job4j.accidents.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.service.AccidentService;

@Controller
@AllArgsConstructor
@RequestMapping("/accidents")
public class AccidentController {
    private final AccidentService accidentService;

    /**
     * Вывести все нарушения
     */
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "accidents/list";
    }

    /**
     * Страница создания инцидента
     */
    @GetMapping("/create")
    public String getCreationPage() {
        return "accidents/create";
    }

    /**
     * Отправка формы создания инцидента
     */
    @PostMapping("/create")
    public String create(@ModelAttribute Accident accident) {
        accidentService.save(accident);
        return "redirect:/accidents";
    }

    /**
     * Страница редактирования инцидента
     */
    @GetMapping("/formUpdateAccident")
    public String getById(@RequestParam("id") int id, Model model) {
        var accidentOptional = accidentService.findById(id);
        if (accidentOptional.isEmpty()) {
            model.addAttribute("message", "Инцидент с указанным идентификатором не найден");
            return "errors/404";
        }
        model.addAttribute("accident", accidentOptional.get());
        return "accidents/edit";
    }

    /**
     * Отправка формы редактирования инцидента
     */
    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        accidentService.update(accident);
        return "redirect:/accidents";
    }
}