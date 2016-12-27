package pca.service.authentication;


import pca.persistence.dto.TokenUserDto;
import pca.persistence.dto.UserDto;
import pca.persistence.model.TokenUser;
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

    public TokenUser getPersistentUser(TokenUserDto tokenUserDto) {
        TokenUser tokenUser = new TokenUser();

        tokenUser.setUserName(tokenUser.getUserName());
        tokenUser.setSeries(tokenUser.getSeries());
        tokenUser.setToken(tokenUser.getToken());
        tokenUser.setDate(tokenUser.getDate());
        return tokenUser;
    }

    public TokenUserDto getPersistentUserDto(TokenUser tokenUser) {
        TokenUserDto returnUserDto = new TokenUserDto();

        returnUserDto.setUserName(tokenUser.getUserName());
        returnUserDto.setSeries(tokenUser.getSeries());
        returnUserDto.setToken(tokenUser.getToken());
        returnUserDto.setDate(tokenUser.getDate());
        return returnUserDto;
    }
}
