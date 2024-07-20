package model.exceptions;


public class DomainExeption  extends RuntimeException{
    private static final long serialVerisonUID = 1L;

    public DomainExeption(String msg) {
        super(msg);
    }
}
