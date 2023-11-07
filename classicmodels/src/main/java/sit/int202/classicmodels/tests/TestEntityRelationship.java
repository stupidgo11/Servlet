package sit.int202.classicmodels.tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Environment;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.EntityManagerBuilder;

import java.util.Scanner;

public class TestEntityRelationship {
    public static void main(String[] args) {
        EntityManager em = EntityManagerBuilder.getEntityManager();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter office code (0 to stop): ");
            String officeCode = sc.next();
            if(officeCode.equalsIgnoreCase("0")) {
                break;
            }
            Office office = em.find(Office.class, officeCode);
            if (office == null) {
                System.out.println("Office code "+ officeCode + " does not exist !!");
            } else {
                displayOfficeEmployee(office);
            }
        } while (true);
    }

    private static void displayOfficeEmployee(Office office) {
        System.out.println(office.getOfficeCode()+ " "+ office.getCity() + ", "+
                office.getCountry());
        System.out.println("---------------------------------------------");
        for(Employee employee : office.getEmployeeList()) {
            System.out.printf("%8d %-10s %-12s %-15s\n",
                    employee.getEmployeeNumber(), employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle());
        }
        System.out.println();
    }
}
