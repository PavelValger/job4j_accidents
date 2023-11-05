package ru.job4j.accidents.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.service.AccidentService;
import ru.job4j.accidents.service.AccidentTypeService;
import ru.job4j.accidents.service.RuleService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/accidents")
public class AccidentController {
    private final AccidentService accidentService;
    private final AccidentTypeService accidentTypeService;
    private final RuleService ruleService;

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
    public String getCreationPage(Model model) {
        model.addAttribute("types", accidentTypeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        return "accidents/create";
    }

    /**
     * Отправка формы создания инцидента
     */
    @PostMapping("/create")
    public String create(@ModelAttribute Accident accident, @RequestParam List<Integer> rulesId) {
        accident.getRules().addAll(ruleService.findAllById(rulesId));
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
        model.addAttribute("types", accidentTypeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        return "accidents/edit";
    }

    /**
     * Отправка формы редактирования инцидента
     */
    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident, Model model, @RequestParam List<Integer> rulesId) {
        accident.getRules().addAll(ruleService.findAllById(rulesId));
        var isUpdated = accidentService.update(accident);
        if (!isUpdated) {
            model.addAttribute("message", "Инцидент с указанным идентификатором не найден");
            return "errors/404";
        }
        return "redirect:/accidents";
    }
}
