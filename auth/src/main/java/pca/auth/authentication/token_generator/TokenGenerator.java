package pca.auth.authentication.token_generator;


public interface TokenGenerator {

  String generateToken(String userName);
}
