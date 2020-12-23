package com.example.application.data.service;

import com.example.application.data.entity.CustomerList;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface CustomerListRepository extends JpaRepository<CustomerList, Integer> {

}