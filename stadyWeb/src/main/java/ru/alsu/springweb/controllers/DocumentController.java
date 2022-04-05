package ru.alsu.springweb.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alsu.springweb.entity.Document;

import ru.alsu.springweb.services.DocumentService;

import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {
    private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentListService) {
        this.documentService = documentListService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Document> list = this.documentService.getList();
        model.addAttribute("documents", list);
        return "document/index";
    }

    @GetMapping("/new")
    public String newDocument(@ModelAttribute("document") Document document) {
        return "document/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("document") Document document) {
        documentService.save(document);
        return "redirect:/document";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("document", documentService.show(id));
        return "document/edit";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("document", documentService.show(id));
        return "document/show";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("document") Document document,
                         @PathVariable("id") int id) {
        documentService.update(id, document);
        return "redirect:/document";
    }

    @PostMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        documentService.delete(id);
        return "redirect:/document";
    }

}
