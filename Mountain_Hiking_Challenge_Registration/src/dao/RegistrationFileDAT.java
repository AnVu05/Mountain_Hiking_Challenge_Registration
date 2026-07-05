/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Registration;
import Model.RegistrationModel;
import static Model.RegistrationModel.registrationList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AN
 */
public class RegistrationFileDAT implements RegistrationDAO{
    private static String locationSave = "src/Data/";
    private static String fileName = "registrations.dat";
    private static String linkFile = locationSave + fileName;
    @Override
    public void loadAll() {
        //xoa list cu
        registrationList.clear();
        String linkFile = locationSave + fileName;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(linkFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String [] parts = line.split("[,]+");
                if(parts.length == 6){
                    Registration registration = new Registration
                    (
                            parts[0],//ID
                            parts[1],//Name
                            parts[2],//Phone
                            parts[3],//Email
                            Integer.parseInt(parts[4]),//MountainCode
                            Double.parseDouble(parts[5])// Fee
                    );
                    registrationList.add(registration);
                }                
            }
            System.out.println("Loading File Registrations Success!");
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
    public void saveAll() {
        String linkFile = locationSave + fileName;
        File file = new File(linkFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(Registration x : registrationList){
                bufferedWriter.write(x.toStringSaveFile());
                bufferedWriter.newLine();
            }
            System.out.println("Registration data has been successfully saved to `registrations.dat`!");
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

    @Override
    public void create() {
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
    
}
