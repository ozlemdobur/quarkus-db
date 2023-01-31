package org.acme.services;

import org.acme.dto.StaticticsResult;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

@ApplicationScoped
public class ReportService {
    private IRandomNumber apiRandomNumber;
    private IRandomNumber dbRandomNumber;
    private IStatisticsService statisticsService;

    @Inject
    public ReportService(ApiRandomNumber apiRandomNumber, DbRandomNumber dbRandomNumber, IStatisticsService statisticsService) {
        this.apiRandomNumber = apiRandomNumber;
        this.dbRandomNumber = dbRandomNumber;
        this.statisticsService = statisticsService;
    }

    // Unit Test use Mokito
    public StaticticsResult getResults() throws IOException, URISyntaxException, InterruptedException {

        Integer[] dbRandomNumbers = dbRandomNumber.getNumber();
        Integer[] apiRandomNumbers = apiRandomNumber.getNumber();
        Integer[] allRandomNumbers = concatenateNumbers(dbRandomNumbers, apiRandomNumbers);
        System.out.println(Arrays.stream(allRandomNumbers).toList());
        return statisticsService.getStatistic(allRandomNumbers);
    }

    // Unit Test
    public Integer[] concatenateNumbers(Integer[] array1, Integer[] array2){

        if(array1==null && array2 == null){
            return null;
        }

        if(array1==null ){
            return array2;
        }

        if(array2==null ){
            return array1;
        }

        if(array1.length==0 && array2.length == 0){
            return null;
        }

        Integer[] numbers = new Integer[array1.length + array1.length];
        System.arraycopy(array1, 0, numbers, 0, array1.length);
        System.arraycopy(array2, 0, numbers,  array1.length, array2.length);
        return numbers;
    }
}
