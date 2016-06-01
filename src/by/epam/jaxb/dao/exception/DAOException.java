package by.epam.jaxb.dao.exception;

/**
 * Created by Владислав on 28.05.2016.
 */
public class DAOException extends Exception {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Exception cause) {
        super(message, cause);
    }

}
