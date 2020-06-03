/* Author: Carl Christian Hasselbalch */

package com.nmr.nmp.domain.exceptions;

import java.sql.SQLException;

public class DatabaseException extends SQLException {

    private String message;

    public DatabaseException(String reason, String message) {
        super(reason);
        this.message = message;
    }
}
