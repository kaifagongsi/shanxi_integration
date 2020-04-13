package com.kfgs.domain.ext;

import com.kfgs.domain.TbUser;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Date: 2020-04-13-13-59
 * Module:
 * Description:
 *
 * @author:
 */
@Data
@ToString
public class TbUserExt extends TbUser implements UserDetails {

    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


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
