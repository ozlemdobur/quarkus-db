package org.acme.dto;

public class StaticticsResult {
    private Integer sum;
    private Double average;
    private Integer min;
    private Integer max;

    public StaticticsResult() {
    }

    public StaticticsResult(Integer sum, Double average, Integer min, Integer max) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "StaticticsResult{" +
                "sum=" + sum +
                ", average=" + average +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
