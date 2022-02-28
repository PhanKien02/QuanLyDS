/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlydanhsach;

import java.util.List;
import quanlydanhsach.ConnetionJDBC.UseJDBC;

public class UserService {
    private final UseJDBC useJDBC ;
    public UserService(){
        useJDBC = new UseJDBC();;
    }
    public List<User> getUser(){
        return  useJDBC.getAlLUsers();
    }
    public void addUser(User user){  
         useJDBC.addUser(user);
    }
    public void  Delete(int ID){
        useJDBC.DeleteUser(ID);
    }
}
