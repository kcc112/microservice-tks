package hex.model.users;

import java.util.UUID;

public class Admin extends User {
    public Admin(String userEmail, String userName, String userSurname, String userType, UUID userId) {
        super(userEmail, userName, userSurname, userType, userId);
    }
}
