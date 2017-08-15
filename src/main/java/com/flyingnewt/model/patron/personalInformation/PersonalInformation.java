package com.flyingnewt.model.patron.personalInformation;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@NoArgsConstructor
public class PersonalInformation {

    @Embedded
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "line1", column = @Column(name = "local_address_line1")),
            @AttributeOverride(name = "line2", column = @Column(name = "local_address_line2")),
            @AttributeOverride(name = "city", column = @Column(name = "local_address_city")),
            @AttributeOverride(name = "state", column = @Column(name = "local_address_state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "local_address_zip_code"))})
    private Address localAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "line1", column = @Column(name = "permanent_address_line1")),
            @AttributeOverride(name = "line2", column = @Column(name = "permanent_address_line2")),
            @AttributeOverride(name = "city", column = @Column(name = "permanent_address_city")),
            @AttributeOverride(name = "state", column = @Column(name = "permanent_address_state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "permanent_address_zip_code"))})
    private Address permanentAddress;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private EmailAddress emailAddress;
}
