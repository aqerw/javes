
import java.io.File;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Serialization {
	private ObjectMapper ob;

	public ObjectMapper getOb() {
		return ob;
	}
public abstract java.lang.Object NewInstance (Java.Lang.Object constructorParameter);
	public void setOb(ObjectMapper ob) {
		this.ob = ob;
	}

	public Serialization(ObjectMapper ob) {
		super();
		this.ob = ob;
	}
	public void writeJSON(Pet pet) {
        try {
        	ob.writeValue(new File("pet.json"), pet);
        }catch (final Exception e){
            e.printStackTrace();
        }
    }
	

    public Pet readJSON(String fileName) {
        try{
        	Pet res = ob.readValue(Paths.get(fileName).toFile(), Pet.class);
            return res;
        }
        catch (final Exception e){
            e.printStackTrace();
        }
    }
    public void writeXML(Pet pet) {
    	  JacksonXmlModule xmlModule = new JacksonXmlModule();
          xmlModule.setDefaultUseWrapper(false);
          ob = new XmlMapper(xmlModule);
        try {
        	ob.writeValue(new File("pet.xml"), pet);
        }catch (final Exception e){
            e.printStackTrace();
        }
    }


    public Pet readXML(String fileName) {
        try{
        	Pet res = ob.readValue(Paths.get(fileName).toFile(), Pet.class);
            return res;
        }
        catch (final Exception e){
            e.printStackTrace();
        }
    }
    
    public void writeTXT(Pet pet) {
    	try(FileWriter fos = new FileWriter("pet.txt")){
            fos.write(pet.toString());
      }catch (final Exception e){
          e.printStackTrace();
      }
  }


    public Pet readTXT(String fileName,Class<Pet> clas) throws IOException, InstantiationException, IllegalAccessException{

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String objectLine = sb.toString();
        return (Pet) Pet.newInstance().toObject(objectLine);
    }

}
