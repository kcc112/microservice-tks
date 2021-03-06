package hex.model.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@JsonIgnoreProperties("password")
public class User {

    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp =  "^[A-Za-z0-9]+@(.+)$", message = "Invalid email")
    private String userEmail;

    @NotBlank(message = "Name is eventsmandatory")
    @Size(min = 3, max = 12, message = "Size must be between 3 and 12")
    @Pattern(regexp = "[A-Z][a-z]*", message = "Invalid name")
    private String userName;

    @NotBlank(message = "Surname is mandatory")
    @Size(min = 3, max = 12, message = "Size must be between 3 and 12")
    @Pattern(regexp = "[A-Z][a-z]*", message = "Invalid surname")
    private String userSurname;

    private String userType;

    private UUID userId;
    private boolean isActive;

    User(String userEmail, String userName, String userSurname, String userType, UUID userId) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userType = userType;
        this.userId = userId;
        this.isActive = true;
    }

    public User() {}

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return userName + " " + userSurname + " " + userType;
    }
}
