package hex.model.users;

import java.util.UUID;

public class ResourceAdministrator extends User {
    public ResourceAdministrator(String userEmail, String userName, String userSurname, String userType, UUID userId) {
        super(userEmail, userName, userSurname, userType, userId);
    }
}
