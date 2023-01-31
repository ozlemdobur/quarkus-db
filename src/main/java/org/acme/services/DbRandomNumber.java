package org.acme.services;

import org.acme.entity.GeneratedRandomNumbers;
import org.acme.repository.GeneratedRandomNumbersRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

@ApplicationScoped
public class DbRandomNumber implements IRandomNumber{

    private GeneratedRandomNumbersRepository generatedRandomNumbersRepository;
    @Inject
    public DbRandomNumber(GeneratedRandomNumbersRepository generatedRandomNumbersRepository) {
        this.generatedRandomNumbersRepository = generatedRandomNumbersRepository;
    }

    @Override
    @Transactional
    public Integer[] getNumber() {
        Integer[] numbers = generateNumbers();
        GeneratedRandomNumbers grn = new GeneratedRandomNumbers(intToString(numbers));
        generatedRandomNumbersRepository.persist(grn);
        return numbers;
    }
    public String intToString(Integer[] numbers){
        return String.join(",", Arrays.stream(numbers).map(String::valueOf).collect(Collectors.toList()));
    }
    //unit
    public Integer[] generateNumbers(){
        Integer[] numbers = new Integer[5];
        for(int i=0; i<numbers.length;i++){
            numbers[i] = new Random().nextInt(100);
        }
        return numbers;
    }
}
