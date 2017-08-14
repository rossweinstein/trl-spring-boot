package com.flyingnewt.model.patron.personalInformation;

import com.flyingnewt.model.patron.personalInformation.address.Address;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "line1", column = @Column(name = "local_address_line1")),
            @AttributeOverride(name = "line2", column = @Column(name = "local__address_line2")),
            @AttributeOverride(name = "city", column = @Column(name = "local__address_city")),
            @AttributeOverride(name = "state", column = @Column(name = "local__address_state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "local__address_zipCode"))
    })
    private Address localAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "line1", column = @Column(name = "permanent_address_line1")),
            @AttributeOverride(name = "line2", column = @Column(name = "permanent__address_line2")),
            @AttributeOverride(name = "city", column = @Column(name = "permanent__address_city")),
            @AttributeOverride(name = "state", column = @Column(name = "permanent__address_state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "permanent__address_zipCode"))
    })
    private Address permanentAddress;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private EmailAddress emailAddress;
}
