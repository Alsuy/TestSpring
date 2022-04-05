package ru.alsu.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alsu.springweb.entity.Organization;
import ru.alsu.springweb.services.OrganizationService;

import java.util.List;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationEntityService) {
        this.organizationService = organizationEntityService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Organization> list = this.organizationService.getList();
        model.addAttribute("organization", list);
        return "organization/index";
    }
}
