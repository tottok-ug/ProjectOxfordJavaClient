package com.tottokug.projectoxford.client;

import java.util.Map;

public interface OxfordRequest {

    String getpath();

    Map<String, Object> getPathParameters();

    Map<String, Object> getPostParamters();

    
}
