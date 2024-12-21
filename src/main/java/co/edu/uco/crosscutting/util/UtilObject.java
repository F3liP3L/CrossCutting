package co.edu.uco.crosscutting.util;

public final class UtilObject {
    private UtilObject() {}
    public static <T> boolean isNull(T object) {
        return object == null;
    }
    public static <T> T getDefaultIsNull(T object, T defaultValue) {
        return (isNull(object) ? defaultValue : object);
    }
}