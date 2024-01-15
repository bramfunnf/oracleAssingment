package oracle.assignment.restapi.service;

import lombok.NoArgsConstructor;
import oracle.assignment.restapi.model.request.SampleServiceListRequest;
import oracle.assignment.restapi.model.request.SampleServiceRequest;
import oracle.assignment.restapi.model.response.SampleServiceListResponse;
import oracle.assignment.restapi.model.response.SampleServiceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSampleServicesService {

    public SampleServiceListResponse process(SampleServiceListRequest request) {
        List<SampleServiceResponse> responseList = new ArrayList<>();

        SampleServiceResponse response = new SampleServiceResponse();
        response.setTrx_id(request.getSampleservicerq().getTrx_id());
        response.setError_code("0000");
        response.setError_msg("Success");
        responseList.add(response);

        return SampleServiceListResponse.builder()
                .sampleservicers(responseList)
                .build();
    }
}
