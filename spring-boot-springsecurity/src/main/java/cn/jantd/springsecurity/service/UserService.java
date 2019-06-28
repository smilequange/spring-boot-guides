package cn.jantd.springsecurity.service;

import cn.jantd.springsecurity.security.MD5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class UserService implements UserDetailsService {

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User(username,MD5PasswordEncoder.encode("123456"),authorities("role"));

        return user;
    }


    private Collection<GrantedAuthority> authorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}
