package oracle.assignment.restapi.service;

import oracle.assignment.restapi.model.request.SampleServiceListRequest;
import oracle.assignment.restapi.model.response.SampleServiceListResponse;
import oracle.assignment.restapi.model.response.SampleServiceResponse;
import org.springframework.stereotype.Service;

@Service
public class PostSampleServicesService {

    public SampleServiceListResponse process(SampleServiceListRequest request) {
        SampleServiceResponse response = new SampleServiceResponse();
        response.setTrxId(request.getSampleservicerq().getTrxId());
        response.setErrorCode("0000");
        response.setErrorMsg("Success");
        return SampleServiceListResponse.builder()
                .sampleservicers(response)
                .build();
    }
}
