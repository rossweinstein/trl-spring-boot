package com.flyingnewt.repositoriesTest;

import com.flyingnewt.model.contactInformation.address.Address;
import com.flyingnewt.model.contactInformation.address.USState;
import com.flyingnewt.model.contactInformation.ContactInformation;
import com.flyingnewt.model.contactInformation.EmailAddress;
import com.flyingnewt.model.contactInformation.Name;
import com.flyingnewt.model.contactInformation.PhoneNumber;
import com.flyingnewt.model.libraryCopy.Copy;
import com.flyingnewt.model.libraryCopy.book.Book;
import com.flyingnewt.model.patron.Patron;
import com.flyingnewt.repositories.CopyRepository;
import com.flyingnewt.repositories.PatronRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PatronRepositoryTest {

    @Autowired
    private PatronRepository patronRepository;

    @Autowired
    private CopyRepository copyRepository;


    @Test
    public void addPatronToDatabase() throws Exception {

        Address address = new Address("123 Main St.", "Apt. 1", "St. Paul", USState.MN, "55145");
        ContactInformation contact = new ContactInformation(address, new PhoneNumber("6514259865"), new EmailAddress("email@email.com"));
        Patron testPatron = new Patron();
        testPatron.setName(new Name("Ross", "Alexander", "Weinstein"));
        testPatron.setContactInfo(contact);
        testPatron.setCopiesOut(new ArrayList<>());

        patronRepository.save(testPatron);

        Patron shouldBeTestPatron = patronRepository.getOne(1L);

        assertThat(shouldBeTestPatron).isEqualTo(testPatron);
    }

    @Test
    public void patronChecksOutCopy() throws Exception {

        Address address = new Address("123 Main St.", "Apt. 1", "St. Paul", USState.MN, "55145");
        ContactInformation contact = new ContactInformation(address, new PhoneNumber("6514259865"), new EmailAddress("email@email.com"));
        Patron testPatron = new Patron();
        testPatron.setName(new Name("Ross", "Alexander", "Weinstein"));
        testPatron.setContactInfo(contact);
        testPatron.setCopiesOut(new ArrayList<>());

        Copy testCopy = new Copy(new Book(), new Date());
        copyRepository.saveAndFlush(testCopy);

        testPatron.checkCopyOut(testCopy);
        patronRepository.saveAndFlush(testPatron);

        Copy undamagedCopy = copyRepository.findByDamagedIsFalse().get(0);

        assertThat(undamagedCopy).isEqualTo(testCopy);



    }
}
