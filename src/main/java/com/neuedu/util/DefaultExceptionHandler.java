package com.neuedu.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public Message exceptionHandler(HttpServletRequest request,Exception e){
        Message message = new Message();
        message.setCode(500);
        message.setMessage("对不起异常了:"+e.getMessage());
        return message;
    }
}
