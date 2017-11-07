package com.cris.capo;

import java.util.List;

public interface SamplingStrategy {
    List<DataPoint> getPoints(List<DataPoint> dps);
}
