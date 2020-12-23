package com.example.application.data.service;

import com.example.application.data.entity.CustomerList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import java.time.LocalDate;

@Service
public class CustomerListService extends CrudService<CustomerList, Integer> {

    private CustomerListRepository repository;

    public CustomerListService(@Autowired CustomerListRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CustomerListRepository getRepository() {
        return repository;
    }

}
