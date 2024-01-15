package oracle.assignment.restapi.model.request;

import lombok.Getter;

@Getter
public class SampleServiceRequest {
    String service_id;
    String order_type;
    String type;
    String trx_id;
}
