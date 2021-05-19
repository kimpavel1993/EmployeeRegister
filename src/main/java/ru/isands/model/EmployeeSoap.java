package ru.isands.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Joe Bloggs
 * @generated
 */
public class EmployeeSoap implements Serializable {
    private long _employeeId;
    private String _lastName;
    private String _firstName;
    private String _middleName;
    private String _sex;
    private Date _birthdayDate;
    private long _positionId;
    private Date _employmentDate;
    private String _salary;
    private String _workPhone;
    private String _mobilePhone;
    private long _bankId;
    private Boolean _isArchived;

    public EmployeeSoap() {
    }

    public static EmployeeSoap toSoapModel(Employee model) {
        EmployeeSoap soapModel = new EmployeeSoap();

        soapModel.setEmployeeId(model.getEmployeeId());
        soapModel.setLastName(model.getLastName());
        soapModel.setFirstName(model.getFirstName());
        soapModel.setMiddleName(model.getMiddleName());
        soapModel.setSex(model.getSex());
        soapModel.setBirthdayDate(model.getBirthdayDate());
        soapModel.setPositionId(model.getPositionId());
        soapModel.setEmploymentDate(model.getEmploymentDate());
        soapModel.setSalary(model.getSalary());
        soapModel.setWorkPhone(model.getWorkPhone());
        soapModel.setMobilePhone(model.getMobilePhone());
        soapModel.setBankId(model.getBankId());
        soapModel.setIsArchived(model.getIsArchived());

        return soapModel;
    }

    public static EmployeeSoap[] toSoapModels(Employee[] models) {
        EmployeeSoap[] soapModels = new EmployeeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EmployeeSoap[][] toSoapModels(Employee[][] models) {
        EmployeeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EmployeeSoap[models.length][models[0].length];
        } else {
            soapModels = new EmployeeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EmployeeSoap[] toSoapModels(List<Employee> models) {
        List<EmployeeSoap> soapModels = new ArrayList<EmployeeSoap>(models.size());

        for (Employee model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EmployeeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _employeeId;
    }

    public void setPrimaryKey(long pk) {
        setEmployeeId(pk);
    }

    public long getEmployeeId() {
        return _employeeId;
    }

    public void setEmployeeId(long employeeId) {
        _employeeId = employeeId;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getMiddleName() {
        return _middleName;
    }

    public void setMiddleName(String middleName) {
        _middleName = middleName;
    }

    public String getSex() {
        return _sex;
    }

    public void setSex(String sex) {
        _sex = sex;
    }

    public Date getBirthdayDate() {
        return _birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        _birthdayDate = birthdayDate;
    }

    public long getPositionId() {
        return _positionId;
    }

    public void setPositionId(long positionId) {
        _positionId = positionId;
    }

    public Date getEmploymentDate() {
        return _employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        _employmentDate = employmentDate;
    }

    public String getSalary() {
        return _salary;
    }

    public void setSalary(String salary) {
        _salary = salary;
    }

    public String getWorkPhone() {
        return _workPhone;
    }

    public void setWorkPhone(String workPhone) {
        _workPhone = workPhone;
    }

    public String getMobilePhone() {
        return _mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        _mobilePhone = mobilePhone;
    }

    public long getBankId() {
        return _bankId;
    }

    public void setBankId(long bankId) {
        _bankId = bankId;
    }

    public Boolean getIsArchived() {
        return _isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        _isArchived = isArchived;
    }
}
