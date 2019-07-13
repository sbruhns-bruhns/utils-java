package tech.stefanbruhns.utils.http;

@SuppressWarnings("serial")
public class HttpClientFactoryException extends Exception {
	
	public HttpClientFactoryException(String msg, Throwable t) {
		super(msg, t);
	}
}
