package edu.mum.wap.dao;

import edu.mum.wap.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private Map<String, User> moviesDb = new HashMap<String, User>();
    {
        moviesDb.put("trung", new User("trung", "1234"));
        moviesDb.put("duy",new User("duy","1234"));
    }

    public boolean addUser(User user) {
        boolean ret = false;
        if(!moviesDb.containsKey(user.getUsername())) {
            ret = true;
            moviesDb.put(user.getUsername(),user);
        }
        return ret;
    }

    public void deleteUser(String userName) {
        moviesDb.remove(userName);
    }

    public boolean verifyUser(User user) {
        return moviesDb.containsValue(user);
    }
}
