/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.CheckInput;

/**
 *
 * @author AN
 */
public class Registration {
    private String studentID;
    private String Name;
    private String phoneNumber;
    private String Email;
    private int MountainCode;
    private double tuitionFee = 6000000;
    CheckInput checkInput = new CheckInput();

    public Registration() {
        setStudentID();
        setName();
        setPhoneNumber();
        setEmail();
        setMountainCode();
        setTuitionFee();
    }   

    public Registration(String studentID, String Name, String phoneNumber, String Email, int MountainCode, double tuitionFee) {
        this.studentID = studentID;
        this.Name = Name;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
        this.MountainCode = MountainCode;
        this.tuitionFee = tuitionFee;
    }
    
    //Getter
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public int getMountainCode() {
        return MountainCode;
    }
    
    public String displayMountainCode(){
        String mountainName = "";
        for(int i = 0; i < RegistrationModel.MountainName.size(); i++){
            if(getMountainCode() == i){
                mountainName = RegistrationModel.MountainName.get(i - 1);
            }
        }
        return String.format("%d: %s",getMountainCode(),mountainName);
    }
    public double getTuitionFee() {
        return tuitionFee;
    }
    
    //Setter
    public void setStudentID() {
        while(true){
            studentID = checkInput.getString
            ("Enter new Student ID (SE/HE/DE/QE/CE + 6 digits): ", 
                "Must be follow format!", checkInput.REGEX_STUDENTID
            );
            if(checkDuplicate(studentID)){   
                System.out.println("This StudentID has eixts!");
            }else{
                break;
            }
        }
        this.studentID = studentID;
    }

    public void setName() {
        while(true){
            Name = checkInput.getString("Enter name: ","Name must be letter!",checkInput.REGEX_NAME);
            String temp = Name.trim();
            if(temp.length() < 2 || temp.length() > 20){
                System.out.println("Name must be 2-20 characters!");
            }else{
                break;
            }
        }
        Name = toTitleCase(Name);
        this.Name = Name;
    }

    public void setPhoneNumber() { 
        while(true){
           phoneNumber = checkInput.getString("Enter Phone Number (10 digits): ","Invalid phone number!",checkInput.REGEX_PHONE); 
           if(isPhoneInVietNam(phoneNumber)){
               this.phoneNumber = phoneNumber;
               break;
           }else{
               System.out.println("This phone number is not registered with any Vietnamese carrier!");
           }          
        }      
    }

    public void setEmail() {
        Email = checkInput.getString("Enter Email: ","Invalid email format!", checkInput.REGEX_EMAIL);
        this.Email = Email;
    }

    public void setMountainCode() {
        boolean done = false;
        System.out.println("Muontain Code");
        for(int i = 0; i < RegistrationModel.MountainName.size(); i++){
            int temp = i;
            System.out.println((temp+1)+". " + RegistrationModel.MountainName.get(i));
        }
        int maxMountianCode = RegistrationModel.MountainCodeList.size();
        MountainCode = checkInput.getInteger("Enter Mountain Code (Choise 1 from 13): ", "Must be integer number!", 1,maxMountianCode);
        for(int i = 0; i < RegistrationModel.MountainName.size(); i++){
            if(MountainCode == i){
                System.out.println("Your choise is " + RegistrationModel.MountainName.get(i - 1)+"!");
            }
        }
        this.MountainCode = MountainCode;
    }

    public void setTuitionFee() {
        if(isViettelOrVNPT(getPhoneNumber())){
            this.tuitionFee = 6000000 * 0.65;
        }
    }
    
    //toString
    public String toStringDisplay() {
        return String.format("%-20s | %-20s | %-20s | %-20s | %.0f"
                ,getStudentID(),getName(),getPhoneNumber(),displayMountainCode(),getTuitionFee());
    }
    public String toStringSaveFile(){
        return String.format("%s,%s,%s,%s,%d,%.0f",getStudentID(),getName(),getPhoneNumber(),getEmail(),getMountainCode(),getTuitionFee());
    }
    public String toStringDelete() {
        return String.format(
            "%-10s: %s\n%-10s: %s\n%-10s: %s\n%-10s: %s\n%-10s: %.0f\n",
            "Student ID", getStudentID(),
            "Name", getName(),
            "Phone", getPhoneNumber(),
            "Mountain", RegistrationModel.MountainName.get(getMountainCode() - 1),
            "Fee", getTuitionFee()
        );
    }
    //phone check
    public boolean isViettelOrVNPT(String phone){
        if(phone.startsWith("086") || phone.startsWith("096") || phone.startsWith("097") // Viettel
                || phone.startsWith("098") || phone.startsWith("032") || phone.startsWith("033")
                || phone.startsWith("034") || phone.startsWith("035") || phone.startsWith("036")
                || phone.startsWith("037") || phone.startsWith("038") || phone.startsWith("039")
                || phone.startsWith("091") || phone.startsWith("094") // Vinaphone (VNPT)
                || phone.startsWith("083") || phone.startsWith("084") || phone.startsWith("085")
                || phone.startsWith("081") || phone.startsWith("082"))
        {
            return true;
        }
        return false;
    }
    public boolean isPhoneInVietNam(String phone){
        String REGEX_PHONE = "^(?:\\+84|0)(?:3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5|8|9]|9[0-4|6-9])\\d{7}$";
        if(phone.matches(REGEX_PHONE)){
            return true;
        }
        return false;
    }
    // check StudentID 
    public boolean checkDuplicate(String StudentID){
        for(Registration x : RegistrationModel.registrationList){
            if(x.getStudentID().matches(StudentID)){
               return true;
            }
        }
        return false;
    }
    //title case
    public String toTitleCase  (String input){
        // dua het ve chu thuong
        input = input.toLowerCase();
        String word [] = input.split(" ");
	StringBuilder output = new StringBuilder();
        for (String x : word){
            char firstChar = x.charAt(0);
            firstChar=Character.toUpperCase(firstChar);
            x = x.replace(x.charAt(0), firstChar);
            output.append(x);
            output.append(" ");
        }
	
        return output.toString().trim();
    }
}
