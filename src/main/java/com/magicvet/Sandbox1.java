package main.java.com.magicvet;

import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox1 {
    public static void main(String[] args) {
        Pet[] pets = {
                new Pet(Pet.HealthState.GOOD),
                new Pet(Pet.HealthState.EXCELLENT),
                new Pet(Pet.HealthState.FAIR),
                new Pet(Pet.HealthState.EXCELLENT),
                new Pet(Pet.HealthState.POOR),
                new Pet(Pet.HealthState.GOOD),

        };

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getHealthState().getValue() - o2.getHealthState().getValue();
            }
        });
        for (Pet pet : pets){
            System.out.println( pet.getHealthState());
        }


    }
}
