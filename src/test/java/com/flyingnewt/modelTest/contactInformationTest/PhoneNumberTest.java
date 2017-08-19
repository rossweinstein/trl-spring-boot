package com.flyingnewt.modelTest.contactInformationTest;

import com.flyingnewt.model.contactInformation.PhoneNumber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
public class PhoneNumberTest {

    private PhoneNumber validPhoneNumber;
    private PhoneNumber invalidPhoneNumber;


    @Before
    public void setUp() {
        this.validPhoneNumber = new PhoneNumber("6511234567");
        this.invalidPhoneNumber = new PhoneNumber("873643");
    }

    @Test
    public void emptyPhoneNumberIsBlankString() {
        PhoneNumber emptyPhoneNumber = new PhoneNumber();
        assertThat(emptyPhoneNumber.getNumber()).isEqualTo("");
    }

    @Test
    public void validPhoneNumberCanBeFormatted() {
        assertThat(this.validPhoneNumber.getFormattedTelephoneNumber()).isEqualTo("651.123.4567");
    }

    @Test
    public void cannotResetValidPhoneNumberAsInvalidOne() {
        this.validPhoneNumber.setNumber("234");
        assertThat(this.validPhoneNumber.getNumber()).isEqualTo("6511234567");
    }

    @Test
    public void canResetValidPhoneNumberToNewValidOne() {
        this.validPhoneNumber.setNumber("2345439876");
        assertThat(this.validPhoneNumber.getNumber()).isEqualTo("2345439876");
    }

    @Test
    public void equalsMethodWorks() {
        PhoneNumber otherNumber = new PhoneNumber("6511234567");
        assertThat(this.validPhoneNumber).isEqualTo(otherNumber);
    }

    @Test
    public void equalsMethodWorks2() {
        assertThat(this.validPhoneNumber).isNotEqualTo(this.invalidPhoneNumber);
    }

    @Test
    public void toStringWorks() {
        PhoneNumber otherNumber = new PhoneNumber("6511234567");
        assertThat(this.validPhoneNumber.toString()).isEqualTo(otherNumber.toString());
    }

    @Test
    public void toStringWorks2() {
        assertThat(this.validPhoneNumber.toString()).isNotEqualTo(this.invalidPhoneNumber.toString());
    }
}
