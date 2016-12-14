package pca.service.authentication;


import pca.persistence.dao.UserDao;
import pca.persistence.dto.UserDto;
import pca.persistence.model.User;

public class AuthenticationService {
    private UserDao userDao;

    public boolean isUserValid(UserDto userDto) {
        return userDao.isValid(convertFromDto(userDto));
    }

    private User convertFromDto(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
