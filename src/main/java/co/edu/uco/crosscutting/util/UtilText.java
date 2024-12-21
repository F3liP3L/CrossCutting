package co.edu.uco.crosscutting.util;

import static co.edu.uco.crosscutting.util.UtilObject.getDefaultIsNull;
import static co.edu.uco.crosscutting.util.UtilObject.isNull;

public final class UtilText {
    public static final String EMPTY = "";
    public static final String LETTERS_AND_SPACES_ONLY = "^[a-zA-ZñÑ\\s]+$";
    public static final String ANY_CHARACTER_EXCEPT_NUMBER = "[^\\d]";
    public static final String ONLY_NUMBERS = "\\d+";
    public static final String ONLY_ANY_NUMBER = "[-+]?\\d*\\.?\\d+";
    public static final String ONLY_CHARACTERS_AND_NUMBERS = "^[a-zA-Z0-9]*$";
    public static final String SPACE = " ";
    private UtilText() {}
    public static String getDefault(final String value,final String defaultValue) {
        return getDefaultIsNull(value, getDefault(defaultValue));
    }
    public static String getDefault(final String value) {
        return getDefaultIsNull(value, EMPTY);
    }
    public static String trim(final String value) {return getDefault(value).trim();}
    public static boolean isEmpty(final String value) {
        return EMPTY.equals(trim(value));
    }
    public static boolean isEmptyOrNull(final String value) {
        return isEmpty(value) || isNull(value);
    }
    public static boolean isContainsOnlyLetterAndSpace(final String value) {
        return validMatch(value, LETTERS_AND_SPACES_ONLY);
    }
    public static boolean validMatch(final String value,final String expression) {
        return value.matches(expression);
    }
}