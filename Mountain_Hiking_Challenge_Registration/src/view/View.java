/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Model.Registration;
import Model.RegistrationModel;
import Util.CheckInput;
import dao.FileLoadding;
import java.io.File;
import user.User;

/**
 *
 * @author AN
 */
public class View {
    CheckInput checkInput = new CheckInput();
    public int yourChoice(){
        int yourChoise = checkInput.getInteger("Enter your choice: ","Must be integer number", 1, 10);;
        return yourChoise;       
    }
    public void displayMenuOfAdmin(){
        System.out.println("+-------------------------------------------------------+\n" +
                            "|    Mountain Hiking Challenge Registration.           |\n" +
                            "+-------------------------------------------------------+\n" +
                            "| 1. New Registration                                  |\n" +
                            "| 2. Update Registration Information                   |\n" +
                            "| 3. Display Registered List                           |\n" +
                            "| 4. Delete Registration Information                   |\n" +
                            "| 5. Search Participants by Name                       |\n" +
                            "| 6. Filter Data by Campus                             |\n" +
                            "| 7. Statistics of Registration Numbers by Location    |\n" +
                            "| 8. Save Data to File                                 |\n" +
                            "| 9. User Authorization                                |\n"+
                            "| 10. Exit The Program                                 |\n" +
                            "+-------------------------------------------------------+");
    }
    public void displayDelete(String studentID){
        System.out.println("-----------------------------------------------------");
        for(Registration x : RegistrationModel.registrationList){
            if(studentID.matches(x.getStudentID())){
                System.out.print(x.toStringDelete());
                break;
            }
        }
        System.out.println("-----------------------------------------------------");

    }
    public void diaplayMenuLoadMountainFile(){
        int count = 0;
        File folder = new File(FileLoadding.folderSaveData);
        File [] files = folder.listFiles();
        if (files != null && files.length > 0) {               
            System.out.println("The list of Mountain List files that exist in the data folder:");
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().startsWith("mountainlist")) { 
                    count++;
                    System.out.println(count + "." + file.getName());
                }
            }
        }else {
            System.out.println("The data directory is empty!");
        }
    }
    
    public void diaplayMenuLoadRegistrationFile(){
        int count = 0;
        boolean found = false;
        File folder = new File(FileLoadding.folderSaveData);
        File [] files = folder.listFiles();
        if (files != null && files.length > 0) {               
            System.out.println("The list of Registrations files that exist in the data folder:");
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().startsWith("registrations")) { 
                    count++;
                    found = true;
                    System.out.println(count + "." + file.getName());
                }
            }
        }else {
            System.out.println("The data directory is empty!");
        }
    }
    
    public void diaplayMenuSaveFile(){
        boolean find = false;
        int count = 0;
        File folder = new File(FileLoadding.folderSaveData);
        File [] files = folder.listFiles();
        if (files != null && files.length > 0) {               
            System.out.println("The list of files that exist in the data folder:");
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().startsWith("registrations")) {
                    find = true;
                    count++;
                    System.out.println(count + "." + file.getName());
                }
            }
            if(find == false){
                System.out.println("The file registrations does not exist in the data folder!");
            }
        }else {
            System.out.println("The data directory is empty!");
        }
    }
    public void displayCreateFile(){
        System.out.println("1.registration.dat\n2.registration.txt");
    }

    public void displayMenuOfManager() {
        System.out.println("+-------------------------------------------------------+\n" +
                            "|    Mountain Hiking Challenge Registration.           |\n" +
                            "+-------------------------------------------------------+\n" +
                            "| 1. Update Registration Information                   |\n" +
                            "| 2. Delete Registration Information                   |\n" +
                            "| 3. Eixts                                             |\n" +
                            "+-------------------------------------------------------+");
    }

    public void displayOfStaff() {
        System.out.println("+-------------------------------------------------------+\n" +
                            "|    Mountain Hiking Challenge Registration.           |\n" +
                            "+-------------------------------------------------------+\n" +
                            "| 1. New Registration                                  |\n" +
                            "| 2. Change Password of user                           |\n" +
                            "| 3. Eixts                                             |\n" +
                            "+-------------------------------------------------------+");
    }

    public void displayMenuOfTempUser() {
        System.out.println("+-------------------------------------------------------+\n" +
                            "|    Mountain Hiking Challenge Registration.           |\n" +
                            "+-------------------------------------------------------+\n" +
                            "| 1. Display Registered List                           |\n" +
                            "| 2. Eixts                                             |\n" +
                            "+-------------------------------------------------------+");
    }
    
    public void displayUserInfo(User user){
        System.out.println("+----------------------------------------------------------------------+");
        System.out.format("User Name: %s\nPassword: %s\nRole: %s\n",user.getUserName(),user.getPassword(),user.getRoleDettail());
        System.out.println("+----------------------------------------------------------------------+");
    }

    public void displayMenuUserAuthorization() {
        System.out.println("+-------------------------------------------------------+\n" +
                            "|    UserAuthorization.                                |\n" +
                            "+-------------------------------------------------------+\n" +
                            "| 1. New User                                          |\n" +
                            "| 2. Delete User                                       |\n" +
                            "| 3. Update User Role                                  |\n" +
                            "| 4. Display List User                                 |\n" +
                            "| 5. Eixts                                             |\n"+
                            "+-------------------------------------------------------+");
    }
    public void displayHelpMenu(){
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║                 USER GUIDE - MAIN MENU                   ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. How to add a new registration                         ║");
        System.out.println("║ 2. How to update registration information                ║");
        System.out.println("║ 3. How to display registered list                        ║");
        System.out.println("║ 4. How to delete registration                            ║");
        System.out.println("║ 5. How to search participants by name                    ║");
        System.out.println("║ 6. How to filter data by campus                          ║");
        System.out.println("║ 7. How to view registration statistics                   ║");
        System.out.println("║ 8. How to save registration data                         ║");
        System.out.println("║ 9. How to exit the program                               ║");
        System.out.println("║ 0. Exit the help menu                                    ║");
        System.out.println("╚══════════════════════════════════╝");
    }
}
