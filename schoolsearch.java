import java.util.Scanner;
import java.io.IOException; 
import java.io.BufferedReader;
import java.io.InputStreamReader;

class schoolsearch {

    static boolean finishSearch = false;
    public static void main(String[] args) throws IOException  
    {
        

        while (!finishSearch)
        {
            System.out.println("Please input search instruction:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userInput = reader.readLine();
            Scanner in = new Scanner(userInput);
            

            switch (in.next())
            {
                case "Student:":
                    parseInputForStudent(in);
                    break;
                case "S:":
                    parseInputForStudent(in);
                    break;

                case "Teacher:":
                    parseInputForTeacher(in);
                    break;
                case "T:":
                    parseInputForTeacher(in);
                    break;
                
                case "Bus:":
                    parseInputForBus(in);
                    break;
                case "B:":
                    parseInputForBus(in);

                case "Grade:":
                    parseInputForGrade(in);
                    break;
                case "G:":
                    parseInputForGrade(in);
                    break;

                case "Average:":
                    parseInputForAverage(in);
                    break;
                case "A:":
                    parseInputForAverage(in);
                    break;

                case "Info":
                    getInfo();
                    break;
                case "I":
                    getInfo();
                    break;
                
                case "Q":
                    finishProgram();
                    break;
                case "Quit":
                    finishProgram();
                    break;

                default:
                    wrongInputFormat();
                    break;
            }
        }
        

    }

    

    static void parseInputForStudent(Scanner in)
    {
        String lastName = "";
        int busNumber;

        if (in.hasNext())
        {
            lastName = in.next();
        }
        else
        {
            wrongInputFormat();
            return;
        }
        
        if (in.hasNextInt()) // has bus input
        {
            busNumber = in.nextInt();
            searchStudent(lastName, busNumber);
        }
        else
        {
            searchStudent(lastName, -1); // no bus input
        }

    }

    static void searchStudent(String lastName, int busNumber)
    {
        if (busNumber == -1) // no bus input
        {
            System.out.println("search student no bus input");
            return;
        }
        else // has bus input
        {
            System.out.println("search student with but input");
            return;
        }
    }

    static void parseInputForTeacher(Scanner in)
    {
        String lastName = "";

        if (in.hasNext())
        {
            lastName = in.next();
            searchTeacher(lastName);
        }
        else
        {
            wrongInputFormat();
            return;
        }
    }

    static void searchTeacher(String lastName)
    {
        System.out.println("search for teacher with " + lastName);
    }

    static void parseInputForBus(Scanner in)
    {
        int busNumber;
        
        if (in.hasNextInt()) // has bus input
        {
            busNumber = in.nextInt();
            searchBus(busNumber);;
        }
        else
        {
            wrongInputFormat();
            return;
        }
    }

    static void searchBus(int busNumber)
    {
        System.out.println("search bus with bus number " + busNumber);
    }

    static void parseInputForGrade(Scanner in)
    {
        int number = 0;
        String mode = "";

        if (in.hasNextInt())
        {
            number = in.nextInt();
        }
        else
        {
            wrongInputFormat();
            return;
        }

        if (in.hasNext())
        {
            mode = in.next();
            if (mode.equals("High") || mode.equals("H"))
            {
                searchGrade(number, "h");
            }
            else if (mode.equals("Low") || mode.equals("L"))
            {
                searchGrade(number, "l");
            }
            else
            {
                wrongInputFormat();
                return;
            }
        }
        else
        {
            searchGrade(number, "na");
        }
    }

    static void searchGrade(int number, String mode)
    {
        if (mode == "h")
        {
            System.out.println("Seach grade with mode High");
        }
        else if (mode == "l")
        {
            System.out.println("Seach grade with mode Low");
        }
        else if (mode == "na")
        {
            System.out.println("Search grade without any mode");
        }
    }

    static void parseInputForAverage(Scanner in)
    {
        int number = 0;
        if (in.hasNextInt())
        {
            number = in.nextInt();
            searchAverage(number);
        }
        else
        {
            wrongInputFormat();
            return;
        }
    }

    static void searchAverage(int number)
    {
        System.out.println("search average with number " + number);
    }

    static void getInfo()
    {
        System.out.println("get info");
    }

    static void finishProgram()
    {
        System.out.println("Goodbye!");
        finishSearch = true;
    }

    static void wrongInputFormat()
    {
        System.out.println("Only these following command formats are supported:");
        System.out.print("S[tudent]: <lastname> [B[us]]\nT[eacher]: <lastname>\nB[us]: <number>\nG[rade]: <number> [H[igh]|L[ow]]\nA[verage]: <number>\nI[nfo]\nQ[uit]\n");
        return;
    }
}