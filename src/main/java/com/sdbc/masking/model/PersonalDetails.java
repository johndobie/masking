package com.sdbc.masking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalDetails {

    private String nationalInsuranceNumber;
    private String dateOfBirth;
}
