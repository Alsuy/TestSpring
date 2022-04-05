package ru.alsu.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alsu.springweb.entity.Organization;
import ru.alsu.springweb.repositories.OrganizationRepository;

import java.util.List;

@Component
public class OrganizationService  {
    private  OrganizationRepository repository;

    @Autowired
    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public List<Organization> getList() {
        return this.repository.getList();
    }
}
