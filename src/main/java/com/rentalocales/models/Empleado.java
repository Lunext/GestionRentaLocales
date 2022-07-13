package com.rentalocales.models;

import javax.persistence.*;

@Entity
@Table(name="empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id", unique = true)
    private Integer id;

    @Column(name = "EmployeeName", nullable = false, length = 50)
    private String EmployeeName;
    @Column(name = "EmployeeLastName", nullable = false, length = 50)
    private String EmployeeLastName;
    @Column(name = "EmployeeEmail", nullable = false, length = 50, unique = true)

    private String employeeEmail;

    @Column(name = "EmployeePosition", nullable = false, length = 50, unique = true)
    private String employeePosition;


    public Empleado() {
    }

    public Empleado(Integer id, String employeeName, String employeeLastName, String employeeEmail,String employeePosition) {
        this.id = id;
        EmployeeName = employeeName;
        EmployeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeePosition=employeePosition;
    }

    public Empleado(String employeeName, String employeeLastName, String employeeEmail, String employeePosition) {
        EmployeeName = employeeName;
        EmployeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeePosition=employeePosition;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeLastName() {
        return EmployeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        EmployeeLastName = employeeLastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", EmployeeLastName='" + EmployeeLastName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                '}';
    }
}
