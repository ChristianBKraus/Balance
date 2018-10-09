package jupiterpa.util.odata;

import com.sap.cloud.sdk.service.prov.api.Severity;
import com.sap.cloud.sdk.service.prov.api.exits.BeforeCreateResponse;
import com.sap.cloud.sdk.service.prov.api.response.ErrorResponse;

public class ResponseBuilder {
	public BeforeCreateResponse buildBeforeCreateResponse(ValidationException ex) {
    	if (ex == null) {
    		  return BeforeCreateResponse.setSuccess().response(); //use this API if the payload has not been modified.
      	} else {
      		return BeforeCreateResponse.setError(
      			ErrorResponse.getBuilder()
                      .setCause(ex).setMessage(ex.getMessage(),(Object[]) ex.getParameter())
                      .addContainerMessages(Severity.ERROR, Severity.INFO) 
                      //.addErrorDetail(keyDetail, target)
                      .response());      		
      	}
	}
}