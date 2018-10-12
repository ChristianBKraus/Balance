package jupiterpa.balance.odata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sap.cloud.sdk.service.prov.api.annotations.*;
import com.sap.cloud.sdk.service.prov.api.exits.BeforeCreateResponse;
import com.sap.cloud.sdk.service.prov.api.ExtensionHelper;
import com.sap.cloud.sdk.service.prov.api.request.*;

import jupiterpa.util.odata.*;
import jupiterpa.balance.*;
import jupiterpa.balance.model.*;
import jupiterpa.balance.repository.Repository;
import jupiterpa.balance.repository.RepositoryInterface;

public class ServiceHook {
	public final static String serviceName = "BalanceService";
	public final static String account = "Account";
	public final static String transaction = "Transaction";
	
	private final Logger logger = LoggerFactory.getLogger(ServiceHook.class);
	
    @BeforeCreate (entity = account, serviceName = ServiceHook.serviceName) 
    public BeforeCreateResponse beforecreateAccount(CreateRequest cr, ExtensionHelper eh) {
    	logger.info("Validate " + account);
    	
    	try {
    	    getValidator(cr,eh).validate(cr.getData().as(Account.class));
			return new ResponseBuilder().buildBeforeCreateResponse(null); //use this API if the payload has not been modified.
    	} catch (ValidationException e) {
		    return new ResponseBuilder().buildBeforeCreateResponse(e);
    	}
    }

    @BeforeCreate (entity = transaction, serviceName = ServiceHook.serviceName) 
    public BeforeCreateResponse beforecreateTransaction(CreateRequest cr, ExtensionHelper eh) {
    	logger.warn("Validate " + transaction);
    	
    	try {
    	    getValidator(cr,eh).validate(cr.getData().as(Transaction.class));
		    return new ResponseBuilder().buildBeforeCreateResponse(null); //use this API if the payload has not been modified.
    	} catch (ValidationException e) {
		    return new ResponseBuilder().buildBeforeCreateResponse(e); //use this API if the payload has not been modified.
    	}  
    }
    
    private RepositoryInterface getRepo(GenericRequest r, ExtensionHelper eh) {
    	RepositoryInterface repo = new Repository(eh.getHandler(),r.getEntityMetadata().getNamespace());
    	return repo;
    }
    private Validation getValidator(GenericRequest r, ExtensionHelper eh) {
    	return new Validation(getRepo(r,eh));
    }
}
