package com.mouritech.employee.entity;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {
	@Id
	private int empId;
	private String empName;
	private String empEmail;
	private String empLocation;
	private String empAddress;
	private Long empContactNo;
	private String empDepartment;
	

public Employee(String empName, String empEmail, String empLocation, String empAddress, Long empContactNo,
			String empDepartment) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empLocation = empLocation;
		this.empAddress = empAddress;
		this.empContactNo = empContactNo;
		this.empDepartment = empDepartment;
	}
	public Employee(String empName, String empEmail, String empLocation, String empAddress, Long empContactNo,
			String empDepartment, int empId) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empLocation = empLocation;
		this.empAddress = empAddress;
		this.empContactNo = empContactNo;
		this.empDepartment = empDepartment;
		this.empId = empId;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public Long getEmpContactNo() {
		return empContactNo;
	}
	public void setEmpContactNo(Long empContactNo) {
		this.empContactNo = empContactNo;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empEmail=" + empEmail + ", empLocation=" + empLocation
				+ ", empAddress=" + empAddress + ", empContactNo=" + empContactNo + ", empDepartment=" + empDepartment
				+ ", empId=" + empId + "]";
	}
	
	
}