package pca.service.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.persistence.dao.PersistentUserDao;
import pca.persistence.dao.UserDao;
import pca.persistence.dto.PersistentUserDto;
import pca.persistence.dto.UserDto;

@Service
public class AuthenticationService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PersistentUserDao persistentUserDao;

    private Converter converter;

    public UserDto getUser(String userName) {
        return converter.getUserDto(userDao.findByUserName(userName));
    }

    public void savePersistentUser(PersistentUserDto persistentUserDto) {
        persistentUserDao.save(converter.getPersistentUser(persistentUserDto));
    }

    public PersistentUserDto getPersistentUserBySeries(String series) {
        return converter.getPersistentUserDto(persistentUserDao.findBySeries(series));
    }

    public void updatePersistentUser(PersistentUserDto persistentUserDto) {
        persistentUserDao.save(converter.getPersistentUser(persistentUserDto));
    }

    public PersistentUserDto getPersistentUserByUserName(String userName) {
        return converter.getPersistentUserDto(persistentUserDao.findByUserName(userName));
    }

    public void deletPersistentUser(PersistentUserDto persistentUserDto) {
        persistentUserDao.delete(converter.getPersistentUser(persistentUserDto));
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }
}
