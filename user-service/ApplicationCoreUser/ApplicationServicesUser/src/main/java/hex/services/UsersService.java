package hex.services;

import hex.adapters.ports.input.users.*;
import hex.adapters.ports.output.users.*;
import hex.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService implements IAddUserUseCase, IActivateDeactivateUserUseCase, IDestroyUserUseCase, IGetAllUsersUseCase, IUpdateUserUseCase {

    private final IAddUser addUser;
    private final IDestroyUser destroyUser;
    private final IGetAllUsers getAllUsers;
    private final IUpdateUser updateUser;
    private final IActivateDeactivateUser activateDeactivateUser;

    @Autowired
    public UsersService(IAddUser addUser, IDestroyUser destroyUser, IGetAllUsers getAllUsers, IUpdateUser updateUser, IActivateDeactivateUser activateDeactivateUser) {
        this.addUser = addUser;
        this.destroyUser = destroyUser;
        this.getAllUsers = getAllUsers;
        this.updateUser = updateUser;
        this.activateDeactivateUser = activateDeactivateUser;
    }

    @Override
    public void activateOrDeactivateUser(UUID id) {
        activateDeactivateUser.activateOrDeactivateUser(id);
    }

    @Override
    public void addUser(User user) {
        addUser.addUser(user);
    }

    @Override
    public void destroyUser(UUID id) {
        destroyUser.destroyUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return getAllUsers.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        updateUser.updateUser(user);
    }
}
