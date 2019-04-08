/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
class User {
    private int sno;
    private String Username, Password;
    public User( int sno, String Username, String Password){
        this.sno=sno;
        this.Username=Username;
        this.Password=Password;
    }
    public int getsno(){
        return sno;
                
    }
   public String getUsername(){
      return Username;
  }
  public String getPassword(){
      return Password;
  }
}
