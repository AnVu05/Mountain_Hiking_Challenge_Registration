/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;


import Controller.RegistrationController;
import Util.CheckInput;
import java.util.Scanner;
import view.View;

/**
 *
 * @author AN
 */
public class FunctionOfUser {
    public void changePassword(){
        Scanner sc = new Scanner(System.in);
        View display = new View();
        CheckInput input = new CheckInput();       
        while(true){
            System.out.print("Enter user name you want to change password: ");
            String userName = sc.nextLine();
            User temp = temp(userName);
            if(temp != null){
                display.displayUserInfo(temp);
                System.out.println("\n");
                String yesOrNo = input.getString("Do you want change password(Y/N): ", "Must be y or n", input.REGEX_YESORNO);
                if (yesOrNo.equalsIgnoreCase("y")) {
                    System.out.print("Enter new password: ");
                    String newPassword = sc.nextLine();
                    temp.setPassword(newPassword);
                    System.out.println("Change password suceefully!");
                    return;
                } else {
                    System.out.println("The password change request has been canceled");
                    return;
                }
            }else{
                System.out.println("User name does not exits!");
            }
        }    
    }
    
    public User temp(String userName){
        User temp = new User();
        for(User x : UserTXT.ListUser){
            if(x.getUserName().equals(userName)){
                temp = x;
                break;
            }
        }
        return temp;
    }
    public void UserAuthorization() {
        View display = new View();
        CheckInput input = new CheckInput();
        UserTXT user = new UserTXT();
        
        RegistrationController cr = new RegistrationController();
        while(true){
            display.displayMenuUserAuthorization();
            int yourChoice = input.getInteger("Enter your choice: ", "Must be integer number", 1, 5);
            switch (yourChoice) {
                case 1:
                    newUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    displayUser();
                    break;
                case 5:
                    System.out.println("Auto save data User!");
                    user.save();
                    cr.controllerOfAdimin(1);
                    break;
            }
        }       
    }

    private void newUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entern new user name: ");
        String userName = sc.nextLine();
        System.out.print("Enter new user password: ");
        String userPassword = sc.nextLine();
        System.out.print("Enter new user role: ");
        int userRole = 0;
        try {
            userRole = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error");
        }
        try {
            UserTXT.ListUser.add(new User(userName, userPassword, userRole));
            System.out.println("Add new user sucessfully!");
        } catch (Exception e) {
            System.out.println("Error");
        }     
    }

    private void deleteUser() {
        Scanner sc = new Scanner(System.in);
        View display = new View();
        CheckInput input = new CheckInput();
        System.out.print("Entern new user name: ");
        String userName = sc.nextLine();
        for(User x : UserTXT.ListUser){
            if(userName.equalsIgnoreCase(x.getUserName())){
                display.displayUserInfo(x);
                System.out.println("\n");
                String yesOrNo = input.getString("Do you want delete this user(Y/N): ","Just be y or n", input.REGEX_YESORNO);
                if(yesOrNo.equalsIgnoreCase("y")){
                    UserTXT.ListUser.remove(x);
                    System.out.println("Deleted successfully!");
                    break;
                }else{
                    System.out.println("The delete request has been canceled!");
                }             
            }
        }
    }

    private void updateUser() {
        Scanner sc = new Scanner(System.in);
        View display = new View();
        System.out.print("Entern new user name: ");
        String userName = sc.nextLine();
        for(User x : UserTXT.ListUser){
            if(userName.equalsIgnoreCase(x.getUserName())){
                display.displayUserInfo(x);
                System.out.println("Leave it empty to skip.");
                System.out.print("Enter new password: ");
                String newPassword = sc.nextLine();
                if(!newPassword.isEmpty()){
                    x.setPassword(newPassword);
                }
                System.out.print("Enter new role: ");
                String role = null;
                int newRole = 0;
                try {
                    role = sc.nextLine();
                    if(!role.isEmpty()){
                        newRole = Integer.parseInt(role);
                        x.setRole(newRole);
                        x.setRoleDettail(newRole);
                    } 
                    System.out.println("Update succsefully!");
                } catch (Exception e) {
                    System.out.println("Error");
                }
                break;
            }
        }
    }

    private void displayUser() {
        System.out.println("-----------------------------------------------------");
        System.out.format("%-5s|%-10s|%-10s|%-5s|%s\n","No.","UserID","Password","Role","Role Detail");
        System.out.println("-----------------------------------------------------");
        for(User x : UserTXT.ListUser){
            System.out.println(x.display());
        }
        System.out.println("-----------------------------------------------------");
    }
}
