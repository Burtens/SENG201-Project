public class IllegalTypeException extends IllegalArgumentException {

    public IllegalTypeException(){}

    public IllegalTypeException(String message){ super("The type (" + message + ") is not valid for this item.");}
}
