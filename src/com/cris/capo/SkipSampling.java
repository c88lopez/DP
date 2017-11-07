package com.cris.capo;

import java.util.ArrayList;
import java.util.List;

public class SkipSampling implements SamplingStrategy {

    private int numberOfItemsToSkip;

    public SkipSampling(int numberOfItemsToSkip) {
        this.numberOfItemsToSkip = numberOfItemsToSkip;
    }

    public List<DataPoint> getPoints(List<DataPoint> dps) {
        List<DataPoint> skippedDps = new ArrayList<>();

        for (int i = numberOfItemsToSkip; i < dps.size(); i++) {
            skippedDps.add(dps.get(i));
        }

        return skippedDps;
    }
}
