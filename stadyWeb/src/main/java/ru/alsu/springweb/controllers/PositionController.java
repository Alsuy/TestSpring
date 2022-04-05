package ru.alsu.springweb.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alsu.springweb.entity.Position;
import ru.alsu.springweb.services.PositionService;

import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Position> list = this.positionService.getList();
        model.addAttribute("massed", list);
        return "position/index";
    }

    @GetMapping("/new")
    public String newPosition(@ModelAttribute("position") Position position) {

        return "position/new";
    }

    @PostMapping()
    public String createPosition(@ModelAttribute("position") @Valid Position position, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "position/new";
        positionService.save(position);
        return "redirect:/position";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("position", positionService.show(id));
        return "position/edit";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("position", positionService.show(id));
        return "position/show";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Position position, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "position/edit";

        positionService.update(id, position);
        return "redirect:/position";
    }

    @PostMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        positionService.delete(id);
        return "redirect:/position";
    }
}
