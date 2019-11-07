package ctsp.kedacom.com.util;

public class LoaderUtil {

    public static ClassLoader findClassLoader(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return getClassLoaderByClass(o.getClass());
    }

    public static ClassLoader getClassLoaderByClass(Class<?> clazz) {
        return clazz.getClassLoader() == null ? ClassLoader.getSystemClassLoader() : clazz.getClassLoader();
    }
}
