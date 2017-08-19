package com.flyingnewt.modelTest.contactInformationTest.addressTest;

import com.flyingnewt.model.contactInformation.address.Address;
import com.flyingnewt.model.contactInformation.address.USState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
public class AddressTest {

    private Address testAddress;

    @Before
    public void setUp() {
        this.testAddress = new Address();
    }

    @Test
    public void setAddress() {
        this.testAddress.setLine1("123 Main St.");
        this.testAddress.setLine2("Apt A");
        this.testAddress.setCity("Minneapolis");
        this.testAddress.setState(USState.MN);
        this.testAddress.setZipCode("55456");
        assertThat(this.testAddress.getLine1()).isEqualTo("123 Main St.");
        assertThat(this.testAddress.getLine2()).isEqualTo("Apt A");
        assertThat(this.testAddress.getCity()).isEqualTo("Minneapolis");
        assertThat(this.testAddress.getState()).isEqualTo(USState.MN);
        assertThat(this.testAddress.getZipCode()).isEqualTo("55456");
    }

    @Test
    public void canSet9DigitZip() {
        this.testAddress.setZipCode("123456789");
        assertThat(this.testAddress.getZipCode()).isEqualTo("123456789");
    }

    @Test
    public void cannotSetInvalidZipCode() {
        this.testAddress.setZipCode("asdf");
        assertThat(this.testAddress.getZipCode()).isEqualTo("");
    }

    @Test
    public void equalsWorks1() {
        assertThat(this.testAddress).isEqualTo(new Address());
    }

    @Test
    public void equalAndToStringWorks2() {
        this.testAddress.setLine1("123 Main St.");
        this.testAddress.setLine2("Apt A");
        this.testAddress.setCity("Minneapolis");
        this.testAddress.setState(USState.MN);
        this.testAddress.setZipCode("55456");

        Address address2 = new Address();
        address2.setLine1("123 Main St.");
        address2.setLine2("Apt A");
        address2.setCity("Minneapolis");
        address2.setState(USState.MN);
        address2.setZipCode("55456");

        assertThat(this.testAddress).isEqualTo(address2);
        assertThat(this.testAddress.toString()).isEqualTo(address2.toString());
    }

    @Test
    public void equalWorks3() {
        this.testAddress.setLine1("123 Main St.");
        this.testAddress.setLine2("Apt A");
        this.testAddress.setCity("Minneapolis");
        this.testAddress.setState(USState.MN);
        this.testAddress.setZipCode("55456");

        assertThat(this.testAddress).isNotEqualTo(new Address());
        assertThat(this.testAddress.toString()).isNotEqualTo(new Address().toString());
    }
}
