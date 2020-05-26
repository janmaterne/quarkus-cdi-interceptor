package de.materne.quarkus;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

//@Inherited
// CDI: We want to bind this annotation to an implementation class.
//    otherwise error while building: 
//        "Interceptor has no bindings: de.materne.quarkus.HelloWorldInterceptor"
@InterceptorBinding
// Annotation: We need this annotion until runtime. No deletion while compilation.
//   SOURCE : Interceptor has no bindings
//   CLASS  : Interceptor has no bindings
//   RUNTIME: ok
//   
@Retention(RUNTIME)
// Annotation: We have to annotate the implementation class itself (TYPE) and all
// method calls on the CDI bean.
// If you want to be more restrictive you could place the annotation on the methods, but
// then you also have to allow METHOD.
@Target(TYPE)
//@Target({METHOD, TYPE})
public @interface HelloWorld {
}
