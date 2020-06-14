package hex.adapters.converters.fromDomain;

import hex.model.users.User;
import hex.model.users.UserEnt;

public class FromDomainConverterUser {
    public static UserEnt convertUserEnt(User user) {
        UserEnt userEnt = new UserEnt();
        userEnt.setActive(user.getIsActive());
        userEnt.setPassword(user.getPassword());
        userEnt.setUserEmail(user.getUserEmail());
        userEnt.setUserId(user.getUserId());
        userEnt.setUserSurname(user.getUserSurname());
        userEnt.setUserType(user.getUserType());
        return userEnt;
    }
}
