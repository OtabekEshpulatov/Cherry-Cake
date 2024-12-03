package org.cherry.properties;

public class EnvProperties {
    private static String env;

    static {
        setEnv();
    }

    public static String getEnv() {
        return env;
    }

    public static void setEnv() {
        env = EnvPropertiesConst.URL;
    }
}
