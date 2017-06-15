package org.light4j.annotation.compile;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Id {
	String column();

	String type();

	String generator();
}