/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Util.CheckInput;
import dao.FileLoadding;
import dao.MountainFileCSV;
import dao.MountainFileTXT;
import dao.RegistrationFileDAT;
import dao.RegistrationFileTXT;
import java.io.File;
import java.io.IOException;
import view.View;

/**
 *
 * @author AN
 */
public class SaveFile {
    //kiem tra file co ton tai chua
    public static String folderSaveData = "src/Data";
    private static String locationSave = "src/Data/";
    private static String fileName = null;
    public void FileName(){
        CheckInput input = new CheckInput();
        fileName = input.getString
        (
         "Enter name file you want to save: ",
         "Must be follow format(name File.Type File)", 
         input.REGEX_NAMEFILE
        );
    }
    // kiem tra trong data co bao nhieu file
    public int listFileEixts(){
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
    public void choiseFileForWork(){
        RegistrationFileDAT rDAT = new RegistrationFileDAT();
        rDAT.saveAll();
    }
    public void saveFile() {
        choiseFileForWork();
    }
    
}
