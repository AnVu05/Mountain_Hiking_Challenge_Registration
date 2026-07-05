/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dao.FileLoadding;
import Model.Registration;
import Util.CheckInput;
import service.SaveFile;
import dao.MountainFileCSV;
import dao.RegistrationFileDAT;
import info_program.About;
import info_program.UserGuide;
import view.View;
import java.util.ArrayList;
import java.util.Scanner;
import service.RegistrationService;
import user.FunctionOfUser;
import user.Login;
import user.User;
import user.UserTXT;



/**
 *
 * @author AN
 */
public class RegistrationController {
    CheckInput checkInput = new CheckInput();
    View view = new View();
    RegistrationFileDAT registration = new RegistrationFileDAT();
    MountainFileCSV mountain = new MountainFileCSV();
    FileLoadding loadFile = new FileLoadding();
    RegistrationService registrationService = new RegistrationService(); 
    About about = new About();
    CheckInput input = new CheckInput();
    UserGuide help = new UserGuide();
    public void start(){    
        about.About_me();
        Login login = new Login();
        login.loadDataUser();
        int roleCurrUser = login.login();
        if(roleCurrUser == 0){
            System.out.println("Password entered incorrectly more than 3 times. Exiting the application!");
            return;
        }else if(roleCurrUser == -1){
            return;
        }else{           
            loadFile.loaddingFile();
            int user = roleCurrUser;
            help(roleCurrUser);
            switch (user) {
                case 1:
                    controllerOfAdimin(roleCurrUser);
                    break;
                case 2:                  
                    controllerOfManager(roleCurrUser);
                    break;
                case 3:                    
                    controllerOfStaff(roleCurrUser);
                    break;
                case 4:
                    controllerOfTempUser(roleCurrUser);
                    break;
            } 
        }                      
    }
    
    public void controllerOfAdimin(int roleCurrUser ){  
        while(true){
            view.displayMenuOfAdmin();
            int yourChoice = view.yourChoice();
            switch (yourChoice) {
                case 1:   
                    NewRegistration();
                    break;
                case 2:
                    UpdateRegistrationInformation();
                    break;
                case 3:
                    DisplayRegisteredList();
                    break;
                case 4:
                    DeleteRegistrationInformation();
                    break;
                case 5:
                    SearchParticipantsbyName();
                    break;
                case 6:
                    FilterDatabyCampus();
                    break;
                case 7:
                    StatisticsofRegistrationNumbersbyLocation();
                    break;
                case 8:
                    SaveDatatoFile();
                    break;
                case 9:
                    FunctionOfUser f = new FunctionOfUser();
                    f.UserAuthorization();
                    break;
                case 10:
                    ExitTheProgram();
                    System.exit(0);
                    break;
            }
        }           
    }
    
    public void controllerOfStaff(int roleCurrUser ){
        FunctionOfUser f = new FunctionOfUser();
        UserTXT user = new UserTXT();
        while(true){
            view.displayOfStaff();
            int yourChoice = checkInput.getInteger("Enter your choice: ", "Must be integer number", 1, 3);
            switch (yourChoice) {
                case 1:
                    NewRegistration();
                    break;
                case 2:
                    f.changePassword();
                    user.save();
                    break;
                case 3:
                    ExitsProgramWithAutoSave();
                    System.exit(0);
                    break;
            }
        }      
    }
    
    public void controllerOfManager(int roleCurrUser ){  
        while(true){
            view.displayMenuOfManager();
            int yourChoice = checkInput.getInteger("Enter your choice: ", "Must be integer number", 1, 3);
            switch (yourChoice) {
                case 1:
                    UpdateRegistrationInformation();
                    break;
                case 2:
                    DeleteRegistrationInformation();
                    break;
                case 3:
                    ExitsProgramWithAutoSave();
                    System.exit(0);
                    break;
            }
        }
    }
    
    public void controllerOfTempUser(int roleCurrUser ){       
        view.displayMenuOfTempUser();             
        while(true){
            int yourChoice = checkInput.getInteger("Enter your choice: ", "Must be integer number", 1, 2);
            switch (yourChoice) {
                case 1:
                    DisplayRegisteredList();
                    break;
                case 2:
                    ExitsProgramWithAutoSave();
                    System.exit(0);
                    break;
            }
        }
        
    }
    
    public void NewRegistration() {
        System.out.println("========New Registration========");
        Registration registration = new Registration();
        try {
            registrationService.add(registration);
        } catch (Exception e) {
        }      
    }

    public void UpdateRegistrationInformation() {
        System.out.println("=========Update Registration Information=========");
        Scanner sc = new Scanner(System.in);
        String studentID = checkInput.getString("Enter Student ID you want update information(SE/HE/DE/QE/CE + 6 digits): ", "Must be follow format!",checkInput.REGEX_STUDENTID);
        registrationService.update(studentID);
    }

    public void DisplayRegisteredList() {
        registrationService.displayList();
    }

    public void DeleteRegistrationInformation() {
        System.out.println("=========Delete Registration=========");
        String studentID = checkInput.getString("Enter Student ID you want delete(SE/HE/DE/QE/CE + 6 digits): ", "Must be follow format!",checkInput.REGEX_STUDENTID);
        registrationService.delete(studentID);
        
    }

    public void SearchParticipantsbyName() {
        System.out.println("=========Search participants by Name=========");
        String name = checkInput.getString("Enter name of student you want to find: ", "Must be follow format!",checkInput.REGEX_NAME).toLowerCase().trim();
        registrationService.searchByName(name);
    }

    public void FilterDatabyCampus() {
        System.out.println("=========Filter data by Campus=========");
        System.out.println
        ("CE: Can Tho\n" +
         "DE: Da Nang\n" +
         "HE: Ha Noi\n" +
         "SE: Ho Chi Minh\n" +
         "QE: Quy Nhon");
        ArrayList<Registration> temp = new ArrayList<>();
        String campusCode = checkInput.getString("Enter the campus code you want to filter (CE|DE|HE|SE|QE): ","This campus code not exits",checkInput.REGEX_CAMPUSCODE);
        registrationService.filter(temp, campusCode);
    }

    public void StatisticsofRegistrationNumbersbyLocation() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-20s| %-25s| %-20s\n","Peak Name","Number of Participants","Total Cost");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        registrationService.statistic();
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }
    
    private boolean wasSave = false;
    public void SaveDatatoFile() {
        SaveFile save = new SaveFile();
        save.saveFile();
        wasSave = true;
    }
    
    public void ExitTheProgram() {
        String yesOrNo = null;
        if(!(wasSave)){
            yesOrNo = checkInput.getString
                ("Do you want to save the changes before exiting? (Y/N): ",
                        "Just Y or N",checkInput.REGEX_YESORNO).toLowerCase();
            if(yesOrNo.matches("y")){
                SaveDatatoFile();
            }else{
                yesOrNo = checkInput.getString
                ("You have unsaved changes. Are you sure you want to exit without saving? (Y/N): ",
                        "Just Y or N",checkInput.REGEX_YESORNO).toLowerCase();
                if(!(yesOrNo.matches("y"))){
                    ExitTheProgram();
                }
            }
        }
    }
    
    public void ExitsProgramWithAutoSave(){
        SaveDatatoFile();
    }
    public void help(int roleCurrUser){
        String yesOrNo = input.getString("Is this your first time using the program(Y/N): ","Just y or n",input.REGEX_YESORNO).toLowerCase();
        switch (yesOrNo) {
            case "y":
                help.help(roleCurrUser);
                break;
            case "n":
                System.out.println("You can work now!");
                break;
        }
    }
}
