package org.kata.panier;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SubjectUnderTestTest {

    @Nested
    class NotImported {
        @Test
        void should_add_minored_taxe_when_odd_ht_and_high_taxe() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(11, 11.0f, false);

            assertThat(result).isEqualTo(11.990001f);
        }

        @Test
        void should_add_taxe_when_even_ht_and_high_taxe() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(10, 11.0f, false);

            assertThat(result).isEqualTo(11.1f);
        }

        @Test
        void should_add_taxe_when_odd_ht_and_low_taxe() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(11, 10.0f, false);

            assertThat(result).isEqualTo(12.1f);
        }

        @Test
        void should_add_taxe_when_even_ht_and_low_taxe() {
            var subjectUnderTest = new SubjectUnderTest();

            var result = subjectUnderTest.execute(10, 9.0f, false);

            assertThat(result).isEqualTo(10.900001f);
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
