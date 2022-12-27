

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Service {
	public int nonVac(List<Pet> pets) {
		int nonVac=0;
		for(Pet p:pets) {
			if(!p.isVacStatus()) {
				nonVac++;
			}
		}
		return nonVac;
	}
	@SuppressWarnings("null")
	public List<String> dogs(List<Pet> pets) {
		List<String> result=null;
		for(Pet p:pets) {
			if(p.getClass().getName()=="l2.Dog") {
				result.add(p.toString());
		}
		}
		return result;
	}
	public void youngToOld(List<Pet> pets) {
		Collections.sort(pets);
	}
	public void sortByName(List<Pet> pets) {
		Collections.sort(pets,
                new Comparator<Pet>()
                {
                    public int compare(Pet f1, Pet f2)
                    {
                        return f1.getName().compareTo(f2.getName());
                    }        
                });
	}

}
