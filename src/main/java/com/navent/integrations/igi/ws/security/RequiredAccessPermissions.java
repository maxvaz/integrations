package com.navent.integrations.igi.ws.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dridco.inmuebles.zz.ProviderUserPermission;

/**
 * 
 * @author mtaboada
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RequiredAccessPermissions {

    public ProviderUserPermission[] permissions();

}
