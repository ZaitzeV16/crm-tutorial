package com.vaadin.tutorial.crm.backend.library.exception;

import java.net.MalformedURLException;

public class MyFileNotFoundException extends RuntimeException {

    public MyFileNotFoundException(String message) {
        super(message);
    }

    public MyFileNotFoundException(String s, MalformedURLException ex) {
    }

}
