package com.sdbc.masking.web.controller;

import com.sdbc.masking.model.Customer;
import com.sdbc.masking.model.PersonalDetails;
import com.sdbc.masking.transformer.CustomerMaskTransformer;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static final CustomerMaskTransformer customerMaskTransformer = Mappers.getMapper(CustomerMaskTransformer.class);

    @GetMapping("/customer")
    public Customer getCustomerEndpoint(){
        return getCustomer();
    }

    @GetMapping("/customer/masked")
    public Customer getMaskedCustomerEndpoint(){
        return customerMaskTransformer.getMaskedCustomer(getCustomer());
    }

    private Customer getCustomer() {
        PersonalDetails personalDetails = PersonalDetails.builder()
                .nationalInsuranceNumber("NS1234567")
                .dateOfBirth("1970-01-01")
                .build();

        Customer customer = Customer.builder().personalDetails(personalDetails)
                .firstName("John")
                .middleName("A")
                .lastName("Dobie")
                .build();

        return customer;
    }
}
