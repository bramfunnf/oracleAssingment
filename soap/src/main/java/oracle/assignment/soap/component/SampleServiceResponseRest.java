package oracle.assignment.soap.component;

import com.oracle.external.services.sampleservice.request.v1.Sampleservicers;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SampleServiceResponseRest {
    private Sampleservicers sampleservicers;
}
