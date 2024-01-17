package oracle.assignment.soap.component;

import com.oracle.external.services.sampleservice.request.v1.Sampleservicerq;
import com.oracle.external.services.sampleservice.request.v1.Sampleservicers;
import oracle.assignment.soap.SampleServiceUtils;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SampleServiceRepository {
    private final String REST_URL = "http://localhost:8321/external/services/rest/sample-service";
    public Sampleservicers process(Sampleservicerq request, RestTemplate restTemplate) throws Exception {
        SampleServiceRequestRest restReq = new SampleServiceRequestRest();
        restReq.setSampleservicerq(request);
        HttpEntity<SampleServiceRequestRest> requestEntity = SampleServiceUtils.buildRequestWithJson(restReq);

        SampleServiceResponseRest response = restTemplate.postForObject(REST_URL, requestEntity, SampleServiceResponseRest.class);
        if (response == null) {
            throw new Exception("Internal Server Error when hit Rest-API");
        }
        return response.getSampleservicers();
    }

}
