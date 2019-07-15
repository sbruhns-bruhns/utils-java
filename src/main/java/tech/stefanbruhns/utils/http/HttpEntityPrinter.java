package tech.stefanbruhns.utils.http;

import org.apache.http.Header;

import tech.stefanbruhns.utils.print.PrintUtil;

public class HttpEntityPrinter {

	public static String asString(Header[] headers) {
		StringBuffer sb = new StringBuffer();

		for (Header h : headers) {
			sb.append(PrintUtil.padRight(h.getName(), 20, ' '));
			sb.append(": ").append(h.getValue()).append(System.lineSeparator());
		}

		return sb.toString();
	}
}
