package utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            number = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%s", faker.number().numberBetween(1, 28)),
            month = getRandomMonth(),
            year = String.format("%s", faker.number().numberBetween(1900, 2014)),
            subject = getRandomSubject(),
            hobby = getRandomHobby(),
            uploadFile = faker.options().option("hqdefault.jpg"),
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(state);

    String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    String getRandomMonth(){
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        return faker.options().option(months);
    }

    String getRandomSubject(){
        String[] subjects = {"English", "Maths", "Physics", "Chemistry",
                "Computer Science", "Economics", "Arts", "Social Studies",
                "History", "Civics", "Accounting", "Biology"};
        return faker.options().option(subjects);
    }

    String getRandomHobby(){
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public String getRandomCity(String value){
        if (state.equals("NCR")) city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
    }



}
