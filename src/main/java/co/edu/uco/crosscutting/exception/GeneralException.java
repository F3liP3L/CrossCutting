package co.edu.uco.crosscutting.exception;

import java.io.Serial;

import static co.edu.uco.crosscutting.util.UtilObject.getDefaultIsNull;
import static co.edu.uco.crosscutting.util.UtilText.trim;

public class GeneralException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -3393801537376736983L;
    private String userMessage;
    private String technicalMessage;
    private Exception rootException;
    public static GeneralException build(final String technicalMessage) {
        return new GeneralException(null, technicalMessage, null);
    }
    public static GeneralException build(final String technicalMessage, Exception rootException) {
        return new GeneralException(null, technicalMessage, rootException);
    }
    protected GeneralException(final String userMessage, final String technicalMessage, Exception rootException) {
        super();
        setUserMessage(userMessage);
        setTechnicalMessage(technicalMessage);
        setRootException(rootException);
    }
    public String getUserMessage() {
        return userMessage;
    }
    public String getTechnicalMessage() {
        return technicalMessage;
    }
    public Exception getRootException() {
        return rootException;
    }
    private void setUserMessage(String userMessage) {
        this.userMessage = trim(userMessage);
    }
    private void setTechnicalMessage(String technicalMessage) {
        this.technicalMessage = trim(technicalMessage);
    }
    private void setRootException(Exception rootException) {
        this.rootException = getDefaultIsNull(rootException, new Exception());
    }
}