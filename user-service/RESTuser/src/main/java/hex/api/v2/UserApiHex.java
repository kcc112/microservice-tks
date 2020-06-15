package hex.api.v2;

import com.sun.tools.jconsole.JConsoleContext;
import hex.adapters.ports.input.users.IAddUserUseCase;
import hex.adapters.ports.output.users.IGetAllUsers;
import hex.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v2/users")
public class UserApiHex {

    private final IAddUserUseCase addUserUseCase;

    private final IGetAllUsers getAllUsers;

    @Autowired
    public UserApiHex(IAddUserUseCase addUserUseCase, IGetAllUsers getAllUsers) {
        this.addUserUseCase = addUserUseCase;
        this.getAllUsers = getAllUsers;
    }


    @GetMapping
    public List<User> getDevelopers() {
        return getAllUsers.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> addDeveloperFrontEnd(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Logger logger = Logger.getLogger(String.valueOf(UserApiHex.class));
            logger.log(Level.SEVERE, user.toString());
            logger.log(Level.SEVERE, bindingResult.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        addUserUseCase.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
