package com.tottokug.projectoxford.client;

public interface OxfordResponse {
    
    int getResponseStatus();
    String getMessage();
    byte[] getResponseBody();
    String getContentType();

}
