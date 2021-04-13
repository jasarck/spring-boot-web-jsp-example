package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;


@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    DataSource dataSource;


   
    @Override
    public boolean isAuthKeyValid(String authKey) throws SQLException {

        return false;
    }

   

   

    @Override
    public String getUserIdByAuthKey(String authKey) throws SQLException {
   
        return null;
    }






}
