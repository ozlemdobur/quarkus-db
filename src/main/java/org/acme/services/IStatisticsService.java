package org.acme.services;

import org.acme.dto.StaticticsResult;

public interface IStatisticsService {
    StaticticsResult getStatistic(Integer[] numbers);
}
