/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import Model.Registration;
import Model.RegistrationModel;
import static Model.RegistrationModel.MountainCodeList;
import static Model.RegistrationModel.MountainName;
import static Model.RegistrationModel.registrationList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AN
 */
public class UserTXT implements UserDAO{
    public static HashMap<String,String> User = new HashMap<>();
    public static ArrayList<User> ListUser = new ArrayList<>();
    private static String locationSave = "src/Data/";
    private static String fileName = "User.txt";
    @Override
    public void load() {
        //xoa list cu
        User.clear();
        String linkFile = locationSave + fileName;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(linkFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String [] parts = line.split("[,]+");
                User.put(parts[1], parts[2]);
                User newUser = new User(Integer.parseInt(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),parts[4]);
                ListUser.add(newUser);
            }
            System.out.println("Loading File User Success!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }

    @Override
    public void create() {
        String linkFile = locationSave + fileName;
        File file = new File(linkFile);
        if(!(file.exists())){
            try {
                file.createNewFile();
                System.out.println("Create file success!");
            } catch (IOException ex) {
                System.out.println("Create file not success!");
            }
        }
    }

    @Override
    public void save() {
        String linkFile = locationSave + fileName;
        File file = new File(linkFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(User x : ListUser){
                bufferedWriter.write(x.toString());
                bufferedWriter.newLine();
            }
            System.out.println("User data has been successfully saved to `User.txt`!");
        } catch (IOException ex) {
            System.out.println("Save File Not Success!");
        }finally{
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     
}
