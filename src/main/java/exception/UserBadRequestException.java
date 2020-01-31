package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserBadRequestException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    public UserBadRequestException(String message) {
        super(message);
    }
    

}
