package com.pla.chatsys.client;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface Sendfile {

	boolean isNeeded() default true;
}

