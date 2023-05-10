package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class EmployeePayrollServiceTest {
    @Test
    public void given3EmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmp = {
                new EmployeePayrollData(1, "Swapnil", 10000),
                new EmployeePayrollData(2, "Shubham", 20000),
                new EmployeePayrollData(3, "Kunal", 30000)
        };
        EmployeePayrollService employeePayRollService;
        employeePayRollService = new EmployeePayrollService(Arrays.asList(arrayOfEmp));
        employeePayRollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayRollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3, entries);
        employeePayRollService.printData(EmployeePayrollService.IOService.FILE_IO);
        System.out.println("Employee Payroll Service Number of Entries is : "+entries);
    }

}
