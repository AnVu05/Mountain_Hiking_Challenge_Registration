package info_program;

import Controller.RegistrationController;
import Util.CheckInput;
import view.View;

public class UserGuide {

    public void guideNewRegistration() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║                HOW TO ADD A NEW REGISTRATION             ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. Select '1. New Registration' from the main menu.      ║");
        System.out.println("║ 2. Enter the required details:                           ║");
        System.out.println("║    - Student ID (Campus code + 6 digits, unique)         ║");
        System.out.println("║    - Name (2–20 characters)                              ║");
        System.out.println("║    - Phone Number (10 digits, valid network)             ║");
        System.out.println("║    - Email (standard format)                             ║");
        System.out.println("║    - Mountain Code (from list)                           ║");
        System.out.println("║ 3. Tuition fee is 6,000,000 VND. Viettel/VNPT get 35% off║");
        System.out.println("║ 4. Confirm to save. Return to main menu.                 ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    public void guideUpdateRegistration() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║               HOW TO UPDATE REGISTRATION INFO            ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. Choose '2. Update Registration' in the menu.          ║");
        System.out.println("║ 2. Enter existing Student ID.                            ║");
        System.out.println("║ 3. Update desired fields (Name, Phone, Email, Mountain). ║");
        System.out.println("║ 4. Old info will be kept if left blank.                  ║");
        System.out.println("║ 5. Confirm changes to save.                              ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    public void guideDisplayList() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║                 HOW TO DISPLAY STUDENTS                  ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. Choose '3. Display Registered List'.                  ║");
        System.out.println("║ 2. Program shows all students or message if empty.       ║");
        System.out.println("║ 3. Info includes ID, Name, Phone, Mountain, and Fee.     ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    public void guideDeleteRegistration() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║                HOW TO DELETE REGISTRATION                ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. Choose '4. Delete Registration' from the menu.        ║");
        System.out.println("║ 2. Enter Student ID. Display student info for confirm.   ║");
        System.out.println("║ 3. Press 'Y' to delete, 'N' to cancel.                   ║");
        System.out.println("║ 4. Message will confirm successful deletion.             ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    public void guideSearchByName() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║                  HOW TO SEARCH BY NAME                   ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. Choose '5. Search Participants by Name'.              ║");
        System.out.println("║ 2. Enter full or partial name.                           ║");
        System.out.println("║ 3. Matching students will be displayed.                  ║");
        System.out.println("║ 4. If no match found, a message will appear.             ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    public void guideFilterByCampus() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║                 HOW TO FILTER BY CAMPUS                  ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. Choose '6. Filter Data by Campus'.                    ║");
        System.out.println("║ 2. Enter campus code (CE, DE, HE, SE, QE).               ║");
        System.out.println("║ 3. Program shows all students in that campus.            ║");
        System.out.println("║ 4. If no students found, it will notify you.             ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    public void guideStatistics() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║            HOW TO VIEW REGISTRATION STATISTICS           ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. Choose '7. Statistics by Location'.                   ║");
        System.out.println("║ 2. System calculates:                                    ║");
        System.out.println("║    - Number of participants per mountain                 ║");
        System.out.println("║    - Total tuition collected                             ║");
        System.out.println("║ 3. Only peaks with participants will appear.             ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    public void guideSaveData() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║               HOW TO SAVE REGISTRATION DATA              ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. Choose '8. Save Data to File'.                        ║");
        System.out.println("║ 2. Program serializes all data into a binary file.       ║");
        System.out.println("║ 3. File name: registrations.dat                          ║");
        System.out.println("║ 4. Confirmation message will be shown.                   ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    public void guideExitProgram() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║                   HOW TO EXIT PROGRAM                    ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1. Choose '9. Exit Program'.                             ║");
        System.out.println("║ 2. If unsaved changes exist:                             ║");
        System.out.println("║    - You’ll be asked to save before exit.                ║");
        System.out.println("║ 3. Confirm with 'Y' or 'N'.                              ║");
        System.out.println("║ 4. Program ends safely.                                  ║");
        System.out.println("╚══════════════════════════════════╝");
    }
    
    public void help(int roleCurrUser){
        CheckInput input = new CheckInput();
        RegistrationController cr = new RegistrationController();
        View display = new View();
        while(true){
            display.displayHelpMenu();
            int choice = input.getInteger("Enter your choice (0-9): ", "Must be integer number!", 0, 9);
            switch (choice) {
                case 1:
                    guideNewRegistration();
                    break;
                case 2:
                    guideUpdateRegistration();
                    break;
                case 3:
                    guideDisplayList();
                    break;
                case 4:
                    guideDeleteRegistration();
                    break;
                case 5:
                    guideSearchByName();
                    break;
                case 6:
                    guideFilterByCampus();
                    break;
                case 7:
                    guideStatistics();
                    break;
                case 8:
                    guideSaveData();
                    break;
                case 9:
                    guideExitProgram();
                    break;
                case 0:
                    System.out.println("Exiting help menu... Returning to main program.");
                    switch (roleCurrUser) {
                        case 1:
                            cr.controllerOfAdimin(roleCurrUser);
                            break;
                        case 2:
                            cr.controllerOfManager(roleCurrUser);
                            break;
                        case 3:
                            cr.controllerOfStaff(roleCurrUser);
                            break;
                        case 4:
                            cr.controllerOfTempUser(roleCurrUser);
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid option! Please choose from 0 to 9.");
            }
        }     
    }
}
