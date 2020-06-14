package hex.adapters.ports.input.users;

import hex.model.users.User;

import java.util.List;

public interface IGetAllUsersUseCase {
    List<User> getAllUsers();
}
