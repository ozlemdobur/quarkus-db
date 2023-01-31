package org.acme.dto;

public class GenerateRandomNumbers {
    private Integer[] generatedRandomNumbers;

    public GenerateRandomNumbers() {
    }

    public GenerateRandomNumbers(Integer[] generatedRandomNumbers) {
        this.generatedRandomNumbers = generatedRandomNumbers;
    }

    public Integer[] getGeneratedRandomNumbers() {
        return generatedRandomNumbers;
    }

    public void setGeneratedRandomNumbers(Integer[] generatedRandomNumbers) {
        this.generatedRandomNumbers = generatedRandomNumbers;
    }
}
