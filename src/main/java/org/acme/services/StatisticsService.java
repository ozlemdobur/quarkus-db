package org.acme.services;

import org.acme.dto.StaticticsResult;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
@ApplicationScoped
public class StatisticsService implements IStatisticsService{
    @Override
    public StaticticsResult getStatistic(Integer[] numbers) {
        if(numbers==null){
            return null;
        }

        if(numbers.length == 0){
            return null;
        }

        StaticticsResult staticticsResult = new StaticticsResult();
        IntSummaryStatistics summaryStatistics = Arrays.stream(numbers)
                .mapToInt(Integer::valueOf)
                .summaryStatistics();
        staticticsResult.setMax(summaryStatistics.getMax());
        staticticsResult.setMin(summaryStatistics.getMin());
        staticticsResult.setSum((int) summaryStatistics.getSum());
        staticticsResult.setAverage(summaryStatistics.getAverage());
        System.out.println(staticticsResult.getMax() + " "+ staticticsResult.getMin());
        return staticticsResult;
    }
}
