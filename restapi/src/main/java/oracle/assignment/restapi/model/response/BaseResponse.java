package oracle.assignment.restapi.model.response;

import lombok.Data;

@Data
public class BaseResponse {
    protected String errorCode;
    protected String errorMsg;
}
