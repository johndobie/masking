package com.sdbc.masking.transformer;

import com.sdbc.masking.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerMaskTransformer {

    public static final String DOB_DEFAULT = "****-**-**";
    public static final String NI_DEFAULT = "********";

    @Mapping(target="middleName", ignore = true)
    @Mapping(target="personalDetails.nationalInsuranceNumber", qualifiedByName = "nationalInsuranceNumber")
    @Mapping(target="personalDetails.dateOfBirth", qualifiedByName = "dateOfBirth")
    Customer getMaskedCustomer(Customer customer);

    @Named("dateOfBirth")
    default String maskDateOfBirth(String dob){
        return DOB_DEFAULT;
    }

    @Named("nationalInsuranceNumber")
    default String maskNationalInsuranceNumber(String nationalInsuranceNumber){
        return NI_DEFAULT;
    }
}


