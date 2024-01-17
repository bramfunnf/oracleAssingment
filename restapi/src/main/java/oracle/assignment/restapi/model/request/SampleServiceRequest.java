package oracle.assignment.restapi.model.request;

import lombok.Getter;

@Getter
public class SampleServiceRequest {
    String serviceId;
    String orderType;
    String type;
    String trxId;
}
