package userdb;

import java.util.HashMap;
import java.util.Objects;

public class UserList {
    private HashMap<Integer, User> userMap = new HashMap<Integer, User>();
    public UserList(){
        addUser(new User("Sanjaya","123"));
        addUser(new User("John","1234"));
        addUser(new User("Peter","123"));
        addUser(new User("Jim","123"));
        addUser(new User("Tom","123"));
        addUser(new User("Dom","123"));
    }

    public HashMap<Integer, User> getUserMap() {
        return userMap;
    }

    public void addUser(User user){
        userMap.put(user.getKey(),user);
    }

    public boolean isValidUser(String username, String password){
        int key = Objects.hash(username,password);
        User user;
        if(userMap.containsKey(key)){
            user = userMap.get(key);
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

}
