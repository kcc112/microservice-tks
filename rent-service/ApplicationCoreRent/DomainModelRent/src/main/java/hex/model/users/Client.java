package hex.model.users;

import java.util.UUID;

public class Client extends User {

    public Client(String userEmail, String userName, String userSurname, String userType, UUID userId) {
        super(userEmail, userName, userSurname, userType, userId);
    }

    public Client() { }
}
