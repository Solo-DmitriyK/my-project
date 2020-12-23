package com.example.application.data.generator;

import com.vaadin.flow.spring.annotation.SpringComponent;

import com.example.application.data.service.CustomerListRepository;
import com.example.application.data.entity.CustomerList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.exampledata.DataType;
import org.vaadin.artur.exampledata.ExampleDataGenerator;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(CustomerListRepository customerListRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (customerListRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 100 Customer List entities...");
            ExampleDataGenerator<CustomerList> customerListRepositoryGenerator = new ExampleDataGenerator<>(
                    CustomerList.class);
            customerListRepositoryGenerator.setData(CustomerList::setId, DataType.ID);
            customerListRepositoryGenerator.setData(CustomerList::setId, DataType.NUMBER_UP_TO_1000);
            customerListRepositoryGenerator.setData(CustomerList::setFirstName, DataType.FIRST_NAME);
            customerListRepositoryGenerator.setData(CustomerList::setLastName, DataType.LAST_NAME);
            customerListRepositoryGenerator.setData(CustomerList::setEmail, DataType.EMAIL);
            customerListRepositoryGenerator.setData(CustomerList::setDateOfBirth, DataType.DATE_OF_BIRTH);
            customerListRepositoryGenerator.setData(CustomerList::setAmount, DataType.PRICE);
            customerListRepository.saveAll(customerListRepositoryGenerator.create(100, seed));

            logger.info("Generated demo data");
        };
    }

}