package pca.service.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.persistence.dao.TokenUserDao;
import pca.persistence.dao.UserDao;
import pca.persistence.dto.TokenUserDto;
import pca.persistence.dto.UserDto;

@Service
public class AuthenticationService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenUserDao tokenUserDao;

    private Converter converter;

    public UserDto getUser(String userName) {
        return converter.getUserDto(userDao.findByUserName(userName));
    }

    public void creatUser(UserDto userDto){
        userDao.save(converter.getUser(userDto));
    }
    public void savePersistentUser(TokenUserDto tokenUserDto) {
        tokenUserDao.save(converter.getPersistentUser(tokenUserDto));
    }

    public TokenUserDto getPersistentUserBySeries(String series) {
        return converter.getPersistentUserDto(tokenUserDao.findBySeries(series));
    }

    public void updatePersistentUser(TokenUserDto tokenUserDto) {
        tokenUserDao.save(converter.getPersistentUser(tokenUserDto));
    }

    public TokenUserDto getPersistentUserByUserName(String userName) {
        return converter.getPersistentUserDto(tokenUserDao.findByUserName(userName));
    }

    public void deletPersistentUser(TokenUserDto tokenUserDto) {
        tokenUserDao.delete(converter.getPersistentUser(tokenUserDto));
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }
}
