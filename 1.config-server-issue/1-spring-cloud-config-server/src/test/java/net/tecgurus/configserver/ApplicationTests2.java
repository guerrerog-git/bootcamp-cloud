package net.tecgurus.configserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("csc")
class ApplicationTests2 {

	@LocalServerPort
	private int randomServerPort;
	private String url = "http://localhost:{port}/academia/dev";
	String req1 = "academia.properties";
	String req2 = "academia-dev.properties";


	@Test
	public void testPropertiesLoading(){
		final String uri = url.replace("{port}", String.valueOf(randomServerPort));
		RestTemplate rt = new RestTemplate();
		String response = rt.getForObject(uri, String.class);
		Assert.hasText(response, req1);
		Assert.hasText(response, req2);
	}

}
