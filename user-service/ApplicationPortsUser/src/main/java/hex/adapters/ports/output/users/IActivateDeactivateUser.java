package hex.adapters.ports.output.users;

import java.util.UUID;

public interface IActivateDeactivateUser {
    void activateOrDeactivateUser(UUID id);
}
