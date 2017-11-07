package com.cris.capo;

import java.util.ArrayList;
import java.util.List;

public class AverageSampling implements SamplingStrategy {

    private int daysInterval;

    public AverageSampling(int daysInterval) {
        this.daysInterval = daysInterval;
    }

    public List<DataPoint> getPoints(List<DataPoint> dps) {
        List<DataPoint> dpsSampled = dps;

        return dpsSampled;
    }

    private double getListAverage(List<DataPoint> dps) {
        double average = 0;

        if (!dps.isEmpty()) {
            for (DataPoint dp : dps) {
                average += dp.getValue();
            }

            average = average / dps.size();
        }

        return average;
    }
}
