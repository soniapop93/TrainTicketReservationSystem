package Utilities;

public class WindowsCredentials {
    public WinCred.WinCredential getCredentials() {
        WinCred wc = new WinCred();

        // Get a credential
        WinCred.WinCredential cred = wc.getCredential("TrainReservationSystemTest");
        String username = cred.username;
        String password = cred.password;

        System.out.println(username);
        System.out.println(password);

        return cred;
    }
}
