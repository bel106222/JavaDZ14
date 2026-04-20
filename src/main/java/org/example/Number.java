package org.example;

public class Number {
    private int value;
    private String octValue;
    private String hexValue;
    private String binValue;
    private final NumberConversionService conversionService; // Поле для хранения сервиса

    public Number() {
        this(0, new DefaultNumberConversionService());
    }

    public Number(int value, NumberConversionService conversionService) {
        this.value = value;
        this.conversionService = conversionService;
        convert();
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
        convert();
    }

    private void convert() {
        this.octValue = conversionService.toOct(this.value);
        this.hexValue = conversionService.toHex(this.value);
        this.binValue = conversionService.toBin(this.value);
    }

    @Override
    public String toString(){
        return "DEC: " + this.value + ", OCT: " + this.octValue + ", HEX: " + this.hexValue + ", BIN: " + this.binValue;
    }
}