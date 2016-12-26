package pca.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pca.persistence.model.PersistentUser;

@Repository
public interface PersistentUserDao extends CrudRepository<PersistentUser,String>{
    public PersistentUser save(PersistentUser persistentUser);
    public PersistentUser findBySeries(String series);
    public PersistentUser findByUserName(String userName);
    public void delete(PersistentUser persistentUser);
}
