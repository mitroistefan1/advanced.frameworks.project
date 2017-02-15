package pca.converter;

import pca.persistence.model.User;
import pca.service.data.UserData;

public class UserConverter implements Converter<User,UserData> {


    public UserData convertToData(User model) {
        UserData returnUserData = new UserData();

        returnUserData.setUserName(model.getUserName());
        returnUserData.setEmail(model.getEmail());
        returnUserData.setPassword(model.getPassword());
        returnUserData.setRole(model.getRole());
        return returnUserData;
    }

    public User convertToModel(UserData data) {
        User returnUser = new User();

        returnUser.setUserName(data.getUserName());
        returnUser.setEmail(data.getEmail());
        returnUser.setPassword(data.getPassword());
        returnUser.setRole(data.getRole());
        return returnUser;
    }
}
