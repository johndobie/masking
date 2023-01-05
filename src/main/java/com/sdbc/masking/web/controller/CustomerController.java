package com.sdbc.masking.web.controller;

import com.sdbc.masking.model.CustomerDetails;
import com.sdbc.masking.model.PersonalDetails;
import com.sdbc.masking.transformer.CustomerMaskTransformer;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static final CustomerMaskTransformer customerMaskTransformer = Mappers.getMapper(CustomerMaskTransformer.class);

    @GetMapping("/customer")
    public CustomerDetails getCustomerEndpoint(){
        return getCustomer();
    }

    @GetMapping("/customer/masked")
    public CustomerDetails getMaskedCustomerEndpoint(){
        return customerMaskTransformer.getMaskedCustomer(getCustomer());
    }

    private CustomerDetails getCustomer() {
        PersonalDetails personalDetails = PersonalDetails.builder()
                .niNumber("NS1234567")
                .dateOfBirth("1970-01-01")
                .build();

        CustomerDetails customerDetails = CustomerDetails.builder().personalDetails(personalDetails)
                .firstName("John")
                .middleName("A")
                .lastName("Dobie")
                .build();

        return customerDetails;
    }
}
