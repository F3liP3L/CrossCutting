package co.edu.uco.crosscutting.util;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

public class UtilNumeric {
    private static final UtilNumeric INSTANCE = new UtilNumeric();
    public static final Byte ZERO = 0;
    private UtilNumeric() {}
    public static UtilNumeric getUtilNumeric() {
        return INSTANCE;
    }

    public <T extends Number> T getDefault(T value, T defaultValue) {
        return getUtilObject().getDefaultIsNull(value, defaultValue);

    }

    public <T extends Number> Number getDefault(T value) {
        return getDefault(value, ZERO);
    }

    public <T extends Number> boolean isGreaterThan(T firstValue, T secondValue) {
        return getDefault(firstValue).doubleValue() > getDefault(secondValue).doubleValue();
    }

    public <T extends Number> boolean isLessThan(T firstValue,T secondValue) {
        return getDefault(firstValue).doubleValue() < getDefault(secondValue).doubleValue();
    }

    public <T extends Number> boolean isEqualThan(T firstValue,T secondValue) {
        return getDefault(firstValue).doubleValue() == getDefault(secondValue).doubleValue();
    }

    public <T extends Number> boolean isGreaterOrEqualThan(T firstValue, T secondValue) {
        return getDefault(firstValue).doubleValue() >= getDefault(secondValue).doubleValue();
    }

    public <T extends Number> boolean isLessOrEqualThan(T firstValue,T secondValue) {
        return getDefault(firstValue).doubleValue() <= getDefault(secondValue).doubleValue();
    }

    public <T extends Number> boolean isDifferent(T firstValue,T secondValue) {
        return getDefault(firstValue).doubleValue() != getDefault(secondValue).doubleValue();
    }

    public <T extends Number> boolean isBetween(T value, T initialRange, T finalRange,
                                                boolean includeInitialRange, boolean includeFinalRange) {
        return (includeInitialRange
                ? isGreaterOrEqualThan(value, initialRange)
                : isGreaterThan(value, initialRange))
                &&
                (includeFinalRange
                        ? isLessOrEqualThan(value, finalRange)
                        : isLessThan(value, finalRange));
    }

    public <T extends Number> boolean isBetweenIncludingRanges(T value, T initialValue, T finalValue) {
        return isBetween(value, initialValue, finalValue, true, true);
    }

    public <T extends Number> boolean isPositive(T value) {
        return isGreaterOrEqualThan(value, ZERO);
    }
}
