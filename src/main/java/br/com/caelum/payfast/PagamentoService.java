package br.com.caelum.payfast;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("/v1")
public class PagamentoService extends Application {

	public PagamentoService() {
		BeanConfig conf = new BeanConfig();
		conf.setTitle("Payfast API");
		conf.setDescription("Pagamentos rápidos");
		conf.setVersion("1.0.0");
		conf.setHost("localhost:8080");
		conf.setBasePath("/fj36-payfast/v1");
		conf.setSchemes(new String[] { "http" });
		conf.setResourcePackage("br.com.caelum.payfast");
		conf.setScan(true);
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		resources.add(JacksonJavaTimeConfiguration.class);
		resources.add(PagamentoResource.class);
		resources.add(ApiListingResource.class);
		resources.add(SwaggerSerializers.class);
		return resources;
	}

}
