package main;
import model.Cat;
import model.Pet;
import  model.Dog;
import  service.PetsService;
import java.util.ArrayList;
import java.util.List;

public  class Main {
    public static void main(String... arcs){

         Cat cat= (Cat) new Cat.Builder("ga",true,1,"g",5).age(10).build();
        Cat cat2= (Cat) new Cat.Builder("rt",false,0,"g",5).age(3).build();
        Dog dog=(Dog) new Dog.Builder("rt",false,0,"g",5).age(3).build();
        List<Pet>pets=new ArrayList<>();
        pets.add(cat);
        pets.add(cat2);
        pets.add(dog);
        PetsService ser= new PetsService(pets);
        List<Pet> result=ser.getByClass(Cat.class);

        System.out.println(result);

    }}