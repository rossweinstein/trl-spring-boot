package com.flyingnewt.model.patron.personalInformation.address;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zipCode;
}
