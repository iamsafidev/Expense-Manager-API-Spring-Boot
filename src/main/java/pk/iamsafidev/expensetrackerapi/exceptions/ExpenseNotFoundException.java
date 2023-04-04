package pk.iamsafidev.expensetrackerapi.exceptions;

public class ExpenseNotFoundException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
