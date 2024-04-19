package MyExceptions;

public class MyIndexOutOfBoundsException extends RuntimeException{
    public MyIndexOutOfBoundsException(int index){
        super(String.format("Index out of bounds: %d.", index));
    }
}
