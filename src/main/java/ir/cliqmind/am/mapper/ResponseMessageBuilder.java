package ir.cliqmind.am.mapper;

import ir.cliqmind.am.dto.ResponseMessage;

public class ResponseMessageBuilder {

    public ResponseMessage success(){
        return new ResponseMessage().result("ok");
    }

    public ResponseMessage failure(Exception ex) {
        return failure(ex.getMessage());
    }

    public ResponseMessage failure(String msg) {
        return new ResponseMessage().result("nok").message(msg);
    }
}
