package de.materne.quarkus;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

//@Inherited
// CDI: We want to bind this annotation to an implementation class.
@InterceptorBinding
// Annotation: We need this annotion until runtime. No deletion while compilation.
@Retention(RUNTIME)
// Annotation: We have to annotate the implementation class itself (TYPE) and want to
// to intercept method calls.
@Target({METHOD, TYPE})
public @interface HelloWorld {
}
