package com.flyingnewt.modelTest.contactInformationTest;

import com.flyingnewt.model.contactInformation.Name;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
public class NameTest {

    private Name emptyName;
    private Name fullName;
    private Name firstAndLast;

    @Before
    public void setUp() {
        this.emptyName = new Name();
        this.fullName = new Name("Linus", "Newt", "Shmi");
        this.firstAndLast = new Name("Linus", "Shmi");
    }

    @Test
    public void properEmptyName() {
        assertThat(this.emptyName.getFullName()).isEqualTo("");
    }

    @Test
    public void properFullName() {
        assertThat(this.fullName.getFullName()).isEqualTo("Linus Newt Shmi");
    }

    @Test
    public void properFirstAndLastName() {
        assertThat(this.firstAndLast.getFullName()).isEqualTo("Linus Shmi");
    }
}
