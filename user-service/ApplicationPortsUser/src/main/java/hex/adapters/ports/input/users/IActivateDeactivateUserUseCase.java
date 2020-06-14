package hex.adapters.ports.input.users;

import java.util.UUID;

public interface IActivateDeactivateUserUseCase {
    void activateOrDeactivateUser(UUID id);
}
