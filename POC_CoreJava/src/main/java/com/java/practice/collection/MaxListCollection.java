package com.sapient.ravkushw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


record Trainer(String id, String name, List<Trainee> trainees) {
}

record Trainee(String id, String name) {
}

public class MaxListCollection {
    public static void main(String[] args) {
        List<Trainer> trainerList = new ArrayList<>();

        trainerList.add(new Trainer("1", "Ravi", List.of(new Trainee("1", "1A"))));
        trainerList.add(new Trainer("2", "Shyam", List.of(new Trainee("1", "1A"), new Trainee("2", "2B"))));
        trainerList.add(new Trainer("3", "murli", List.of(new Trainee("1", "1A"), new Trainee("2", "2B"), new Trainee("3", "3C"))));

        Trainer trainerWithMaxTrainee = getTrainerWithMaxTrainee(trainerList);
        System.out.println(trainerWithMaxTrainee);
    }

    public static Trainer getTrainerWithMaxTrainee(List<Trainer> trainerList) {
        return trainerList.stream()
                          .max(Comparator.comparingInt(trainer -> trainer.trainees().size()))
                          .orElse(null);
    }
}


