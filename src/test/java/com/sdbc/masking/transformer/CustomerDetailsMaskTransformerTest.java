package com.sdbc.masking.transformer;

import com.sdbc.masking.model.CustomerDetails;
import com.sdbc.masking.model.PersonalDetails;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static com.sdbc.masking.transformer.CustomerMaskTransformer.DOB_DEFAULT;
import static com.sdbc.masking.transformer.CustomerMaskTransformer.NI_DEFAULT;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerDetailsMaskTransformerTest {

private static final CustomerMaskTransformer customerMaskTransformer = Mappers.getMapper(CustomerMaskTransformer.class);

@Test
void testPersonalDetailsAreCorrect() {

    CustomerDetails customerDetails = getCustomerDetails();
    CustomerDetails maskedCustomerDetails = customerMaskTransformer.getMaskedCustomer(customerDetails);

    assertThat(maskedCustomerDetails.getFirstName()).isEqualTo(customerDetails.getFirstName());
    assertThat(maskedCustomerDetails.getLastName()).isEqualTo(customerDetails.getLastName());

    assertThat(maskedCustomerDetails.getMiddleName()).isNull();
    assertThat(maskedCustomerDetails.getPersonalDetails().getNiNumber()).isEqualTo(NI_DEFAULT);
    assertThat(maskedCustomerDetails.getPersonalDetails().getDateOfBirth()).isEqualTo(DOB_DEFAULT);
}

    private CustomerDetails getCustomerDetails() {
        PersonalDetails personalDetails = PersonalDetails.builder()
                .niNumber("1234567")
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
