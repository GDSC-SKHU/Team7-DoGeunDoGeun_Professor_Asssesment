package com.dugeun.dugeunbackend.roundtest;


import org.junit.jupiter.api.Test;

public class RoundTest {

    @Test
    public void 반올림_테스트() throws Exception{
        //given
        Double avgAssignment = 10.5;

        Double avgKindness =  10.5;

        Double avgTeaching =  10.5;

        Double avgHumanity =  10.5;

        Double avgSensibility =  10.5;
        //when
        double sum = avgAssignment + avgKindness + avgTeaching + avgHumanity + avgSensibility;
        double rating = sum / 5 / 20;

        String a = String.format("%.1f", 3.4443);
        Double value = Double.valueOf(a);
        //then
        System.out.println("value = " + value);
     }

}
