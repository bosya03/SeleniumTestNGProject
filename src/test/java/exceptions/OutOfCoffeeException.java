package exceptions;

public class OutOfCoffeeException extends RuntimeException {

    public OutOfCoffeeException(String message) {
        super(message);
    }
}
