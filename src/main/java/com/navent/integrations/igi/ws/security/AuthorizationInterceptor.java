package com.navent.integrations.igi.ws.security;

import javax.naming.AuthenticationException;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 *
 * @author mtaboada
 *
 */
@Component
public class AuthorizationInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {

        if (!invocation.getMethod().isAnnotationPresent(RequiredAccessPermissions.class)) {
            return invocation.proceed();
        }

        // ProviderUser providerUser = this.context.getProviderUser();
        //
        // ProviderUserPermission[] permissions = invocation.getMethod().getAnnotation(RequiredAccessPermissions.class)
        // .permissions();
        // Collection<ProviderUserPermission> requiredAccess = asList(permissions);
        //
        // if (!providerUser.hasAllowedSomeAction()) {
        // throw new AuthenticationException(
        // "Authentication rejected: This method requires authorization. User has not defined role");
        // }
        // for (ProviderUserPermissionEntity providerUserPermissionEntity : providerUser.getPermissions()) {
        // if (requiredAccess.contains(providerUserPermissionEntity.getPermission())) {
        // return invocation.proceed();
        // }
        // }

        throw new AuthenticationException("Authentication rejected: Insufficient level of authorization");
    }

}
