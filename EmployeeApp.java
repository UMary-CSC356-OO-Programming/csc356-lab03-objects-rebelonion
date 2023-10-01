import java.util.Scanner;

class Employee {
	// Task 3B: Add instance variables
	private String lastName;
	private String firstName;
	private int employeeId;
	private double salary;

	// Task 3C: Add three constructors
	public Employee() {
		this.lastName = "";
		this.firstName = "";
		this.employeeId = 0;
		this.salary = 0.0;
	}

	public Employee(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.employeeId = 0;
		this.salary = 0.0;
	}

	public Employee(String lastName, String firstName, int employeeId, double salary) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.employeeId = employeeId;
		this.salary = salary;
	}

	// Task 3D: Add set (mutator) and get (accessor) methods
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	// Task 3F: Add toString method
	@Override
	public String toString() {
		return "Employee [lastName=" + lastName + ", firstName=" + firstName + ", employeeId=" + employeeId
				+ ", salary=" + salary + "]";
	}

	// Task 3G: Add equals method
	public boolean equals(String lastName) {
		return this.lastName.equalsIgnoreCase(lastName);
	}
}

public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[]  employees = new Employee[MAX_EMPLOYEES];
		Employee    currentEmployee;
		String      inputString;
		int         inputInt;
		double      inputDouble;
		char        choice;
		int         empCount=0;
      
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES-1 )
					{
						// Create object for new Employee
						employees[empCount] = new Employee();
                
						// Task 3E: Prompt for user information and set the object 
						// parameters via the mutator methods
						System.out.print("Enter Last Name: ");
						String lastName = keyboard.nextLine();
						employees[empCount].setLastName(lastName);

						System.out.print("Enter First Name: ");
						String firstName = keyboard.nextLine();
						employees[empCount].setFirstName(firstName);

						System.out.print("Enter Employee ID: ");
						int employeeId = keyboard.nextInt();
						employees[empCount].setEmployeeId(employeeId);

						System.out.print("Enter Salary: ");
						double salary = keyboard.nextDouble();
						employees[empCount].setSalary(salary);


						empCount++;
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.printf( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						// Verify that the employee entry has been allocated before Editing
						if ( employees[lp] != null )
						{
							if ( employees[lp].equals( inputString ) == true )
							{
								System.out.print( "Enter Employee ID    : " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								keyboard.nextLine();
							}
						}
					}
				break;
              
				case 'L':
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						System.out.println( employees[lp] );
					}
				break;
			}
			keyboard.reset();
		} while( choice != 'Q' );
	}  
}
