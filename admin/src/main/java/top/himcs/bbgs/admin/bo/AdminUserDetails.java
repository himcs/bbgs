package top.himcs.bbgs.admin.bo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.himcs.bbgs.mbg.model.SystemAdmin;

import java.util.Collection;

public class AdminUserDetails implements UserDetails {
    private SystemAdmin systemAdmin;

    public AdminUserDetails(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return systemAdmin.getPwd();
    }

    @Override
    public String getUsername() {
        return systemAdmin.getAccount();
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
