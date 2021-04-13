package hello;


import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class RequestBinder implements Serializable {

    private String requestedIp;
    private String authKey;
    private String userId;
    
	public String getRequestedIp() {
		return requestedIp;
	}
	public void setRequestedIp(String requestedIp) {
		this.requestedIp = requestedIp;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}