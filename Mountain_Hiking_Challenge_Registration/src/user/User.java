/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author AN
 */
public class User {
    private int userID; 
    private String userName;
    private String password;
    private int role;
    private String roleDettail;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    
    public User(String userName, String password, int role) {
        setUserID();
        this.userName = userName;
        this.password = password;
        this.role = role;
        setRoleDettail(role);
    }

    public User(int userID, String userName, String password, int role, String roleDettail) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.roleDettail = roleDettail;
    }

    
    //Getter
    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public String getRoleDettail() {
        return roleDettail;
    }
    
    //Setter
    public void setUserID() {
        this.userID = UserTXT.ListUser.size() + 1;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setRoleDettail(int role) {
        switch (role) {
            case 1:
                this.roleDettail = "Admin";
                break;
            case 2:
                this.roleDettail = "Manager";
                break;
            case 3:
                this.roleDettail = "Staff";
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%d,%s",getUserID(),getUserName(),getPassword(),getRole(),getRoleDettail());
    }
    
    public String display(){
        return String.format("%-5d|%-10s|%-10s|%-5d|%s",getUserID(),getUserName(),getPassword(),getRole(),getRoleDettail());
    }
}
