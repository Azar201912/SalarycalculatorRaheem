

	/** Calculator V5 Requirement
	 * In version 5 The software company wants to add a new Feature 
	 * on the Input System that will give the User to try 5 time putting Wrong Input 
	 * Before the Program End 
	 * */

	import java.util.Scanner;

	public class SalaryCalculatorv7 {

		// GLOBAL Variables That Required for the Entire Classs
		static String ename;
		static double totalhour = 0;
		static double hourlyrate = 0;
		static double grosspay;
		static double netPay = 0;

		public static void welcomeText() { //// Function / Module / Procedure
			// Welcome Text
			System.out.println("Welcome to Salary Calculator V1.0");
			System.out.println("Please Follow the Prompt .........");

		}

		public static void getInput() {

			Scanner myscanner = getOneScanner(); // Local

			System.out.println("");

			System.out.print("Enter Employee Name : ");
			ename = myscanner.nextLine();

			// Brak Ename all Character and then Check Each Character doensn't contains NUmber 
			
			
			
			/// Validate Employee Name Not Contains Any Number

			//// check the value of total Hour is between 0 to 80
			int tryCount = 1; ////// Local
			char isTheInputCorrect = 'N';

			do {
				try {
					System.out.print("\nEnter Employee Total Hour : ");
					totalhour = myscanner.nextDouble();
					if (totalhour >= 0 && totalhour <= 80) {
						isTheInputCorrect = 'Y';
					} else {
						System.out.println("Please Enter Total Hour Between 0 to 80!!! - You entered " + totalhour);
						isTheInputCorrect = 'N';
						tryCount++;
					}
				} catch (Exception e) {
					System.out.println("Please Enter Total Hour Between 0 to 80!!! - You entered something weird .... ");
					isTheInputCorrect = 'N';
					myscanner = new Scanner(System.in); // new Refence hasbeen created here
					tryCount++;
				}

				// It will Check How many time user Tried to Give a Wrong Input
				if (tryCount > 5) {
					System.out.println("Please Run The Program Again And enter Correct Input Bye Bye Stopping .......  ");
					System.exit(0);
				}

			} while (isTheInputCorrect == 'N'); // False Loop End --True Loop COntine

			//// check the value of Hourly Rate is between 10 to 50
			tryCount = 1;
			do {
				try {
					System.out.print("Enter Employee Hourly Rate : ");
					hourlyrate = myscanner.nextDouble();
					if (hourlyrate >= 10 && hourlyrate <= 50) {
						isTheInputCorrect = 'Y';
					} else {
						System.out.println("Please Enter Hourly Rate Between 10 to 50!!! - You entered " + hourlyrate);
						isTheInputCorrect = 'N';
						tryCount++;
					}
				} catch (Exception e) {
					System.out.println("Please Enter Hourly Rate Between 10 to 50!!! - You entered something weird ");
					isTheInputCorrect = 'N';
					myscanner = new Scanner(System.in); // new Refence hasbeen created here
				}

				// It will Check How many time user Tried to Give a Wrong Input
				if (tryCount > 5) {
					System.out.println("Please Run The Program Again And enter Correct Input Bye Bye Stopping .......  ");
					System.exit(0);
				}

			} while (isTheInputCorrect == 'N');

			// myscanner.close();
		}

		public static void calculateGrossPay() {
			// Process Gross Pay
			grosspay = totalhour * hourlyrate;

		}

		public static void calculateNetPay() {
			// Process Net Pay

			// Complicated If Else Logic - We will do a Debug Run Line By to to see whats
			// happening
			if (grosspay < 1500) {
				netPay = grosspay - (grosspay * .10);
			} else if (grosspay >= 1500 && grosspay < 3000) {
				netPay = grosspay - (grosspay * .20);
			} else if (grosspay >= 3000 && grosspay < 4500) {
				netPay = grosspay - (grosspay * .30);
			} else if (grosspay >= 4500 && grosspay < 6000) {
				netPay = grosspay - (grosspay * .40);
			} else if (grosspay >= 6000) {
				netPay = grosspay - (grosspay * .45);
			}

		}

		public static void disPlayOutPut() {
			// Displaying Output
			System.out.println("");
			System.out.println("Employe Name  : " + ename); // Concatenation
			System.out.println("Total Hour    : " + totalhour);
			System.out.println("Hourly Rate   : " + hourlyrate);
			System.out.println("===============================");
			System.out.println("Gross Pay is  : " + grosspay);
			System.out.println("Net Pay Pay is  : " + netPay);
		}

		
		public static boolean doYouWantToContinue() {		
			Scanner scn = getOneScanner();
			
			
			String doYouWantToContinue;
			System.out.print("\nDo You Want TO Continue [Only Yes/No is Accepatable]: ");
			doYouWantToContinue = scn.nextLine(); // Yes/No
			doYouWantToContinue = doYouWantToContinue.toUpperCase();

			if (doYouWantToContinue.equals("YES")) {
				return true;
			} else {
				return false;
			}
		}
		
		
		
		public static Scanner getOneScanner() {
			
			return new Scanner(System.in);
		}
		
		
		

		/// Driver Module his name is Main()
		public static void main(String[] args) { /// Special

			/// Salary calculator in Action with the Driver Main()
			welcomeText();
			
			
			// In Loop 5 Time 5 EMployesss salary will Calculate
			for (int i = 1; i <= 5; i++) {
				
				System.out.println("\n ######### Processing Employee " + i + " ###############");
				getInput();
				calculateGrossPay();
				calculateNetPay();
				disPlayOutPut();
				
				
				/// Option 1
				if(!doYouWantToContinue()) break;

//				// option 3
//				if(doYouWantToContinue()==false) break;
//				
//				/// Option 2
//				if(doYouWantToContinue()==true) {
//					/// DO Nothing 
//				}else {
//					break;
//				}
				



				
				
			}

		}

	}


