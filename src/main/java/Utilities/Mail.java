package Utilities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {
    private String mailAddressFrom;
    private String mailAddressTo;
    private String subject;
    private String text;

    public Mail(String mailAddressFrom, String mailAddressTo, String subject, String text) {
        this.mailAddressFrom = mailAddressFrom;
        this.mailAddressTo = mailAddressTo;
        this.subject = subject;
        this.text = text;
    }

}
