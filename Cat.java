
import java.util.Scanner; 
import java.util.Objects;


public class Cat extends Pet {
	private static final long serialVersionUID=1L;
	private String breed;
	private int miceHunt;
	private Cat(Builder builder){
		super(builder);
		this.breed=builder.breed;
		this.miceHunt=builder.miceHunt;
	}
	static class Builder extends Pet.Builder{
		public Builder(String name, int age, boolean vacStatus, int gender,String breed,int miceHunt) {
			super(name, age, vacStatus, gender);
			this.breed=breed;
			this.miceHunt=miceHunt;
		}
		private String breed;
		private int miceHunt;
		public Builder breed(String breed) {
			this.breed=breed;
			return this;
		}
		public Builder miceHunt(int miceHunt) {
			this.miceHunt=miceHunt;
			return this;
		}
		private void validate(Cat cat) {
			String error="";
			int flag=0;
			if(cat.breed.length()>10) {
				error+="\n we are not sure if name of breed can contain more than 10 letters\n";
				flag++;
			}
			if(cat.miceHunt<0) {
				error+="\n number of mice hunt by cat can't be less than zero!\n";
				flag++;
		}
			if(flag!=0) {
				throw new IllegalArgumentException(error);
			}
			super.validate(cat);
		}
		public Cat build() {
			Cat newPet=new Cat(this);
			validate(newPet);
			return newPet;
		}
	}
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getMiceHunt() {
		return miceHunt;
	}

	public void setMiceHunt(int miceHunt) {
		this.miceHunt = miceHunt;
	}
	public static Cat input() {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.print("Enter name of cat: ");  
		String name= sc.nextLine();  
		System.out.print("Enter age of "+name+": ");  
		int age= sc.nextInt();  
		System.out.print("Is it vaccinated? (true or false): ");  
		boolean vac= sc.nextBoolean();  
		System.out.print("what gender is it: "); 
		int gen= sc.nextInt();  
		System.out.print("what breed is it: ");  
		String breed= sc.nextLine();  
		System.out.print("How many mice did it catch?(from zero to ...): ");  
		int mic= sc.nextInt();  
		Cat newCat= new Cat.Builder(name, age, vac, gen, breed, mic).build();
		return newCat;
	}

	@Override
	public String toString(){
		return "Cat [name=" + this.getName() + ", age=" +this.getAge() + ", vacStatus=" + this.isVacStatus()
		+ ", gender=" + this.getGender() + ", breed="+breed+", kids bit="+miceHunt+"]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(breed, miceHunt);
		return result;
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.print(". This cat's breed is: "+this.getBreed() + ". "+ this.getName() 
		+" hunt "+this.getMiceHunt()+" mices.");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return Objects.equals(breed, other.breed) && miceHunt == other.miceHunt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}



