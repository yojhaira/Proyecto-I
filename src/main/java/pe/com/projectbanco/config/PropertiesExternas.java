package pe.com.projectbanco.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesExternas {

	@Value("${ws.constante.uno}")
	public String valor;
	
	@Value("${ws.validarDisponibilidadUrl}")
	public String validarDisponibilidadUrl;

}
