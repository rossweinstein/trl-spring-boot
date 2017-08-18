package com.flyingnewt.modelTest.contactInformationTest;

import com.flyingnewt.model.contactInformation.EmailAddress;
import org.hibernate.validator.constraints.Email;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
public class EmailAddressTest {

    private EmailAddress testEmail;
    private EmailAddress otherEmail;

    @Before
    public void setUp() {
        this.testEmail = new EmailAddress("myEmail@email.com");
        this.otherEmail = new EmailAddress("myOtherEmail@email.com");
    }

    @Test
    public void validEmailIsValid() {
        assertThat(this.testEmail.getEmail()).isEqualTo("myEmail@email.com");
    }

    @Test
    public void invalidEmailDoesNotChangeEmail() {
        this.testEmail.setEmail("sajfhsa");
        assertThat(this.testEmail.getEmail()).isEqualTo("myEmail@email.com");
    }

    @Test
    public void invalidEmailDoesNotChangeEmail2() {
        this.testEmail.setEmail("sajfhsa@alsdkfj");
        assertThat(this.testEmail.getEmail()).isEqualTo("myEmail@email.com");
    }

    @Test
    public void invalidEmailDoesNotChangeEmail3() {
        this.testEmail.setEmail("sajfhsa@asjdflkj.asdfkjo.askdfoj");
        assertThat(this.testEmail.getEmail()).isEqualTo("myEmail@email.com");
    }

    @Test
    public void invlidEmailAtCreationBecomeBlankString() {
        EmailAddress email = new EmailAddress("asdfjklsa");
        assertThat(email.getEmail()).isEqualTo("");
    }

    @Test
    public void equalMethodsWorks() {
        EmailAddress email = new EmailAddress("myEmail@email.com");
        assertThat(this.testEmail).isEqualTo(email);
    }

    @Test
    public void equalMethodsWorks2() {
        assertThat(this.testEmail).isNotEqualTo(this.otherEmail);
    }

    @Test
    public void toStringWorks() {
        EmailAddress email = new EmailAddress("myEmail@email.com");
        assertThat(this.testEmail.toString()).isEqualTo(email.toString());
    }

    @Test
    public void toStringWorks2() {
        assertThat(this.testEmail.toString()).isNotEqualTo(this.otherEmail);
    }


}
