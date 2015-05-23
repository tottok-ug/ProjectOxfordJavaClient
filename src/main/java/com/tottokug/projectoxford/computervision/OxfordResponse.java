package com.tottokug.projectoxford.computervision;

public interface OxfordResponse {
    
    int getResponseStatus();
    String getMessage();
    byte[] getResponseBody();
    String getContentType();

}
