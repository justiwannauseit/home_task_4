package otus.core.apiConfig;


import otus.core.apiConfig.util.PropertyListenerUtil;

public class BaseConfig {

    private static final String configPath = "src/test/resources/stub.properties";

    public static final String BASE_URL = getProperty("base.url");

    public static final String USER_GET_URL = getProperty("user.get.url");
    public static final String USER_ADD_URL = getProperty("user.add.url");

    public static final String PERFORMANCE_GET_URL = getProperty("performance.get.url");

    public static final String COURSE_GET_URL = getProperty("course.get.url");

    private static String getProperty(final String param) {
        return PropertyListenerUtil.getPropertyFromFile(configPath, param);
    }

}
