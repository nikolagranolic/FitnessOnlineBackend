package org.unibl.etf.fitnessonline.exceptions;

import org.springframework.http.HttpStatus;

public class Unauthorized extends HttpException {
    public Unauthorized() {
        super(HttpStatus.UNAUTHORIZED, null);
    }

    public Unauthorized(Object data) {
        super(HttpStatus.UNAUTHORIZED, data);
    }
}
