package org.example;

public class DefaultNumberConversionService implements NumberConversionService{
    @Override
    public String toOct(int value) {
        return Integer.toOctalString(value);
    }

    @Override
    public String toHex(int value) {
        return Integer.toHexString(value).toUpperCase();
    }

    @Override
    public String toBin(int value) {
        return Integer.toBinaryString(value);
    }
}