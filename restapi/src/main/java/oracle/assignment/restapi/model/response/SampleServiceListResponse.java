package oracle.assignment.restapi.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SampleServiceListResponse {
    SampleServiceResponse sampleservicers;
}
