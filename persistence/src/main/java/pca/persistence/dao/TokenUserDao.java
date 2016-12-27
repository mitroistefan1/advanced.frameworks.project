package pca.persistence.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pca.persistence.model.TokenUser;

@Repository
public interface TokenUserDao extends CrudRepository<TokenUser,String>{
    public TokenUser save(TokenUser tokenUser);
    public TokenUser findBySeries(String series);
    public TokenUser findByUserName(String userName);
    public void delete(TokenUser tokenUser);
}
