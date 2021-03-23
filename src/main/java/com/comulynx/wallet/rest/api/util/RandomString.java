package com.comulynx.wallet.rest.api.util;

import java.util.Objects;
import java.util.Random;

public class RandomString {
    private final Random random;
    private final char[] symbols;
    private final char[] buf;


    public RandomString(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }
}
