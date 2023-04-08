package constants;

import com.github.javafaker.Faker;
import constants.user.UserRegistrationFields;

public class RandomTestUser {

    public static final String EMAIL_USER = "user_test@mail.ru";
    public static final String PASSWORD_USER = "123";

    public static UserRegistrationFields getRandomRegistration() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 16);
        String name = faker.name().username();
        return new UserRegistrationFields(email, password, name);
    }

}
