package de.hhn.prog2.lab03;

import java.rmi.server.ExportException;

public class NoFreeTimeException extends ExportException {

    /**
     * Exception class
     * @param s
     */

    public NoFreeTimeException(String s) {
        super(s);

    }

}
