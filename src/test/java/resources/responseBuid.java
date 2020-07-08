package resources;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import pojo.Serialize;
import pojo.location;
import pojo.Serialize;
public class responseBuid {
	
	public Serialize addPlacePayload(String name,String language,String address) {
		
	
		Serialize s = new Serialize();
		
		s.setAccuracy(80);
		s.setName(name);
		s.setPhone_number("(+91) 983 803 3937");
		s.setAddress(address);
		s.setLanguage(language);
		s.setWebsite("google.com");
		List<String> Mylist = new ArrayList<String>();
		Mylist.add("Shoe park");
		Mylist.add("Shop");
		s.setTypes(Mylist);
		location l = new location();
		
		l.setLat(-34.9876);
		l.setLng(-35.9876);
		s.setLocation(l);
		
		return s;
	}

}
