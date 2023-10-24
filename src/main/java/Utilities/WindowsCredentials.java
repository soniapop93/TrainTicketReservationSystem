package Utilities;

public class WindowsCredentials {
    public void getCredentials(Credential credential) {
        WinCred wc = new WinCred();

        // Get a credential
        WinCred.WinCredential cred = wc.getCredential("Application Name");
        String username = cred.username;
        String password = cred.password;


        System.out.println(username);
        System.out.println(password);
    }


}
