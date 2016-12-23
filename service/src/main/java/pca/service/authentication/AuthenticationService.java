package pca.service.authentication;


import pca.persistence.dao.UserDao;
import pca.persistence.dto.PersistentUserDto;
import pca.persistence.dto.UserDto;

public class AuthenticationService {
    private UserDao userDao;
    private Converter converter;

    public boolean isUserValid(UserDto userDto) {
        return userDao.isValid(converter.getUser(userDto));
    }

    public UserDto getUser(String userName) {
        return converter.getUserDto(userDao.getUser(userName));
    }

    public void creatUser(UserDto userDto) {
        userDao.crateUser(converter.getUser(userDto));
    }

    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }

    public void savePersistentUser(PersistentUserDto persistentUserDto) {
        userDao.savePersistentUser(converter.getPersistentUser(persistentUserDto));
    }

    public PersistentUserDto getPersistentUserBySerises(String series) {
        return converter.getPersistentUserDto(userDao.getBySerises(series));
    }

    public void updatePersistentUser(PersistentUserDto persistentUserDto) {
        userDao.updatePersistentUser(converter.getPersistentUser(persistentUserDto));
    }

    public PersistentUserDto getPersistentUserByUserName(String userName) {
        return converter.getPersistentUserDto(userDao.getByUserName(userName));
    }

    public void deletPersistentUser(PersistentUserDto persistentUserDto) {
        userDao.deletPersistentUser(converter.getPersistentUser(persistentUserDto));
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
