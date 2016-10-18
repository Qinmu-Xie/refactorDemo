import org.apache.commons.lang3.StringUtils;

/*
输入：类名，方法名。
返回：用于cache的key值
要求：key值为DBO$+类名+方法名。不能超过50字符

如果大于50，去掉包名。还大于，去掉类名。然后超长，截断方法名。
 */
public class CacheKey {


    public static final String HEAD = "DBO$";
    public static final String SEPARATOR = "#";
    public static final int LIMIT = 50;

    public String generateKey(String service, String method) {
        return generateKey3(service, method);
    }

    private String generateKey1(String service, String method) {
        if (length(service, method) <= LIMIT) {
            return HEAD + service + "." + method;
        }

        service = service.substring(service.lastIndexOf(".") + 1);

        if (length(service, method) <= LIMIT) {
            return HEAD + service + "." + method;
        }

        service = "";

        if (length(service, method) <= LIMIT) {
            return HEAD + service + method;
        }

        return (HEAD + service + method).substring(0, 48) + ".~";
    }

    public String generateKey2(String service, String method) {
        String afterConcat = concatWithSeparator(service, method);
        String afterCut = cutToLimit(afterConcat);

        int nubOfSEP = StringUtils.countMatches(afterCut, SEPARATOR);
        if (nubOfSEP == 2) {
            return afterCut.startsWith(getPackageName(service)) ?
                    HEAD + getPackageName(service) + getClassName(service) + method :
                    HEAD + getClassName(service) + method;
        }
        if (nubOfSEP == 1) {
            return HEAD + method;
        }
        if (nubOfSEP == 0) {
            return (HEAD + method).substring(0, 48) + ".~";
        }
        throw new RuntimeException("Should not be here.");
    }

    public String generateKey3(String service, String method) {
        System.out.println(method.length());
        return new strLimit(LIMIT)
                .tryString(method.length() >= 46? (HEAD + method).substring(0, 48) + ".~" : "")
                .tryString(HEAD + method)
                .tryString(HEAD + getClassName(service) + method)
                .tryString(HEAD + getPackageName(service) + getClassName(service) + method)
                .get();
    }


    private String cutToLimit(String afterConcat) {
        if (afterConcat.length() + HEAD.length() + 2 > LIMIT) {
            return StringUtils.right(afterConcat, LIMIT - 2 - HEAD.length());
        } else {
            return afterConcat;
        }
    }

    private String concatWithSeparator(String service, String method) {
        return getPackageName(service) + SEPARATOR + getClassName(service) + SEPARATOR + method;
    }

    private String getPackageName(String service) {
        return service.substring(0, service.lastIndexOf(".")) + ".";
    }

    private String getClassName(String service) {
        return service.substring(service.lastIndexOf(".") + 1) + ".";
    }

    private int length(String service, String method) {
        return HEAD.length() + service.length() + method.length();
    }
}
