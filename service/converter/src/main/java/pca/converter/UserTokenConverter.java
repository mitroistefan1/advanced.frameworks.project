package pca.converter;


import pca.persistence.model.UserToken;
import pca.service.data.UserTokenData;

public class UserTokenConverter implements Converter<UserToken, UserTokenData> {

  public UserTokenData convertToData(UserToken model) {

    UserTokenData returnUserDto = new UserTokenData();

    returnUserDto.setUserName(model.getUserName());
    returnUserDto.setSeries(model.getSeries());
    returnUserDto.setToken(model.getToken());
    returnUserDto.setDate(model.getDate());
    return returnUserDto;
  }

  public UserToken convertToModel(UserTokenData data) {

    UserToken userToken = new UserToken();

    userToken.setUserName(data.getUserName());
    userToken.setSeries(data.getSeries());
    userToken.setToken(data.getToken());
    userToken.setDate(data.getDate());
    return userToken;
  }
}
