package tech.stefanbruhns.utils.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

public class HttpResponseReader {

	public static String readFromStream(InputStream is, String charsetName) throws HttpResponseReaderException {
		StringBuilder sb = new StringBuilder();
		byte[] bytes = new byte[100];

		try (BufferedInputStream bis = new BufferedInputStream(is)) {
			
			while (bis.read(bytes) > 0) {
				sb.append(new String(bytes, Charset.forName(charsetName)));
				bytes = new byte[100];
			}

		} catch (IOException e) {
			throw new HttpResponseReaderException(e.getMessage(), e);
		}

		return sb.toString();
	}

//	public static String readFromStream(GZIPInputStream gis, String charsetName)  throws HttpResponseReaderException {
//		StringBuilder sb = new StringBuilder();
//		byte[] bytes = new byte[100];
//
//		try (BufferedInputStream bis = new BufferedInputStream(gis)) {
//			
//			while (bis.read(bytes) > 0) {
//				sb.append(new String(bytes, Charset.forName(charsetName)));
//				bytes = new byte[100];
//			}
//
//		} catch (IOException e) {
//			throw new HttpResponseReaderException(e.getMessage(), e);
//		}
//
//		return sb.toString();
//	}
}
