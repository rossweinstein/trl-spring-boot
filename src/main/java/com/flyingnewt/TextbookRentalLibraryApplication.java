package com.flyingnewt;

import com.flyingnewt.model.copy.Copy;
import com.flyingnewt.model.patron.Patron;
import com.flyingnewt.repositories.CopyRepository;
import com.flyingnewt.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TextbookRentalLibraryApplication implements CommandLineRunner{

	@Autowired
	private CopyRepository copyRepository;
	@Autowired
	private PatronRepository patronRepository;

	public static void main(String[] args) {
		SpringApplication.run(TextbookRentalLibraryApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Copy clawdius = copyRepository.findOne(1L);
		Patron newt = patronRepository.findOne(1L);
		newt.checkCopyOut(clawdius);
		//newt.getContactInfo().setPhoneNumber(new PhoneNumber("6514529687"));
		patronRepository.saveAndFlush(newt);







	}
}
