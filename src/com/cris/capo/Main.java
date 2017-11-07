package com.cris.capo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        List<DataPoint> dpsList = new ArrayList<>();

        try {
            dpsList.add(new DataPoint(1, dateFormat.parse("01-11-2017")));
            dpsList.add(new DataPoint(2, dateFormat.parse("02-11-2017")));
            dpsList.add(new DataPoint(3, dateFormat.parse("03-11-2017")));
            dpsList.add(new DataPoint(4, dateFormat.parse("04-11-2017")));
            dpsList.add(new DataPoint(3, dateFormat.parse("05-11-2017")));
            dpsList.add(new DataPoint(2, dateFormat.parse("06-11-2017")));
            dpsList.add(new DataPoint(5, dateFormat.parse("07-11-2017")));

            SkippedAverageSampling combined = new SkippedAverageSampling();
            combined.addStrategy(new SkipSampling(3));
            combined.addStrategy(new AverageSampling(2));

            OutOfRangeSegregation segregated = new OutOfRangeSegregation(combined);

            List<DataPoint> chartData = getChartData(dpsList, segregated);

            for (DataPoint dp : chartData) {
                System.out.println(dp.getDatetime());
                System.out.println(dp.getValue());
                System.out.println(dp.getColor());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<DataPoint> getChartData(List<DataPoint> dps, SamplingStrategy strategy) {
        return strategy.getPoints(dps);
    }
}
