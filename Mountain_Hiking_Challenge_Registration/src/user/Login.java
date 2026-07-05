/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import Util.CheckInput;
import java.util.Scanner;

/**
 *
 * @author AN
 */
public class Login {
    
    public void loadDataUser(){
        UserTXT userTXT = new UserTXT();
        userTXT.create();
        userTXT.load();
    }
    
    public int login(){
        CheckInput input = new CheckInput();
        Scanner sc = new Scanner(System.in);
        System.out.println("+-------------------------------------------------------+\n" +
                            "|                       Login User                     |\n" +
                            "+-------------------------------------------------------+\n"+
                            "| 1.Login                                               |\n"+
                            "| 2.Eixt                                                |\n"+
                            "+-------------------------------------------------------+\n"
                            );
        int choise = input.getInteger("Enter your choise: ","Must be integer number!", 1, 2);
        int result = -1;
        switch (choise) {
            case 1:
                String userName = null;
                String password = null;
                int count = 0;
                while (true) {
                    System.out.print("Enter User name: ");
                    userName = sc.nextLine();
                    System.out.print("Enter Password: ");
                    password = sc.nextLine();
                    if (UserTXT.User.containsKey(userName)) {
                        if (password.equals(UserTXT.User.get(userName))) {
                            User currUser = new User(userName, password);
                            for (User x : UserTXT.ListUser) {
                                if (x.getUserName().equalsIgnoreCase(currUser.getUserName())) {
                                    result = x.getRole();
                                    break;
                                }
                            }
                            break;
                        }else{
                            count++;
                            System.out.println("Worng password!");
                            if (count == 3) {
                                result = 0;
                                break;
                            }
                        }
                    } else {
                        System.out.println("User name not eixt.");
                        String yesOrNo = input.getString("Do you want use program without account? "
                                + "This user just have function display all Registration(Y/N): ", "Just y or n", input.REGEX_YESORNO);
                        if (yesOrNo.equalsIgnoreCase("y")) {
                            result = 4;
                            break;
                        }
                    }
                }
                break;
            case 2:               
                break;           
        }
        return result;
    }
}
