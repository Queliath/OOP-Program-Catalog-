package by.epam.jaxb.service.exception;

/**
 * Created by Владислав on 28.05.2016.
 */
public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }
}
