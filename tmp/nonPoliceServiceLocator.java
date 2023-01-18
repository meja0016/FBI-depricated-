import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.naming.Context;
import com.ibm.websphere.naming.PROPS;

/*****
 Caching discussed in this section pertains to the WebSphere Application Server initial context factory.
 Assume the property, java.naming.factory.initial, is set to
 "com.ibm.websphere.naming.WsnInitialContextFactory" as a java.lang.System property.
*****/

public class nonPoliceServiceLocator{

    nonPoliceServiceLocator nonPoliceServiceLocator = null;

    public getInstance nonPoliceServiceLoctar(){
            if (nonPoliceServiceLocator==null){
                nonPoliceServiceLocator = new nonPoliceServiceLocator();
            }
            return nonPoliceServiceLocator;
    }

public static void main(String[] args){

    /*
Hashtable env;
Context ctx;
env = new Hashtable();
env.put(PROPS.JNDI_CACHE_OBJECT, PROPS.JNDI_CACHE_OBJECT_CLEARED);
ctx = new InitialContext(env);
env = new Hashtable();
env.put(PROPS.JNDI_CACHE_MAX_LIFE, "60");
ctx = new InitialContext(env);
env = new Hashtable();
env.put(PROPS.JNDI_CACHE_OBJECT, PROPS.JNDI_CACHE_OBJECT_NONE);
ctx = new InitialContext(env);
env = new Hashtable();
env.put(PROPS.JNDI_CACHE_OBJECT, PROPS.JNDI_CACHE_OBJECT_POPULATED);
ctx = new InitialContext(env);
env.put(PROPS.JNDI_CACHE_OBJECT, PROPS.JNDI_CACHE_OBJECT_NONE);
Context noCacheCtx = new InitialContext(env);
Object o;
o = ctx.lookup("com/mycom/MyEJBHome");
o = noCacheCtx.lookup("com/mycom/VolatileObject");
 */

}

}