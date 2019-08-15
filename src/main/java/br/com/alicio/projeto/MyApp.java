package br.com.alicio.projeto;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class MyApp extends ResourceConfig {

	public MyApp() {
		packages("br.com.proway.api.controller");
	}
}