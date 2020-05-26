package de.materne.quarkus;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

// CDI: bind this class to this annotation
@HelloWorld
// CDI: declare this as an CDI interceptor
@Interceptor
public class HelloWorldInterceptor {

	// CDI: Mark this method as interceptor code
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		// call the original CDI bean, so the whole chain is executed
		// ... (but it is not required)
		// Object originalValueNotUsedAnyMore = context.proceed();
		
		// but return a complete other value
		return "intercept";
	}
	
}
