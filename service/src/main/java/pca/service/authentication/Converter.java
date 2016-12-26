package pca.service.authentication;


import pca.persistence.dto.PersistentUserDto;
import pca.persistence.dto.UserDto;
import pca.persistence.model.PersistentUser;
import pca.persistence.model.User;

public class Converter {

    public User getUser(UserDto userDto) {
        User returnUser = new User();

        returnUser.setUserName(userDto.getUserName());
        returnUser.setEmail(userDto.getEmail());
        returnUser.setPassword(userDto.getPassword());
        returnUser.setRole(userDto.getRole());
        return returnUser;
    }

    public UserDto getUserDto(User user) {
        UserDto returnUserDto = new UserDto();

        returnUserDto.setUserName(user.getUserName());
        returnUserDto.setEmail(user.getEmail());
        returnUserDto.setPassword(user.getPassword());
        returnUserDto.setRole(user.getRole());
        return returnUserDto;
    }

    public PersistentUser getPersistentUser(PersistentUserDto persistentUserDto) {
        PersistentUser persistentUser = new PersistentUser();

        persistentUser.setUserName(persistentUser.getUserName());
        persistentUser.setSeries(persistentUser.getSeries());
        persistentUser.setToken(persistentUser.getToken());
        persistentUser.setDate(persistentUser.getDate());
        return persistentUser;
    }

    public PersistentUserDto getPersistentUserDto(PersistentUser persistentUser) {
        PersistentUserDto returnUserDto = new PersistentUserDto();

        returnUserDto.setUserName(persistentUser.getUserName());
        returnUserDto.setSeries(persistentUser.getSeries());
        returnUserDto.setToken(persistentUser.getToken());
        returnUserDto.setDate(persistentUser.getDate());
        return returnUserDto;
    }
}
