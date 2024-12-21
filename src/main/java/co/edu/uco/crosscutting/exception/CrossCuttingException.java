package co.edu.uco.crosscutting.exception;

import java.io.Serial;

public final class CrossCuttingException extends GeneralException {
    @Serial
    private static final long serialVersionUID = 2720867731923182104L;
    private CrossCuttingException(String userMessage, String technicalMessage, Exception rootException) {
        super(userMessage, technicalMessage, rootException);
    }
    public static CrossCuttingException build(String technicalMessage) {
        return new CrossCuttingException(null, technicalMessage, null);
    }
    public static CrossCuttingException build(String technicalMessage, Exception rootException) {
        return new CrossCuttingException(null, technicalMessage, rootException);
    }
    public static CrossCuttingException build(String userMessage, String technicalMessage, Exception rootException) {
        return new CrossCuttingException(userMessage, technicalMessage, rootException);
    }
}