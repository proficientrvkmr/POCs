package com.java.practice.puzzles.sapient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CalculateAverageIncome {

    private static List readFile() throws IOException {
        return Files.lines(Paths.get("sampleInput.csv")).collect(Collectors.toList());
    }

    private static List<InputData> getInputData() throws IOException {
        List<String> records = readFile();
        records.remove(0);
        List<InputData> collectedData = new ArrayList<>();

        for (String line : records) {
            String[] column = line.split(",");
            InputData object = new InputData(column[0],
                    "".equals(column[1]) ? column[0] : column[1],
                    column[2],
                    column[3],
                    getAverageIncomeInUSD(column[3], Double.parseDouble(column[4])));
            collectedData.add(object);
        }

        System.out.println("\n\n::::::::::::::::::::: Collected Data :::::::::::::::::::::\n ");
        collectedData.forEach(System.out::println);

        return collectedData;
    }

    private static double getAverageIncomeInUSD(String currency, Double amount) {
        double amountInUSD = 0;
        DecimalFormat decimalFormat = new DecimalFormat("###.##");

        switch (currency.trim().toUpperCase()) {
            case "INR":
                amountInUSD = amount / 66.6;
                break;
            case "HKD":
                amountInUSD = amount / 8;
                break;
            case "SGP":
                amountInUSD = amount / 1.5;
                break;
            case "GBP":
                amountInUSD = amount / 0.67;
                break;
            default:
                amountInUSD = amount;
                break;
        }

        return Double.parseDouble(decimalFormat.format(amountInUSD));
    }

    public static void main(String[] args) throws IOException {
        List<InputData> inputDataList = getInputData();

        inputDataList.sort(Comparator.comparing(InputData::getCountry)
                .thenComparing(InputData::getGender)
                .thenComparing(InputData::getAmount));

        System.out.println("\n\n::::::::::::::::::::: Sorted Data :::::::::::::::::::::\n");
        inputDataList.forEach(System.out::println);

        Map<String, Map<String, List<InputData>>> groupedByCountryAndGender = inputDataList.stream()
                .collect(Collectors
                        .groupingBy(InputData::getCountry,  Collectors.groupingBy(InputData::getGender))
                );


        System.out.println("\n\n::::::::::::::::::::: Grouped Data :::::::::::::::::::::\n");
        groupedByCountryAndGender.entrySet().forEach(System.out::println);
    }


}
