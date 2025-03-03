package LF05.nogard;

public class BefehlUnbekanntException extends Exception {
    private String message;
    public BefehlUnbekanntException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
