package com.tottokug.projectoxford;

import com.tottokug.projectoxford.computervision.exception.ComputerVisionException;

public interface OxfordClient {

	<T extends OxfordResponse<?>> T request(OxfordRequest request, T response) throws ComputerVisionException;

}
