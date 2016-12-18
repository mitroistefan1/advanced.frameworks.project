package pca.service.authentication;


import pca.persistence.dao.UserDao;
import pca.persistence.dao.UserDaoImpl;
import pca.persistence.dto.UserDto;
import pca.persistence.model.User;

public class AuthenticationService {
    private UserDao userDao = new UserDaoImpl();
    private Converter converter = new Converter();

    public boolean isUserValid(UserDto userDto) {
        return userDao.isValid(converter.getUser(userDto));
    }

    public UserDto getUser(String userName){
        return converter.getUserDto(userDao.getUser(userName));
    }


    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    public Converter getConverter() {
        return converter;
    }
}
