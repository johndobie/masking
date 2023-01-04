package com.sdbc.masking.transformer;

import com.sdbc.masking.model.Customer;
import com.sdbc.masking.model.PersonalDetails;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static com.sdbc.masking.transformer.CustomerMaskTransformer.DOB_DEFAULT;
import static com.sdbc.masking.transformer.CustomerMaskTransformer.NI_DEFAULT;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerMaskTransformerTest {

    private static final CustomerMaskTransformer customerMaskTransformer = Mappers.getMapper(CustomerMaskTransformer.class);

    @Test
    void testPersonalDetailsAreCorrect() {

        Customer customer = getCustomer();
        Customer maskedCustomer = customerMaskTransformer.getMaskedCustomer(customer);

        assertThat(maskedCustomer.getFirstName()).isEqualTo(customer.getFirstName());
        assertThat(maskedCustomer.getLastName()).isEqualTo(customer.getLastName());

        assertThat(maskedCustomer.getMiddleName()).isNull();
        assertThat(maskedCustomer.getPersonalDetails().getNationalInsuranceNumber()).isEqualTo(NI_DEFAULT);
        assertThat(maskedCustomer.getPersonalDetails().getDateOfBirth()).isEqualTo(DOB_DEFAULT);
    }

    private Customer getCustomer() {
        PersonalDetails personalDetails = PersonalDetails.builder()
                .nationalInsuranceNumber("1234567")
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
