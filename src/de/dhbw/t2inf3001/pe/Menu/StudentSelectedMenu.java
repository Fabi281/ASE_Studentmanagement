package de.dhbw.t2inf3001.pe.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.FormatterManager;

public class StudentSelectedMenu implements IMenu{

    //Menu if language and student has been selected

  private Student student;

  public StudentSelectedMenu(Student student){
    this.student = student;
  }

  @Override
  public String getMenuString() {
    //Displays Menu with following commands
    StringBuilder sb = new StringBuilder();
    sb.append("What will you do?\n");
    sb.append("[1] - Search for student by id\n");
    sb.append("[2] - Display info\n");
    sb.append("[3] - Display address\n");
    sb.append("[4] - Display phone number\n");
    sb.append("[5] - Display int'l phone number\n");
    sb.append("[7] - Change Language\n");
    sb.append("[8] - Exit program\n");
    return sb.toString();
  }

  @Override
  public void parseInput(BufferedReader br, PrintStream ps) throws IOException {
    int action;
    try{
        action = Integer.parseInt(br.readLine());
    } catch (NumberFormatException e){
        ps.println(Menu.INVALID_INPUT);
        return;
    }
    switch (action) {
        case 1:
            //Select and returns a student or error message
            ps.println("Enter ID: ");
            int id;
            try {
                id = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                ps.println(Menu.INVALID_INPUT);;
                break;
            }
            Student newStudent = null;
            try {
                newStudent = new Student(String.valueOf(id));
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                ps.println(Menu.NONEXISTENT_ID);
                break;
            }
            ps.println("Successfully selected " + FormatterManager.formatInfo(newStudent));
            Menu.setMenu(new StudentSelectedMenu(newStudent));
            break;
        case 2:
            //Displays infos about selected student based on the selected language Formatter
            ps.println(FormatterManager.formatInfo(student));
            break;
        case 3:
            //Displays selected students address based on the selected language Formatter
            ps.println(FormatterManager.formatAddress(student.address()));
            break;
        case 4:
            //Displays selected students phone number based on the selected language Formatter
            ps.println(FormatterManager.formatPhoneNumber(student.phone()));
            break;
        case 5:
            //Displays students phone number based on the international Format
            ps.println(FormatterManager.formatPhoneNumberInternational(student.phone()));
            break;
        case 7:
            //Switching Menu State to language Selection
            Menu.setMenu(new NoLanguageSelectedMenu());
            break;
        case 8:
            //Instructs Menu to exit
            Menu.exit();
            break;
        default:
            ps.println(Menu.INVALID_INPUT);
            break;
		}
  }
  
}
