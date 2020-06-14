package hex.adapters.converters.toDomain;

import hex.model.users.User;
import hex.model.users.UserEnt;

public class ToDomainConverterUser {
    public static User convertUser(UserEnt userEnt) {
        User user = new User();
        user.setActive(userEnt.getIsActive());
        user.setPassword(userEnt.getPassword());
        user.setUserEmail(userEnt.getUserEmail());
        user.setUserId(userEnt.getUserId());
        user.setUserSurname(userEnt.getUserSurname());
        user.setUserType(userEnt.getUserType());
        return user;
    }
}
