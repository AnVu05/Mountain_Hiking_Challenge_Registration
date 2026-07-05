/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Model.Registration;
import Model.RegistrationModel;
import Util.CheckInput;
import java.util.ArrayList;
import view.View;

/**
 *
 * @author AN
 */
public class RegistrationService {
    CheckInput checkInput = new CheckInput();
    View view = new View();
    public void add(Registration registration) {
        try {
            RegistrationModel.registrationList.add(registration);
            System.out.println("Add successfully");
        } catch (Exception e) {
            System.out.println("Add not successfully!");
        }
    }

    public void update(String studentID) {
        boolean find = false;
        System.out.println("You can update new infromation:");
        for(Registration x : RegistrationModel.registrationList){
            if(studentID.matches(x.getStudentID())){
                x.setName();
                x.setEmail();
                x.setPhoneNumber();
                x.setMountainCode();
                x.setTuitionFee();
                find = true;
                System.out.println("Update successfully!");
                break;
            }
        }
        if(!(find)){
            System.out.println("This student has not registered yet!");
        }
    }

    public void displayList() {
        if(RegistrationModel.registrationList.isEmpty()){
            System.out.println("No students have registered yet!");
        }else{
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.format
            ("%-20s| %-20s | %-20s | %-20s | %s",
             "StudentID","Name","Phone Number","Mountain Code","Tuition Fee\n"
            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            for(Registration x : RegistrationModel.registrationList){
                System.out.println(x.toStringDisplay());
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
        }
    }

    public void delete(String studentID) {
        String yesOrNo = null;       
        boolean find = false;
        for(Registration x : RegistrationModel.registrationList){
            if(studentID.matches(x.getStudentID())){
                view.displayDelete(studentID);
                yesOrNo = checkInput.getString
                ("Are you sure you want to delete this registration? (Y/N): ",
                        "Just Y or N",checkInput.REGEX_YESORNO).toLowerCase();
                if(yesOrNo.matches("y")){
                    RegistrationModel.registrationList.remove(x);
                    System.out.println("The registration has been successfully deleted.");
                }
                find = true;               
                break;
            }
        }
        if(!(find)){
            System.out.println("This student has not registered yet!");
        }
    }

    public void searchByName(String name) {
        boolean find = false;
        ArrayList<Registration> temp = new ArrayList<>();
        for(Registration x : RegistrationModel.registrationList){
            if(name.matches(x.getName().toLowerCase().trim())){
                temp.add(x);
                find = true;
            }
        }
        if(find){
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.format
            ("%-20s| %-20s | %-20s | %-20s | %s",
             "StudentID","Name","Phone Number","Mountain Code","Tuition Fee\n"
            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            for(Registration x : temp){
                System.out.println(x.toStringDisplay());
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
        }else{
            System.out.println("No one matches the search criteria!");
        }
    }

    public void filter(ArrayList<Registration> temp, String campusCode) {
        boolean find = false;
        for(Registration x : RegistrationModel.registrationList){
            if(x.getStudentID().contains(campusCode)){
                temp.add(x);
                find = true;
            }
        }
        if(find){
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.format
            ("%-20s| %-20s | %-20s | %-20s | %s",
             "StudentID","Name","Phone Number","Mountain Code","Tuition Fee\n"
            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            for(Registration x : temp){
                System.out.println(x.toStringDisplay());
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
        }else{
            System.out.println("No students have registered under this campus!");
        }
    }

    public void statistic() {
        for(int x : RegistrationModel.MountainCodeList){
            int temp = x - 1;
            int numOfParts = StatisticNumberOfParticipants(x);
            double totalFee = StatisticTotalCost(x);
            if(numOfParts != 0){
                System.out.format("%-20s| %-25d| %-20.0f\n",RegistrationModel.MountainName.get(temp),numOfParts,totalFee);
            }
        }
    }
    private int StatisticNumberOfParticipants(int mountainCode){
        int numberOfParticipants = 0;
        for(Registration x : RegistrationModel.registrationList){
            if(x.getMountainCode() == mountainCode){
                numberOfParticipants++;
            }
        }
        return numberOfParticipants;
    }
    private double StatisticTotalCost(int mountainCode){
        double totalCost = 0;
        for(Registration x : RegistrationModel.registrationList){
            if(x.getMountainCode()== mountainCode){
                totalCost += x.getTuitionFee();
            }
        }
        return totalCost;
    }
    
    
    
}
