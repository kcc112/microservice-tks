package hex.adapters.ports.input.users;

import java.util.UUID;

public interface IDestroyUserUseCase {
    void destroyUser(UUID id);
}
