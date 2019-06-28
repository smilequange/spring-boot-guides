package cn.jantd.springsecurity.security;

import cn.jantd.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;


@Component
public class UsernameAuthenticationManager implements AuthenticationManager {

  @Autowired
  private UserService userService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = (String) authentication.getPrincipal();
    String password = (String) authentication.getCredentials();
    User user = this.userService.loadUserByUsername(username);
    if (null != user) {
      if (new MD5PasswordEncoder().matches(password, user.getPassword())) {
        if (!user.isAccountNonExpired()) {
          throw new AccountExpiredException("account expired");
        } else if (!user.isAccountNonLocked()) {
          throw new LockedException("account locked");
        } else if (!user.isCredentialsNonExpired()) {
          throw new CredentialsExpiredException("credentials expired");
        } else if (!user.isEnabled()) {
          throw new DisabledException("account disabled");
        } else {
          return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
        }
      } else {
        throw new BadCredentialsException("credentials error");
      }
    } else {
      throw new AuthenticationCredentialsNotFoundException("account not found");
    }
  }

}
