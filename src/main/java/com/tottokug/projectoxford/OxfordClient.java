package com.tottokug.projectoxford;

import com.tottokug.projectoxford.computervision.exception.ComputerVisionException;

public interface OxfordClient {
    
    OxfordResponse request(OxfordRequest request) throws ComputerVisionException;
    
}
