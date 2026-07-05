/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import Util.CheckInput;
import java.io.File;
import java.io.IOException;
import view.View;


/**
 *
 * @author AN
 */
public class FileLoadding {
    //kiem tra file co ton tai chua
    public static String folderSaveData = "src/Data";
    public void createFile(){
        RegistrationFileDAT rDat = new RegistrationFileDAT();
        int numberOfRegistration = listFileRegistrationEixts();
        if(numberOfRegistration <= 0){
            rDat.create();
            System.out.println("Create file Registration Success!");
        }
    }
    // kiem tra trong data co bao nhieu file
    public int listFileMountainEixts(){
        int count = 0;
        File folder = new File(folderSaveData);
        File [] files = folder.listFiles();
        if (files != null && files.length > 0) {               
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().startsWith("mountainlist")) { 
                    count++;
                }
            }
        }
        return count;
    }
    public int listFileRegistrationEixts(){
        int count = 0;
        File folder = new File(folderSaveData);
        File [] files = folder.listFiles();
        if (files != null && files.length > 0) {               
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().startsWith("registrations")) { 
                    count++;
                }
            }
        }
        return count;
    }
    //chon 2 file de lam viec
    public void choiseFileMountainForWork(){
        MountainFileCSV mCSV = new MountainFileCSV();
        mCSV.loadAll();
    }
    
    public void choiseFileRegistrationForWork(){
        RegistrationFileDAT rDAT = new RegistrationFileDAT();
        int numberOfListFileRegistrationData = listFileRegistrationEixts();
        if(numberOfListFileRegistrationData > 0){
            rDAT.loadAll();
        }
    }
    
    public void loaddingFile() {
        createFile();
        choiseFileMountainForWork();
        choiseFileRegistrationForWork();
    }
}
