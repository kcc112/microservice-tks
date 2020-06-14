package hex.adapters.adapters;

import hex.adapters.ports.output.users.*;
import hex.model.users.*;
import hex.repository.interfaces.IUserRepositoryEnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static hex.adapters.converters.fromDomain.FromDomainConverterUser.convertUserEnt;
import static hex.adapters.converters.toDomain.ToDomainConverterUser.convertUser;

@Component
public class UsersRepositoryAdapter implements IActivateDeactivateUser, IAddUser, IDestroyUser, IGetAllUsers, IUpdateUser {


    private final IUserRepositoryEnt userRepositoryEnt;
    private PasswordEncoder passwordEncoder;

    @Autowired
    UsersRepositoryAdapter(IUserRepositoryEnt userRepositoryEnt, PasswordEncoder passwordEncoder) {
        this.userRepositoryEnt = userRepositoryEnt;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void activateOrDeactivateUser(UUID id) {
        Optional<UserEnt> userToChange = userRepositoryEnt.selectUserById(id);
        userToChange.ifPresent(user -> {
            if (user.getIsActive()) {
                user.setActive(false);
            } else {
                user.setActive(true);
            }
        });
    }

    @Override
    public void addUser(User user) {
        String userName = user.getUserName();
        String userSurname = user.getUserSurname();
        String userType = user.getUserType();
        String userEmail = user.getUserEmail();
        String password = passwordEncoder.encode(user.getPassword());
        boolean isActive = user.getIsActive();
        UUID id = user.getUserId();
        UserEnt userEnt;

        switch (user.getUserType()) {
            case "ADMIN":
                user = new User(userEmail, userName, userSurname, userType, id, password);
                userEnt = convertUserEnt(user);
                if (!isActive) user.setActive(false);
                userRepositoryEnt.addUser(userEnt);
                break;
            case "CLIENT":
                user = new Client(userEmail,userName, userSurname, userType, id, password);
                userEnt = convertUserEnt(user);
                if (!isActive) user.setActive(false);
                userRepositoryEnt.addUser(userEnt);
                break;
            case "RESOURCE_ADMINISTRATOR":
                user = new ResourceAdministrator(userEmail, userName, userSurname, userType, id, password);
                userEnt = convertUserEnt(user);
                if (!isActive) user.setActive(false);
                userRepositoryEnt.addUser(userEnt);
                break;
            default:
                break;
        }
    }

    @Override
    public void destroyUser(UUID id) {
        userRepositoryEnt.destroyUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (UserEnt userEnt : userRepositoryEnt.getAllUsers()) {
            User user = convertUser(userEnt);
            users.add(user);
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        Optional<UserEnt> currentUser = userRepositoryEnt.selectUserById(user.getUserId());

        if (currentUser.isPresent()) {

            if(!user.getUserName().isBlank()) {
                String name = user.getUserName();
                currentUser.get().setUserName(name);
            }

            if(!user.getUserSurname().isBlank()) {
                String surname = user.getUserSurname();
                currentUser.get().setUserSurname(surname);
            }
            userRepositoryEnt.updateUser(currentUser.get());
        }
    }
}
