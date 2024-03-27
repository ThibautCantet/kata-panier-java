package org.kata.panier;

public class SubjectUnderTest {
    public float execute(int ht, Float taxeRate, boolean isImported) {
        if (taxeRate != null) {
            if (isImported && ht == 1000) {
                return ht * (1 + taxeRate / 100) * (1 + 5f / 100);
            } else if (isImported) {
                if (taxeRate >= 5 && taxeRate % 2 == 1) {
                    return ht * (1 + taxeRate / 100) * (1 + 2f / 100);
                }  else {
                    return ht * (1 + taxeRate / 100) * (1 + 5f / 100);
                }
            }
            if (ht % 2 == 1 && taxeRate > 10) {
                return ht * (1 + (taxeRate -2) / 100);
            }
            return ht * (1 + taxeRate / 100);
        }
        return 10;
    }
}
