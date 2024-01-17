package oracle.assignment.soap.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/www.oracle.com/*");
    }

    @Bean(name = "sample-service")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema sampleServiceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SampleService");
        wsdl11Definition.setLocationUri("/www.oracle.com");
        wsdl11Definition.setTargetNamespace("http://www.oracle.com/external/services/sampleservice/response/v1.0");
        wsdl11Definition.setSchema(sampleServiceSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema sampleServiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("sample-service.xsd"));
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
