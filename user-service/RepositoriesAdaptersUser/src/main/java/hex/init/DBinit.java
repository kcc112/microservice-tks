package hex.init;

import hex.model.users.AdminEnt;
import hex.model.users.ClientEnt;
import hex.model.users.ResourceAdministratorEnt;
import hex.repository.interfaces.IUserRepositoryEnt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DBinit implements CommandLineRunner {

    private BCryptPasswordEncoder passwordEncoder;

    private IUserRepositoryEnt userRepository;

    public DBinit(BCryptPasswordEncoder passwordEncoder, IUserRepositoryEnt userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.addUser(new AdminEnt("a@a.com","Kamil", "Celejewski","ADMIN", UUID.randomUUID(), passwordEncoder.encode("123")));
        userRepository.addUser(new ClientEnt("b@b.com","Marcin1", "Morawski","CLIENT", UUID.randomUUID(),passwordEncoder.encode("123")));
        userRepository.addUser(new ClientEnt("c@c.com","Marcin2", "Morawski","CLIENT", UUID.randomUUID(),passwordEncoder.encode("123")));
        userRepository.addUser(new ClientEnt("d@d.com","Marcin3", "Morawski","CLIENT", UUID.randomUUID(),passwordEncoder.encode("123")));
        userRepository.addUser(new ClientEnt("e@e.com","Marcin4", "Morawski","CLIENT", UUID.randomUUID(),passwordEncoder.encode("123")));
        userRepository.addUser(new ResourceAdministratorEnt("f@f.com","Szymon", "Dobrowolski","RESOURCE_ADMINISTRATOR", UUID.randomUUID(),passwordEncoder.encode("123")));
    }
}