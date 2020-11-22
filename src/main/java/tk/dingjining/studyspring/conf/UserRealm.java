package tk.dingjining.studyspring.conf;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import tk.dingjining.studyspring.entity.User;

public class UserRealm extends AuthenticatingRealm {

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 角色
		Set<String> roles = new HashSet<>();
		// 权限
		Set<String> permissions = new HashSet<>();
		// 测试用权限permissions
        if ("admin".equals(user.getUsername())) {
            roles.add("admin");
            permissions.add("op:write");
        } else {
            roles.add("user");
            permissions.add("op:read");
        }
		roles.add("admin");
		permissions.add("user:query");
		authorizationInfo.setRoles(roles);
		authorizationInfo.setStringPermissions(permissions);
		return authorizationInfo;
	}

	/**
	 * 认证 ，用户名密码校验
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		String username = (String) authenticationToken.getPrincipal();
		User user = null;
		if ("zhangsan".equalsIgnoreCase(username)) {
			user = new User(1, "zhangsan", "123");
		}

		if (user == null) {
			throw new UnknownAccountException(); // 账号不存在
		}
//		if (user.getStatus() != 0) {
//			throw new LockedAccountException(); // 账号被锁定
//		}
//		String salt = user.getSalt();
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		return authenticationInfo;
	}

}
