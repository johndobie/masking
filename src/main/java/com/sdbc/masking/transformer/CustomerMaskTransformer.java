package com.sdbc.masking.transformer;

import com.sdbc.masking.model.CustomerDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerMaskTransformer {

    public static final String DOB_DEFAULT = "****-**-**";
    public static final String NI_DEFAULT = "********";

    @Mapping(target="middleName", ignore = true)
    @Mapping(target="personalDetails.niNumber", qualifiedByName = "niNumber")
    @Mapping(target="personalDetails.dateOfBirth", qualifiedByName = "dateOfBirth")
    CustomerDetails getMaskedCustomer(CustomerDetails customerDetails);

    @Named("dateOfBirth")
    default String maskDateOfBirth(String dob){
        return DOB_DEFAULT;
    }

    @Named("niNumber")
    default String maskNationalInsuranceNumber(String nationalInsuranceNumber){
        return NI_DEFAULT;
    }
}


