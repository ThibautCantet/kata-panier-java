package org.kata.panier;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SubjectUnderTestTest {

    @Test
    void should_add_vat() {
        var subjectUnderTest = new SubjectUnderTest();

        var result = subjectUnderTest.execute(10, 5.0f, false);

        assertThat(result).isEqualTo(10.5f);
    }

    @Test
    void should_add_vat_and_imported_taxe_for_expensive_good() {
        var subjectUnderTest = new SubjectUnderTest();

        var result = subjectUnderTest.execute(1000, 5.0f, true);

        assertThat(result).isEqualTo(1102.5f);
    }

    @Test
    void should_add_vat_and_imported_taxe_for_cheap_good() {
        var subjectUnderTest = new SubjectUnderTest();

        var result = subjectUnderTest.execute(10, 15.0f, true);

        assertThat(result).isEqualTo(11.73f);
    }

    @Test
    void should_not_add_vat_when_vat_is_null() {
        var subjectUnderTest = new SubjectUnderTest();

        var result = subjectUnderTest.execute(10, null, true);

        assertThat(result).isEqualTo(10f);
    }
}
