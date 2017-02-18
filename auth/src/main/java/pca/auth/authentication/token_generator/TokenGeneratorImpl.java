package pca.auth.authentication.token_generator;


import java.util.UUID;

public class TokenGeneratorImpl implements TokenGenerator {

  public String generateToken(String userName) {

    String token;

    UUID uuid = UUID.randomUUID();
    token = uuid.toString();
    return token;
  }
}
