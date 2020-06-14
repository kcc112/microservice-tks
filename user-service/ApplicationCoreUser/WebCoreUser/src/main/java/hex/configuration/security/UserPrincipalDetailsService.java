package hex.configuration.security;

import hex.model.users.UserEnt;
import hex.repository.interfaces.IUserRepositoryEnt;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private IUserRepositoryEnt userRepository;

    public UserPrincipalDetailsService(IUserRepositoryEnt userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserEnt> user = userRepository.selectUserByEmail(s);
        UserPrincipal userPrincipal = null;
        if (user.isPresent()) {
            userPrincipal = new UserPrincipal(user.get());
        }
        return userPrincipal;
    }
}
