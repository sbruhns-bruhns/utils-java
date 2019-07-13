package tech.stefanbruhns.utils.http;

@SuppressWarnings("serial")
public class HttpResponseReaderException extends Exception {
	
	public HttpResponseReaderException(String msg, Throwable t) {
		super(msg, t);
	}
}
