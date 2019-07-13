package tech.stefanbruhns.utils.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpResponseReader {

	public static String readFromStream(InputStream is) throws HttpResponseReaderException {
		StringBuilder sb = new StringBuilder();
		byte[] bytes = new byte[100];

		try (BufferedInputStream bis = new BufferedInputStream(is)) {
			
			while (bis.read(bytes) > 0) {
				sb.append(new String(bytes));
				bytes = new byte[100];
			}

		} catch (IOException e) {
			throw new HttpResponseReaderException(e.getMessage(), e);
		}

		return sb.toString();
	}
}
