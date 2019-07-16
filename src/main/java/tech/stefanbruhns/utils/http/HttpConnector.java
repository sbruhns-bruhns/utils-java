package tech.stefanbruhns.utils.http;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * https://docs.aylien.com/textapi/sdks/#java-sdk
 * https://hc.apache.org/httpcomponents-client-ga/
 * 
 * @author sbruhns
 *
 */
public class HttpConnector {

	public static void main(String[] args) {
		URI uri;

		try {
			uri = new URIBuilder().setScheme("https").setPort(443).setHost("www.google.com").setPath("/search").setParameter("q", "httpclient").build();

		} catch (URISyntaxException e1) {
			e1.printStackTrace();
			return;
		}

		HttpGet httpget = new HttpGet(uri);
		System.out.println("URI: " + httpget.getURI());

		try (
				CloseableHttpClient httpclient = /*HttpClients.createDefault()*/HttpClientFactory.getHttpClient();
				CloseableHttpResponse response = httpclient.execute(httpget);
			) {

			HttpEntity httpEntity = response.getEntity();
			String content = HttpResponseReader.readFromStream(httpEntity.getContent(), StandardCharsets.UTF_8.name());

			System.out.printf("Content-length: %s\r\n", httpEntity.getContentLength());
			System.out.printf("Content: %s\r\n", content);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
