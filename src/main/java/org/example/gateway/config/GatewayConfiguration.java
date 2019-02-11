package org.example.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "org.example.gateway")
public class GatewayConfiguration {

	private String httpUri;
	private String wsUri;

	public String getHttpUri() {
		return httpUri;
	}

	public void setHttpUri(String httpUri) {
		this.httpUri = httpUri;
	}

	public String getWsUri() {
		return wsUri;
	}

	public void setWsUri(String wsUri) {
		this.wsUri = wsUri;
	}
}

