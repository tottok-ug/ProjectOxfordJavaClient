package com.tottokug.projectoxford.computervision;

import java.util.Map;

public interface OxfordRequest {

    String getpath();

    Map<String, Object> getPathParameters();

    Map<String, Object> getPostParamters();

    
}
