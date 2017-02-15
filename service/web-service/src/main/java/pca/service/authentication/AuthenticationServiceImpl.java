package pca.service.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.converter.UserConverter;
import pca.converter.UserTokenConverter;
import pca.persistence.dao.UserTokenRepository;
import pca.persistence.dao.UserRepository;
import pca.service.data.UserTokenData;
import pca.service.data.UserData;


@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTokenRepository userTokenRepository;

    private UserConverter userConverter;
    private UserTokenConverter userTokenConverter;


    public UserData getUser(String userName) {
        return userConverter.convertToData(userRepository.findByUserName(userName));
    }

    public void creatUser(UserData userData) {
        userRepository.save(userConverter.convertToModel(userData));
    }

    public void saveUserToken(UserTokenData userTokenData) {
        userTokenRepository.save(userTokenConverter.convertToModel(userTokenData));
    }

    public UserTokenData getUserTokenBySeries(String series) {
        return userTokenConverter.convertToData(userTokenRepository.findBySeries(series));
    }

    public void updateUserToken(UserTokenData userTokenData) {
        userTokenRepository.save(userTokenConverter.convertToModel(userTokenData));
    }

    public UserTokenData getUserTokenByUserName(String userName) {
        return userTokenConverter.convertToData(userTokenRepository.findByUserName(userName));
    }

    public void deletUserToken(UserTokenData userTokenData) {
        userTokenRepository.delete(userTokenConverter.convertToModel(userTokenData));
    }

    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public void setUserTokenConverter(UserTokenConverter userTokenConverter) {
        this.userTokenConverter = userTokenConverter;
    }
}
