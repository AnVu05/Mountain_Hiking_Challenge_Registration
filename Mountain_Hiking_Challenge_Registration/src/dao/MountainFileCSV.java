/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.RegistrationModel;
import static Model.RegistrationModel.MountainCodeList;
import static Model.RegistrationModel.MountainName;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AN
 */
public class MountainFileCSV implements MountainDAO{
    private static String locationSave = "src/Data/";
    private static String fileName = "MountainList.csv";
    @Override
    public void loadAll() {
        //xoa list cu
        MountainCodeList.clear();
        String linkFile = locationSave + fileName;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(linkFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String [] parts = line.split("[,]+");
                MountainCodeList.add(Integer.parseInt(parts[0]));
                MountainName.add(parts[1]);
            }
            System.out.println("Loading File Mountain Code Success!");
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
    
}
