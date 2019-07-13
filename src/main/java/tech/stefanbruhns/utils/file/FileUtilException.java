package tech.stefanbruhns.utils.file;

@SuppressWarnings("serial")
public class FileUtilException extends Exception {

    public FileUtilException(String message, Throwable exception) {
        super(message, exception);    
    }
}
