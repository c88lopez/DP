package com.cris.capo;

import java.util.ArrayList;
import java.util.List;

public class SkippedAverageSampling implements SamplingStrategy {
    private List<SamplingStrategy> strategies = new ArrayList<>();

    public List<DataPoint> getPoints(List<DataPoint> dpsList) {
        for (SamplingStrategy strategy : strategies) {
            dpsList = strategy.getPoints(dpsList);
        }

        return dpsList;
    }

    public void addStrategy(SamplingStrategy strategy) {
        strategies.add(strategy);
    }
}
