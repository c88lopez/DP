package com.cris.capo;

import java.util.List;

public class OutOfRangeSegregation implements SamplingStrategy {
    private static final int SLA_MIN = 1;
    private static final int SLA_MAX = 4;

    private SamplingStrategy strategy = null;
    private int minViolationCounter = 0;
    private int maxViolationCounter = 0;

    public OutOfRangeSegregation(SamplingStrategy strategy) {
        this.strategy = strategy;
    }

    public List<DataPoint> getPoints(List<DataPoint> dps) {
        List<DataPoint> dpsSegregated = strategy.getPoints(dps);

        for (DataPoint dp : dpsSegregated) {
            if (dp.getValue() < SLA_MIN) {
                dp.setColor("BLUE");
                minViolationCounter++;
            } else if (dp.getValue() < SLA_MAX) {
                dp.setColor("GREEN");
            } else {
                dp.setColor("RED");
                maxViolationCounter++;
            }
        }

        return dpsSegregated;
    }

    public int getMinViolationCount() {
        return minViolationCounter;
    }

    public int getMaxViolationCount() {
        return maxViolationCounter;
    }
}
