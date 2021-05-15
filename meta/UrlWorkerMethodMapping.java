package meta;

import java.lang.reflect.Method;

public class UrlWorkerMethodMapping {
    public String url;
    public Class<?> className;
    public Method methodName;

    public UrlWorkerMethodMapping(String url, Class<?> className, Method methodName){
        this.url = url;
        this.className = className;
        this.methodName = methodName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Class<?> getClassName() {
        return className;
    }
    public void setClassName(Class<?> className) {
        this.className = className;
    }
    public Method getMethodName() {
        return methodName;
    }
    public void setMethodName(Method methodName) {
        this.methodName = methodName;
    }
}
