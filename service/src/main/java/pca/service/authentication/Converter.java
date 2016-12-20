package pca.service.authentication;


import pca.persistence.dto.UserDto;
import pca.persistence.model.User;

public class Converter {

    public User getUser(UserDto userDto){
        User returnUser  = new User();

        returnUser.setUserName(userDto.getUserName());
        returnUser.setEmail(userDto.getEmail());
        returnUser.setPassword(userDto.getPassword());

        return returnUser;
    }

    public UserDto getUserDto(User user){
        UserDto returnUserDto = new UserDto();

        returnUserDto.setUserName(user.getUserName());
        returnUserDto.setEmail(user.getEmail());
        returnUserDto.setPassword(user.getPassword());
        return returnUserDto;
    }
}
