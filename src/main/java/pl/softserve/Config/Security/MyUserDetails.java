package pl.softserve.Config.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.softserve.Models.User;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private User user;
    private String username;
    private String password;
    private String role;

    public MyUserDetails(User user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRoles().name();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
