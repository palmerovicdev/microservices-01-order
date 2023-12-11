package org.suehay.microservicesorder.models.response;

public record BaseResponse (String[] message){
    public boolean isSuccess() {
        return message == null || message.length == 0;
    }

    public boolean hasError() {
        return !isSuccess();
    }
}