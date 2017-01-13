package pca.service.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.persistence.dao.UserTokenDao;
import pca.persistence.dao.UserDao;
import pca.persistence.dto.UserTokenDto;
import pca.persistence.dto.UserDto;
import pca.service.Converter;

@Service
public class AuthenticationService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserTokenDao userTokenDao;

    private Converter converter;

    public UserDto getUser(String userName) {
        return converter.getUserDto(userDao.findByUserName(userName));
    }

    public void creatUser(UserDto userDto) {
        userDao.save(converter.getUser(userDto));
    }

    public void saveUserToken(UserTokenDto userTokenDto) {
        userTokenDao.save(converter.getUserToken(userTokenDto));
    }

    public UserTokenDto getUserTokenBySeries(String series) {
        return converter.getUserTokenDto(userTokenDao.findBySeries(series));
    }

    public void updateUserToken(UserTokenDto userTokenDto) {
        userTokenDao.save(converter.getUserToken(userTokenDto));
    }

    public UserTokenDto getUserTokenByUserName(String userName) {
        return converter.getUserTokenDto(userTokenDao.findByUserName(userName));
    }

    public void deletUserToken(UserTokenDto userTokenDto) {
        userTokenDao.delete(converter.getUserToken(userTokenDto));
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }
}
