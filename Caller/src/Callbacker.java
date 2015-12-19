import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A simple class that uses reflection to implement a callback
 * Created by erickpires on 19/12/15.
 */
public class Callbacker<T> {

    private Method method;
    private Object object;

    public Callbacker(Class objectClass, String methodName, Class... argumentsTypes) throws NoSuchMethodException {
        prepareMethod(objectClass, methodName, argumentsTypes);
    }

    public Callbacker(Object object, String methodName, Class... argumentsTypes) throws NoSuchMethodException {
        this.object = object;

        prepareMethod(object.getClass(), methodName, argumentsTypes);
    }

    private void prepareMethod(Class objectClass, String methodName, Class... argumentsTypes) throws NoSuchMethodException {
        Method[] methods = objectClass.getMethods();
        method = objectClass.getMethod(methodName, argumentsTypes);
    }

    public T call(Object... arguments) throws InvocationTargetException, IllegalAccessException {
        Object result = method.invoke(object, arguments);
        return (T) result;

    }
}
