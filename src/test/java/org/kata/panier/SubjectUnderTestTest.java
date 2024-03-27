package org.kata.panier;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SubjectUnderTestTest {

    @Nested
    class NotImported {
        @Test
        void should_add_vat() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(10, 5.0f, false);

            assertThat(result).isEqualTo(10.5f);
        }

        @Test
        void should_add_vat_and_taxe_for_expensive_good() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(1001, 15.0f, false);

            assertThat(result).isEqualTo(1131.13f);
        }
    }

    @Nested
    class Imported {
        @Test
        void should_add_taxe_for_expensive_good_costing_1000() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(1000, 5.0f, true);

            assertThat(result).isEqualTo(1102.5f);
        }

        @Test
        void should_add_high_odd_taxe() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(10, 5.0f, true);

            assertThat(result).isEqualTo(10.71f);
        }

        @Test
        void should_add_high_even_taxe() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(10, 6.0f, true);

            assertThat(result).isEqualTo(11.129999f);
        }

        @Test
        void should_add_low_odd_taxe() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(10, 3.0f, true);

            assertThat(result).isEqualTo(10.814999f);
        }

        @Test
        void should_add_low_even_taxe() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(10, 4.0f, true);

            assertThat(result).isEqualTo(10.919999f);
        }
    }

    @Test
    void should_not_add_vat_when_vat_is_null() {
        var subjectUnderTest = new SubjectUnderTest();

        var result = subjectUnderTest.execute(10, null, true);

        assertThat(result).isEqualTo(10f);
    }
}
