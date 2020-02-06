package com.java.practice.puzzles.sapient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class InputData {
    private String city;
    private String country;
    private String gender;
    private String currency;
    private double amount;

}
