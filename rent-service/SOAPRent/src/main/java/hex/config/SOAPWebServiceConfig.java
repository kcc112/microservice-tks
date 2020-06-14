package hex.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SOAPWebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soap/*");
    }

    @Bean
    public XsdSchema technologySchema() {
        return new SimpleXsdSchema(new ClassPathResource("technology.xsd"));
    }


    @Bean(name = "technologyWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema technologySchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setSchema(technologySchema);
        defaultWsdl11Definition.setLocationUri("/soap");
        defaultWsdl11Definition.setPortTypeName("SOAPServicePort");
        defaultWsdl11Definition.setTargetNamespace("http://www.hex.com/hex/technology");
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema developerSchema() {
        return new SimpleXsdSchema(new ClassPathResource("developer.xsd"));
    }
}
