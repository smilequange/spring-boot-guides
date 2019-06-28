package cn.jantd.shiro.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

  /**
   * 权限认证
   **/
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    String username = (String) SecurityUtils.getSubject().getPrincipal();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    Set<String> roles = new HashSet<>();
    roles.add("admin");
    info.setRoles(roles);
    return new SimpleAuthorizationInfo();
  }

  /**
   * 身份认证
   **/
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    if (null == token.getCredentials() || !new String((char[]) token.getCredentials()).equals("123456")) {
      throw new AccountException("密码不正确");
    }
    return new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), getName());
  }
}
