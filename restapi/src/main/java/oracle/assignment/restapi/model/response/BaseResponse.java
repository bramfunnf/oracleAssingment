package oracle.assignment.restapi.model.response;

import lombok.Data;

@Data
public class BaseResponse {
    private String error_code;
    private String error_msg;
}
