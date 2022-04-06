package de.dhbw.t2inf3001.pe.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.Formatter.Formatter;

public class StudentSelectedMenu implements IMenu{

  private Student student;

  public StudentSelectedMenu(Student student){
    this.student = student;
  }

  @Override
  public String getMenuString() {
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
            ps.println("Successfully selected " + Formatter.formatInfo(newStudent));
            Menu.setMenu(new StudentSelectedMenu(newStudent));
            break;
        case 2:
            ps.println(Formatter.formatInfo(student));
            break;
        case 3:
            ps.println(Formatter.formatAddress(student.address()));
            break;
        case 4:
            ps.println(Formatter.formatPhoneNumber(student.phone()));
            break;
        case 5:
            ps.println(Formatter.formatPhoneNumberInternational(student.phone()));
            break;
        case 7:
            Menu.setMenu(new NoLanguageSelectedMenu());
            break;
        case 8:
            System.exit(0);
            break;
        default:
            ps.println(Menu.INVALID_INPUT);
            break;
		}
  }
  
}
