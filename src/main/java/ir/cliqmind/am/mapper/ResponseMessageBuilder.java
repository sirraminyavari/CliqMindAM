package ir.cliqmind.am.mapper;

import ir.cliqmind.am.dto.ResponseMessage;
import org.springframework.http.ResponseEntity;

public class ResponseMessageBuilder {

    public ResponseMessage success(){
        return new ResponseMessage().result("ok");
    }

    public ResponseMessage failure(Exception ex) {
        return new ResponseMessage().result("nok").message(ex.getMessage());
    }
}
