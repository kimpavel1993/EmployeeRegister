package ru.isands.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author Joe Bloggs
 * @see Employee
 * @generated
 */
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
    private Employee _employee;

    public EmployeeWrapper(Employee employee) {
        _employee = employee;
    }

    @Override
    public Class<?> getModelClass() {
        return Employee.class;
    }

    @Override
    public String getModelClassName() {
        return Employee.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("employeeId", getEmployeeId());
        attributes.put("lastName", getLastName());
        attributes.put("firstName", getFirstName());
        attributes.put("middleName", getMiddleName());
        attributes.put("sex", getSex());
        attributes.put("birthdayDate", getBirthdayDate());
        attributes.put("positionId", getPositionId());
        attributes.put("employmentDate", getEmploymentDate());
        attributes.put("salary", getSalary());
        attributes.put("workPhone", getWorkPhone());
        attributes.put("mobilePhone", getMobilePhone());
        attributes.put("bankId", getBankId());
        attributes.put("isArchived", getIsArchived());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long employeeId = (Long) attributes.get("employeeId");

        if (employeeId != null) {
            setEmployeeId(employeeId);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
        }

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }

        String middleName = (String) attributes.get("middleName");

        if (middleName != null) {
            setMiddleName(middleName);
        }

        String sex = (String) attributes.get("sex");

        if (sex != null) {
            setSex(sex);
        }

        Date birthdayDate = (Date) attributes.get("birthdayDate");

        if (birthdayDate != null) {
            setBirthdayDate(birthdayDate);
        }

        Long positionId = (Long) attributes.get("positionId");

        if (positionId != null) {
            setPositionId(positionId);
        }

        Date employmentDate = (Date) attributes.get("employmentDate");

        if (employmentDate != null) {
            setEmploymentDate(employmentDate);
        }

        String salary = (String) attributes.get("salary");

        if (salary != null) {
            setSalary(salary);
        }

        String workPhone = (String) attributes.get("workPhone");

        if (workPhone != null) {
            setWorkPhone(workPhone);
        }

        String mobilePhone = (String) attributes.get("mobilePhone");

        if (mobilePhone != null) {
            setMobilePhone(mobilePhone);
        }

        Long bankId = (Long) attributes.get("bankId");

        if (bankId != null) {
            setBankId(bankId);
        }

        Boolean isArchived = (Boolean) attributes.get("isArchived");

        if (isArchived != null) {
            setIsArchived(isArchived);
        }
    }

    /**
    * Returns the primary key of this employee.
    *
    * @return the primary key of this employee
    */
    @Override
    public long getPrimaryKey() {
        return _employee.getPrimaryKey();
    }

    /**
    * Sets the primary key of this employee.
    *
    * @param primaryKey the primary key of this employee
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _employee.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the employee ID of this employee.
    *
    * @return the employee ID of this employee
    */
    @Override
    public long getEmployeeId() {
        return _employee.getEmployeeId();
    }

    /**
    * Sets the employee ID of this employee.
    *
    * @param employeeId the employee ID of this employee
    */
    @Override
    public void setEmployeeId(long employeeId) {
        _employee.setEmployeeId(employeeId);
    }

    /**
    * Returns the last name of this employee.
    *
    * @return the last name of this employee
    */
    @Override
    public java.lang.String getLastName() {
        return _employee.getLastName();
    }

    /**
    * Sets the last name of this employee.
    *
    * @param lastName the last name of this employee
    */
    @Override
    public void setLastName(java.lang.String lastName) {
        _employee.setLastName(lastName);
    }

    /**
    * Returns the first name of this employee.
    *
    * @return the first name of this employee
    */
    @Override
    public java.lang.String getFirstName() {
        return _employee.getFirstName();
    }

    /**
    * Sets the first name of this employee.
    *
    * @param firstName the first name of this employee
    */
    @Override
    public void setFirstName(java.lang.String firstName) {
        _employee.setFirstName(firstName);
    }

    /**
    * Returns the middle name of this employee.
    *
    * @return the middle name of this employee
    */
    @Override
    public java.lang.String getMiddleName() {
        return _employee.getMiddleName();
    }

    /**
    * Sets the middle name of this employee.
    *
    * @param middleName the middle name of this employee
    */
    @Override
    public void setMiddleName(java.lang.String middleName) {
        _employee.setMiddleName(middleName);
    }

    /**
    * Returns the sex of this employee.
    *
    * @return the sex of this employee
    */
    @Override
    public java.lang.String getSex() {
        return _employee.getSex();
    }

    /**
    * Sets the sex of this employee.
    *
    * @param sex the sex of this employee
    */
    @Override
    public void setSex(java.lang.String sex) {
        _employee.setSex(sex);
    }

    /**
    * Returns the birthday date of this employee.
    *
    * @return the birthday date of this employee
    */
    @Override
    public java.util.Date getBirthdayDate() {
        return _employee.getBirthdayDate();
    }

    /**
    * Sets the birthday date of this employee.
    *
    * @param birthdayDate the birthday date of this employee
    */
    @Override
    public void setBirthdayDate(java.util.Date birthdayDate) {
        _employee.setBirthdayDate(birthdayDate);
    }

    /**
    * Returns the position ID of this employee.
    *
    * @return the position ID of this employee
    */
    @Override
    public long getPositionId() {
        return _employee.getPositionId();
    }

    /**
    * Sets the position ID of this employee.
    *
    * @param positionId the position ID of this employee
    */
    @Override
    public void setPositionId(long positionId) {
        _employee.setPositionId(positionId);
    }

    /**
    * Returns the employment date of this employee.
    *
    * @return the employment date of this employee
    */
    @Override
    public java.util.Date getEmploymentDate() {
        return _employee.getEmploymentDate();
    }

    /**
    * Sets the employment date of this employee.
    *
    * @param employmentDate the employment date of this employee
    */
    @Override
    public void setEmploymentDate(java.util.Date employmentDate) {
        _employee.setEmploymentDate(employmentDate);
    }

    /**
    * Returns the salary of this employee.
    *
    * @return the salary of this employee
    */
    @Override
    public java.lang.String getSalary() {
        return _employee.getSalary();
    }

    /**
    * Sets the salary of this employee.
    *
    * @param salary the salary of this employee
    */
    @Override
    public void setSalary(java.lang.String salary) {
        _employee.setSalary(salary);
    }

    /**
    * Returns the work phone of this employee.
    *
    * @return the work phone of this employee
    */
    @Override
    public java.lang.String getWorkPhone() {
        return _employee.getWorkPhone();
    }

    /**
    * Sets the work phone of this employee.
    *
    * @param workPhone the work phone of this employee
    */
    @Override
    public void setWorkPhone(java.lang.String workPhone) {
        _employee.setWorkPhone(workPhone);
    }

    /**
    * Returns the mobile phone of this employee.
    *
    * @return the mobile phone of this employee
    */
    @Override
    public java.lang.String getMobilePhone() {
        return _employee.getMobilePhone();
    }

    /**
    * Sets the mobile phone of this employee.
    *
    * @param mobilePhone the mobile phone of this employee
    */
    @Override
    public void setMobilePhone(java.lang.String mobilePhone) {
        _employee.setMobilePhone(mobilePhone);
    }

    /**
    * Returns the bank ID of this employee.
    *
    * @return the bank ID of this employee
    */
    @Override
    public long getBankId() {
        return _employee.getBankId();
    }

    /**
    * Sets the bank ID of this employee.
    *
    * @param bankId the bank ID of this employee
    */
    @Override
    public void setBankId(long bankId) {
        _employee.setBankId(bankId);
    }

    /**
    * Returns the is archived of this employee.
    *
    * @return the is archived of this employee
    */
    @Override
    public java.lang.Boolean getIsArchived() {
        return _employee.getIsArchived();
    }

    /**
    * Sets the is archived of this employee.
    *
    * @param isArchived the is archived of this employee
    */
    @Override
    public void setIsArchived(java.lang.Boolean isArchived) {
        _employee.setIsArchived(isArchived);
    }

    @Override
    public boolean isNew() {
        return _employee.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _employee.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _employee.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _employee.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _employee.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _employee.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _employee.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _employee.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _employee.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _employee.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _employee.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EmployeeWrapper((Employee) _employee.clone());
    }

    @Override
    public int compareTo(Employee employee) {
        return _employee.compareTo(employee);
    }

    @Override
    public int hashCode() {
        return _employee.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Employee> toCacheModel() {
        return _employee.toCacheModel();
    }

    @Override
    public Employee toEscapedModel() {
        return new EmployeeWrapper(_employee.toEscapedModel());
    }

    @Override
    public Employee toUnescapedModel() {
        return new EmployeeWrapper(_employee.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _employee.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _employee.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _employee.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EmployeeWrapper)) {
            return false;
        }

        EmployeeWrapper employeeWrapper = (EmployeeWrapper) obj;

        if (Validator.equals(_employee, employeeWrapper._employee)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Employee getWrappedEmployee() {
        return _employee;
    }

    @Override
    public Employee getWrappedModel() {
        return _employee;
    }

    @Override
    public void resetOriginalValues() {
        _employee.resetOriginalValues();
    }
}
