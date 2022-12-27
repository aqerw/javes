package model;
import java.util.Objects;
import java.util.Scanner;


public class Dog extends Pet{
    private static final long serialVersionUID = 1L;
    private String breed;
    private int kidsBit;
    private Dog(Builder builder){
        super(builder);
        this.breed=builder.breed;
        this.kidsBit=builder.kidsBit;
    }
    public  static  class Builder extends Pet.Builder{
        public Builder(String name, boolean vacStatus, int gender,String breed,int kidsBit) {
            super(name,  vacStatus, gender);
            this.breed=breed;
            this.kidsBit=kidsBit;
        }
        private String breed;
        private int kidsBit;
        public Builder breed(String breed) {
            this.breed=breed;
            return this;
        }
        public Builder kidsBit(int kidsBit) {
            this.kidsBit=kidsBit;
            return this;
        }
        public Dog build() {
            Dog newPet=new Dog(this);

            return newPet;
        }
        private void validate(Dog dog) {
            String error="";
            int flag=0;
            if(dog.breed.length()>10) {
                error+="\n we are not sure if name of breed can contain more than 10 letters\n";
                flag++;
            }
            if(dog.kidsBit<0) {
                error+="\n children cannot be less than 0\n";
            }
            if(flag!=0){
                throw new IllegalArgumentException(error);
            }
            super.validate(dog);
        }

    }
    @Override
    public String toString(){
        return "Dog [name=" + this.getName() + ", age=" +this.getAge() + ", vacStatus=" + this.isVacStatus()
                + ", gender=" + this.getGender() + ", breed="+breed+", kids bit="+kidsBit+"]";
    }
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getKidsBit() {
        return kidsBit;
    }

    public void setKidsBit(int miceHunt) {
        this.kidsBit = miceHunt;
    }
    public static Dog input() {
        @SuppressWarnings("resource")
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter name of dog: ");
        String name= sc.nextLine();
        System.out.print("Enter age of "+name+": ");
        int age= sc.nextInt();
        System.out.print("Is it vaccinated? (true or false): ");
        boolean vac= sc.nextBoolean();
        System.out.print("what gender is it: ");
        int gen= sc.nextInt();
        System.out.print("what breed is it: ");
        String breed= sc.nextLine();
        System.out.print("How many kids did it bit?(from zero to ...): ");
        int kid= sc.nextInt();
        Dog newDog= (Dog) new Dog.Builder(name ,vac, gen, breed, kid).age(age).build();
        return newDog;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(breed, kidsBit);
        return result;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        super.print();
        System.out.print(". This dog's breed is: "+this.getBreed() + ". "+ this.getName()
                +" bit "+this.getKidsBit()+" children.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dog other = (Dog) obj;
        return Objects.equals(breed, other.breed) && kidsBit == other.kidsBit;
    }

}

