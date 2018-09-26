package org.mdeforge.artifactservice.dao;

import org.mdeforge.servicemodel.common.BusinessException;

public class DuplicateNameException extends BusinessException {

    public DuplicateNameException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }
}
