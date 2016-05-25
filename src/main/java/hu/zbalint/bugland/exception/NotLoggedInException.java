package hu.zbalint.bugland.exception;

public class NotLoggedInException extends Exception {
    public NotLoggedInException() {
        super();
    }

    public NotLoggedInException(String message) {
        super(message);
    }
}
