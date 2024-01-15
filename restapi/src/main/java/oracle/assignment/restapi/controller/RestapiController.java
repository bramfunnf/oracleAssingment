package oracle.assignment.restapi.controller;

import oracle.assignment.restapi.model.request.SampleServiceListRequest;
import oracle.assignment.restapi.model.response.SampleServiceListResponse;
import oracle.assignment.restapi.service.PostSampleServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestapiController {

    private static final String POST_SAMPLE_SERVICE = "/external/services/rest/sample-service";

    @Autowired
    private PostSampleServicesService postSampleServicesService;

    @PostMapping(POST_SAMPLE_SERVICE)
    public SampleServiceListResponse postSampleServices(@RequestBody SampleServiceListRequest request) {
        return postSampleServicesService.process(request);
    }
}
