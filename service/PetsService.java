package service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Pet;

public class PetsService {
    private List<Pet> pets;

    public PetsService(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Pet> nonVac() {
        List<Pet> nonVac = new ArrayList<>();
        for (Pet p : pets) {
            if (!p.isVacStatus()) {
                nonVac.add(p);
            }
        }
        return nonVac;
    }

    @SuppressWarnings("null")
    public List<Pet> getByClass(Class<?> clazz) {
        List<Pet> result = new ArrayList<>();
        for (Pet p : pets) {
            if (p.getClass().getName() == clazz.getName()) {
                result.add(p);
            }
        }
        return result;
    }

    public void youngToOld(List<Pet> pets) {
        Collections.sort(pets);
    }

    public void sortByName(List<Pet> pets) {
        Collections.sort(pets,
                new Comparator<Pet>() {
                    public int compare(Pet f1, Pet f2) {
                        return f1.getName().compareTo(f2.getName());
                    }
                });
    }

    public List<Pet> requiredGender(int gen) {
        return this.getPets().stream()
                .filter(p -> p.getGender() == gen)
                .collect(Collectors.toList());
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

}
