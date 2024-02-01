package gestionefile;

public class User{
  private String username;
  private String password;

  public User(String username, String password){
    this.username=username;
    this.password=password;
  }
  public String getUsername(String username){
    return username;
  }
  public String getPassword(String password){
    return password;
  }
}