/**
 * Created by qmxie on 10/18/16.
 */
public class WrappedName {
    private String packageName;
    private String className;
    private String methodName;
    public WrappedName(String service, String method) {
        this.packageName = service.substring(0, service.lastIndexOf(".") + 1);
        this.className = service.substring(service.lastIndexOf(".") + 1);
        this.methodName = method;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }
}

