package Utilities;

public class WindowsCredentials {
    public WinCred.WinCredential getCredentials() {
        WinCred wc = new WinCred();

        WinCred.WinCredential cred = wc.getCredential("TrainReservationSystemTest");

        return cred;
    }
}
