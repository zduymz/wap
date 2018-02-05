package edu.mum.wap.dao;

import edu.mum.wap.model.Result;
import edu.mum.wap.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private Map<String, User> moviesDb = new HashMap<String, User>();
    {
        moviesDb.put("trung", new User("trung", "1234", "trung@mail.com"));
        moviesDb.put("duy",new User("duy","1234", "duy@mail.com"));
    }

    public Result addUser(User user) {
        boolean ret = false;
        String reason = "";
        if(!moviesDb.containsKey(user.getUsername())) {
            for(User u : moviesDb.values()) {
                if(u.getUemail().equals(user.getUemail())) {
                    reason = "Email is already exists";
                    break;
                }
            }
            if(reason.isEmpty()) {
                ret = true;
                moviesDb.put(user.getUsername(),user);
            }
        } else {
            reason = "User is already exists";
        }
        return new Result(ret, reason);
    }

    public void deleteUser(String userName) {
        moviesDb.remove(userName);
    }

    public boolean verifyUser(User user) {
        return moviesDb.containsValue(user);
    }
}
