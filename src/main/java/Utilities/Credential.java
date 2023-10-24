package Utilities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Credential {
    private String username;
    private String password;
    private String credentialName;

    public Credential(String username, String password, String credentialName) {
        this.username = username;
        this.password = password;
        this.credentialName = credentialName;
    }
}
