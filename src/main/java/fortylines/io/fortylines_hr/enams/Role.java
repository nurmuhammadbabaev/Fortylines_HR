package fortylines.io.fortylines_hr.enams;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    HEADOF, EMPLOYEE, ADMIN;


    @Override
    public String getAuthority() {
        return this.name();
    }
}
