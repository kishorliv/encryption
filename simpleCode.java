 /* ********************************************************************************************
 * Program04
 * author      : Deepak Neupane
 * course      : cs116
 * section     : 01-TR
 * semester    : winter2016
 *
 * input       : this program accepts 6 user inputs per entry. However, the number of entries 
 *                 of patients can be    multiple.
 *               1. String (Patient Name)
 *               2. int (patient id)
 *				 3. string(gender)
 *               4. double(Exam1)
 *               5. double(Exam2)
 *               6. double(Exam3)				 
 *               input can come from file (ex: input.data) if SubmitJ is being used
 *            
 * processing  : from the values obtained from input data, average of those values is calculated
 *                 and based on that average value the test result is determined.
 *
 * output      : 
 *        *~~< Patient Exam Report >~~*
 *
 *        Name        Patient Id	M/F   Exam1        Exam2        Exam3        AVG     Risk Level
 *        ----        ----------    ----  -----        -----        -----        -----    ----------
 *        Lewis,Rose    1111        F	  75.00        80.00        70.00        75.00    Blue
 *
 *		  Summary
 *
 *		  BLUE	  : *
 *
 *		  Female  : 100.00% (1 valid record)
 *
 *		  Valid   : 100.00% (1 records)
 *
 *		  MAX	  : 75.00
 *
 *        *< end of report >*
 *
 *
 * ************************************************************************************************
 */

 
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;

class Program04
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
		//portion below will be used for formatting the output to two decimal places
        DecimalFormat df = new DecimalFormat("0.00");
		
		//displays the heading of display
        System.out.println("*~~< Patient Exam Report >~~*");
		System.out.println("");
        System.out.println("Name\t\tPat.\tM/F\tExam1\tExam2\tExam3\tAVG\tRisk Level");
        System.out.println("----\t\t-----\t-----\t-----\t-----\t-----\t-----\t-----------");

		
		int NoRed = 0;
		int NoBlue = 0;
		int NoYellow = 0;
		int NoOrange = 0;
		int NoGreen = 0;
		int valid = 0;
		int invalid = 0;;
			
		int maleCounter = 0;
		int femaleCounter = 0;
		
		float minAVG = 100;
		float maxAVG = 0;
		
		int minID = 0;
		int maxID = 0;
		
        
		while (input.hasNext())  //this loop runs until there is data in the input file		
		{
			
			//the portion below takes the necessary data from the input file until the next line
			String name = input.next();
			int patientID = input.nextInt();
			String gender = input.next();
			float Exam1 = input.nextFloat();
			float Exam2 = input.nextFloat();
			float Exam3 = input.nextFloat();
				   
			float average = (Exam1 + Exam2 + Exam3) / 3;  //average score calculation 						
			
			//following portion checks the validity of data. valid data are between 0 and 100, included.
			if (!(Exam1 < 0 || Exam1 > 100) && !(Exam2 < 0 || Exam2 > 100) && !(Exam3 < 0 || Exam3 > 100) &&
			!(patientID < 1111 && patientID > 9999))
			{    
		
				if (gender.equalsIgnoreCase("M")) // for counting male we compare the string value we assigned to gender
				{
					maleCounter += 1;
				} else
				{
					femaleCounter += 1;
				}

				String result = "";				
				
				//the portion below assigns the various risks levels based on the average exam score of the patient
				if (average >= 97)
				{
					result = "RED";
					NoRed += 1;  //this determines number of RED risk conditions
				}
				else if (average >= 88 && average < 97)
				{
					result = "ORANGE";
					NoOrange += 1; //this determines number of ORANGE risk conditions		
				}
				else if (average >= 78 && average < 88)
				{
					result = "YELLOW";
					NoYellow += 1; //this determines number of YELLOW risk conditions
				}
				else if (average >= 70 && average < 78)
				{
					result = "BLUE";
					NoBlue += 1; //this determines number of BLUE risk conditions
				}
				else
				{
					result = "GREEN";
					NoGreen += 1; //this determines number of GREEN risk conditions
				}
				
				if (average > maxAVG)  //this compares the average to max value and assigns accordingly
				{
					maxAVG = average;
					maxID = patientID;  //assigns patient ID to max value
				}
				
				if (average < minAVG)  //this compares the average to min value and assigns accordingly
				{
					minAVG = average;
					minID = patientID; //assigns patient ID to min value
				}
				
				valid += 1;
				//the portion below displays the results
				System.out.println(name + "\t" + patientID + "\t" + gender + "\t" + df.format(Exam1) + "\t" + df.format(Exam2) + "\t" + df.format(Exam3) 
									+ "\t" + df.format(average) + "\t" + result);
			}   else 
				{            
				System.out.println(name + "\t" + patientID + "\t" + gender + "\t" + df.format(Exam1) + "\t" + df.format(Exam2) + "\t" + df.format(Exam3) 
									+ "\t" + "~~ Invalid Data ~~");
				
				invalid += 1;
				}
				
		}
		
		
		//SUMMARY PART
		System.out.println("");
		System.out.println("");
		System.out.println("Summary");
		System.out.println("");
		
		System.out.print("RED\t:");
		while (NoRed > 0)  //prints an * for every RED result
		{
			System.out.print("*");
			NoRed -= 1;
		}
		System.out.println("");
		
		System.out.print("ORANGE\t:");
		while (NoOrange > 0) //prints an * for every ORANGE result
		{
			System.out.print("*");
			NoOrange -= 1;
		}
		System.out.println("");
		
		System.out.print("YELLOW\t:");
		while (NoYellow > 0) //prints an * for every YELLOW result
		{
			System.out.print("*");
			NoYellow -= 1;
		}
		System.out.println("");
		
		System.out.print("BLUE\t:");
		while (NoBlue > 0) //prints an * for every BLUE result
		{
			System.out.print("*");
			NoBlue -= 1;
		}
		System.out.println("");
		
		System.out.print("GREEN\t:");
		while (NoGreen > 0) //prints an * for every GREEN result
		{
			System.out.print("*");
			NoGreen -= 1;
		}
		System.out.println("");
		System.out.println("");
		
		//calculation of male and female percentage and display
		double male = (float)maleCounter / valid * 100;
		double female = (float)femaleCounter / valid * 100;
		
		System.out.println("Female\t: " + df.format(female) + "%\t(" + femaleCounter + " valid records)");
		System.out.println("Male\t: " + df.format(male) + "%\t(" + maleCounter + " valid records)");
		System.out.println("");
		
		//calculation of valid and invalid data percentage and display
		double validPercent = (float)valid / (valid + invalid) * 100;
		double invalidPercent = 100.00 - validPercent;
		
		System.out.println("Valid\t: " + df.format(validPercent) + "%\t(" + valid + " records)");
		System.out.println("Valid\t: " + df.format(invalidPercent) + "%\t(" + invalid + " records)");
		System.out.println("");
		
		//display of max and min value and Patient ID associated to it.
		System.out.println("Max\t: " + df.format(maxAVG) + "\t(Patient ID: " + maxID + ")");
		System.out.println("Min\t: " + df.format(minAVG) + "\t(Patient ID: " + minID + ")");
		
        System.out.println("");
        System.out.println("*~~< End Of Report >~~*");
    }
}
