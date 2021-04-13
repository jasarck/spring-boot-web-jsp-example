package hello;


import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public interface CommonService {


    public boolean isAuthKeyValid(String authKey) throws SQLException;
    public String getUserIdByAuthKey(String authKey) throws SQLException;

}
