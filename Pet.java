
import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonSerialize
@JsonAutoDetect


public class Pet implements Serializable,Comparable<Pet>{
	
	private static final long serialVersionUID=1L;
	private String name;
	private int age;
	private boolean vacStatus;
	private int gender;
	public int getGender() {
		return gender;
	}
	public Pet(String name, int age, boolean vacStatus, int gender) {
		super();
		this.name = name;
		this.age = age;
		this.vacStatus = vacStatus;
		this.gender = gender;
	}
	public Pet() {
		super();
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setName(String Name) {
		this.name=Name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isVacStatus() {
		return vacStatus;
	}
	public void setVacStatus(boolean vacStatus) {
		this.vacStatus = vacStatus;
	}
	public String getName() {
		return this.name;
	}
	public Pet(Builder builder) {
		this.name=builder.name;
		this.age=builder.age;
		this.vacStatus=builder.vacStatus;
		this.gender=builder.gender;
	}
	public static class Builder{
		private String name;
		private int age;
		private boolean vacStatus;
		private int gender;
		public Builder(String name,int age,boolean vacStatus,int gender) {
			this.age=age;
			this.name=name;
			this.vacStatus=vacStatus;
			this.gender=gender;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public boolean isVacStatus() {
			return vacStatus;
		}
		public void setVacStatus(boolean vacStatus) {
			this.vacStatus = vacStatus;
		}
		public int getGender() {
			return gender;
		}
		public void setGender(int gender) {
			this.gender = gender;
		}
		public Builder age(int age) {
			this.age=age;
			return this;
		}
		public Builder name(String name) {
			this.name=name;
			return this;
		}
		public Builder vacStatus(boolean vacStatus) {
			this.vacStatus=vacStatus;
			return this;
		}
		public Builder gender(int gender) {
			this.gender=gender;
			return this;
		}
		public Pet build() {
			Pet newPet=new Pet(this);
			validate(newPet);
			return newPet;
		}
		protected void validate(Pet newPet) {
			String error="";
			if(newPet.name.length()>10) {
				error+="\nThere have to be less than 10 letters "
						+ "in name of pet!\n";
			}
			if(newPet.age>10 || newPet.age<0) {
				error+="\nPet cant live to this age\n";
			}
			if(newPet.gender<0 || newPet.gender>1) {
				error+="\nMale = 1, Female = 0, there's no other choice!\n";
			}
			if(!error.isEmpty()) {
			throw new IllegalArgumentException(error);
		}
	}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, gender, name, vacStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return age == other.age && Objects.equals(gender, other.gender) && Objects.equals(name, other.name)
				&& vacStatus == other.vacStatus;
	}
	public void print() {
		String not;
		if(this.isVacStatus()==false) {not="is not";}
		else {not="is";}
		System.out.printf("This pet's name is '"+this.getName()+"', it's age is: "+this.getAge()+" years and it "+not+" vaccinated");
	}
	public void animalSound() {
		System.out.print("Sample text");
	}
	@Override
	public String toString() {
		return "Pet [name=" + name + ", age=" + age + ", vacStatus=" + vacStatus + ", gender=" + gender + "]";
	}
	@Override
	public int compareTo(Pet ob2) {
		return ob2.getAge()-this.getAge();
	}
	
}
