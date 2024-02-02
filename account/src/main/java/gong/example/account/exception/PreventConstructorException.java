package gong.example.account.exception;

public class PreventConstructorException extends RuntimeException{
    public PreventConstructorException(String msg) {
        super(msg);
    }
}
