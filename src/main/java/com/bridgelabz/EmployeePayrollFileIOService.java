package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
    public static String PAYROLL_FILE_NAME = "Z:\\RFP_Java fellowship - 270\\Employee-payroll-io\\src\\main\\java\\com\\bridgelabz\\payroll-file.txt";

    public void writeData(List<EmployeePayrollData> employeePayrollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(Path.of(PAYROLL_FILE_NAME)).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public void printData() {
        try {
            Files.lines(Path.of(PAYROLL_FILE_NAME)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<EmployeePayrollData> readData() {
        List<EmployeePayrollData> employeePayRollDataList = new ArrayList<>();
        try {
            Files.lines(Path.of(PAYROLL_FILE_NAME)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeePayRollDataList;

    }
}