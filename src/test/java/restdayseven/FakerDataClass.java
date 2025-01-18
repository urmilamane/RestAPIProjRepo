package restdayseven;

import com.github.javafaker.Faker;

public class FakerDataClass {

	public static void main(String[] args) {
		Faker faker=new Faker();
        String Name= faker.name().fullName();
        System.out.println(Name);
	}

}

