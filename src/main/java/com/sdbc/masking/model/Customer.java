package com.sdbc.masking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String firstName;
    private String middleName;
    private String lastName;

    private PersonalDetails personalDetails;
}
