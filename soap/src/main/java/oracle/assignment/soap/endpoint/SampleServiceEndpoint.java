package oracle.assignment.soap.endpoint;

import com.oracle.external.services.sampleservice.request.v1.Sampleservicerq;
import com.oracle.external.services.sampleservice.request.v1.Sampleservicers;
import oracle.assignment.soap.component.SampleServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Endpoint
public class SampleServiceEndpoint {

    private static final String NAMESPACE_URI = "http://www.oracle.com/external/services/sampleservice/response/v1.0";

    @Autowired
    private SampleServiceRepository sampleServiceRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sampleservicerq")
    @ResponsePayload
    public JAXBElement<Sampleservicers> getSampleServiceResponse(@RequestPayload JAXBElement<Sampleservicerq> request) {
        Sampleservicers response = new Sampleservicers();
        try {
            response = sampleServiceRepository.process(request.getValue(), restTemplate);
        }catch (Exception e) {
            response.setErrorMsg("500");
            response.setErrorMsg(e.getMessage());
        }

        return new JAXBElement<>(
                QName.valueOf("Sampleservicers"),
                Sampleservicers.class,
                response);
    }
}
