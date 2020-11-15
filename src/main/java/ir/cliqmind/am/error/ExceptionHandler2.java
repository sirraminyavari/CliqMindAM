package ir.cliqmind.am.error;

import ir.cliqmind.am.dto.ResponseMessage;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import ir.cliqmind.am.service.TransactionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandler2 {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler2.class);

    private ResponseMessageBuilder responseMessageBuilder;

    @Autowired
    public ExceptionHandler2(){
        responseMessageBuilder = new ResponseMessageBuilder();
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseMessage> exception(Exception exception) {
        log.error("Error occured", exception);
        return new ResponseEntity<>(responseMessageBuilder.failure(exception),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ResponseMessage> exception(DataIntegrityViolationException exception) {
        log.error("Error occured in sql operations", exception);
        return new ResponseEntity<>(responseMessageBuilder.failure(
                "Invalid Request due to database integration policies"),
                HttpStatus.BAD_REQUEST);
    }

}
