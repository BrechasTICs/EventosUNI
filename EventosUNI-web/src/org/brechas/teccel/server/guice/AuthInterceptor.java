package org.brechas.teccel.server.guice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.brechas.teccel.server.entity.CurrentUser;
import org.brechas.teccel.server.entity.Role;

import com.google.api.server.spi.response.UnauthorizedException;
import com.google.inject.Inject;

public class AuthInterceptor implements MethodInterceptor {

	@Inject
	CurrentUser user;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		Role requiredRole = invocation.getMethod()
				.getAnnotation(AuthRequired.class).value();

		switch (requiredRole) {
		case ADMIN: {
			if (!user.isAdmin())
				throw new UnauthorizedException("User requires role "
						+ requiredRole);
			break;
		}
		case PUBLISHER: {
			if (!user.isAdmin()&&!user.isPublisher())
				throw new UnauthorizedException("User requires role "
						+ requiredRole);
			break;
		}
		case GUEST: {
			if (!user.isAdmin()&&!user.isPublisher()&&!user.isGuest())
				throw new UnauthorizedException("User requires role "
						+ requiredRole);
			break;
		}
		default:
			break;
		}

		return invocation.proceed();
	}
}