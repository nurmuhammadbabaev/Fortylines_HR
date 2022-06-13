package fortylines.io.fortylines_hr.entity;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Validator {

    public boolean patternMatches(String emailAddress) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9+_-]+(\\.[A-Za-z0-9+_-]+)*@"
                + "gmail.com";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
    public boolean isValid(String oldPhoneNumber) {
        String phoneNumber = oldPhoneNumber.trim().replaceAll(" +", "");
        if (phoneNumber.length() == 13 || phoneNumber.length() == 12 || phoneNumber.length() == 9) {
            if (phoneNumber.charAt(0) == ('9') && phoneNumber.charAt(1) == ('9') && phoneNumber.charAt(2) == ('6')) {
                phoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
                if (phoneNumber.matches("[0-9]*")) {
                    return true;
                }
            }
            if (phoneNumber.charAt(0) == '+' && phoneNumber.charAt(1) == ('9') && phoneNumber.charAt(2) == ('9') && phoneNumber.charAt(3) == ('6')) {
                phoneNumber = phoneNumber.substring(1, phoneNumber.length() - 1);
                if (phoneNumber.matches("[0-9]*")) {
                    return true;
                }
            }
            if (phoneNumber.charAt(0) == '7' || phoneNumber.charAt(0) == ('2') || phoneNumber.charAt(2) == ('5')) {
                phoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
                if (phoneNumber.matches("[0-9]*")) {
                    return true;
                }
            }
        }
        return false;
    }
}
