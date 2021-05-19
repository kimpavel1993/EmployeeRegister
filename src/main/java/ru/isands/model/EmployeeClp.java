package ru.isands.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ru.isands.service.ClpSerializer;
import ru.isands.service.EmployeeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class EmployeeClp extends BaseModelImpl<Employee> implements Employee {
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
    private BaseModel<?> _employeeRemoteModel;

    public EmployeeClp() {
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
    public long getPrimaryKey() {
        return _employeeId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setEmployeeId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _employeeId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getEmployeeId() {
        return _employeeId;
    }

    @Override
    public void setEmployeeId(long employeeId) {
        _employeeId = employeeId;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setEmployeeId", long.class);

                method.invoke(_employeeRemoteModel, employeeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLastName() {
        return _lastName;
    }

    @Override
    public void setLastName(String lastName) {
        _lastName = lastName;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setLastName", String.class);

                method.invoke(_employeeRemoteModel, lastName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFirstName() {
        return _firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setFirstName", String.class);

                method.invoke(_employeeRemoteModel, firstName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMiddleName() {
        return _middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        _middleName = middleName;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setMiddleName", String.class);

                method.invoke(_employeeRemoteModel, middleName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSex() {
        return _sex;
    }

    @Override
    public void setSex(String sex) {
        _sex = sex;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setSex", String.class);

                method.invoke(_employeeRemoteModel, sex);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getBirthdayDate() {
        return _birthdayDate;
    }

    @Override
    public void setBirthdayDate(Date birthdayDate) {
        _birthdayDate = birthdayDate;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setBirthdayDate", Date.class);

                method.invoke(_employeeRemoteModel, birthdayDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPositionId() {
        return _positionId;
    }

    @Override
    public void setPositionId(long positionId) {
        _positionId = positionId;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setPositionId", long.class);

                method.invoke(_employeeRemoteModel, positionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getEmploymentDate() {
        return _employmentDate;
    }

    @Override
    public void setEmploymentDate(Date employmentDate) {
        _employmentDate = employmentDate;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setEmploymentDate", Date.class);

                method.invoke(_employeeRemoteModel, employmentDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSalary() {
        return _salary;
    }

    @Override
    public void setSalary(String salary) {
        _salary = salary;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setSalary", String.class);

                method.invoke(_employeeRemoteModel, salary);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWorkPhone() {
        return _workPhone;
    }

    @Override
    public void setWorkPhone(String workPhone) {
        _workPhone = workPhone;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setWorkPhone", String.class);

                method.invoke(_employeeRemoteModel, workPhone);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMobilePhone() {
        return _mobilePhone;
    }

    @Override
    public void setMobilePhone(String mobilePhone) {
        _mobilePhone = mobilePhone;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setMobilePhone", String.class);

                method.invoke(_employeeRemoteModel, mobilePhone);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getBankId() {
        return _bankId;
    }

    @Override
    public void setBankId(long bankId) {
        _bankId = bankId;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setBankId", long.class);

                method.invoke(_employeeRemoteModel, bankId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getIsArchived() {
        return _isArchived;
    }

    @Override
    public void setIsArchived(Boolean isArchived) {
        _isArchived = isArchived;

        if (_employeeRemoteModel != null) {
            try {
                Class<?> clazz = _employeeRemoteModel.getClass();

                Method method = clazz.getMethod("setIsArchived", Boolean.class);

                method.invoke(_employeeRemoteModel, isArchived);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getEmployeeRemoteModel() {
        return _employeeRemoteModel;
    }

    public void setEmployeeRemoteModel(BaseModel<?> employeeRemoteModel) {
        _employeeRemoteModel = employeeRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _employeeRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_employeeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            EmployeeLocalServiceUtil.addEmployee(this);
        } else {
            EmployeeLocalServiceUtil.updateEmployee(this);
        }
    }

    @Override
    public Employee toEscapedModel() {
        return (Employee) ProxyUtil.newProxyInstance(Employee.class.getClassLoader(),
            new Class[] { Employee.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EmployeeClp clone = new EmployeeClp();

        clone.setEmployeeId(getEmployeeId());
        clone.setLastName(getLastName());
        clone.setFirstName(getFirstName());
        clone.setMiddleName(getMiddleName());
        clone.setSex(getSex());
        clone.setBirthdayDate(getBirthdayDate());
        clone.setPositionId(getPositionId());
        clone.setEmploymentDate(getEmploymentDate());
        clone.setSalary(getSalary());
        clone.setWorkPhone(getWorkPhone());
        clone.setMobilePhone(getMobilePhone());
        clone.setBankId(getBankId());
        clone.setIsArchived(getIsArchived());

        return clone;
    }

    @Override
    public int compareTo(Employee employee) {
        int value = 0;

        value = getLastName().compareTo(employee.getLastName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EmployeeClp)) {
            return false;
        }

        EmployeeClp employee = (EmployeeClp) obj;

        long primaryKey = employee.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{employeeId=");
        sb.append(getEmployeeId());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append(", middleName=");
        sb.append(getMiddleName());
        sb.append(", sex=");
        sb.append(getSex());
        sb.append(", birthdayDate=");
        sb.append(getBirthdayDate());
        sb.append(", positionId=");
        sb.append(getPositionId());
        sb.append(", employmentDate=");
        sb.append(getEmploymentDate());
        sb.append(", salary=");
        sb.append(getSalary());
        sb.append(", workPhone=");
        sb.append(getWorkPhone());
        sb.append(", mobilePhone=");
        sb.append(getMobilePhone());
        sb.append(", bankId=");
        sb.append(getBankId());
        sb.append(", isArchived=");
        sb.append(getIsArchived());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("ru.isands.model.Employee");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>employeeId</column-name><column-value><![CDATA[");
        sb.append(getEmployeeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastName</column-name><column-value><![CDATA[");
        sb.append(getLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstName</column-name><column-value><![CDATA[");
        sb.append(getFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>middleName</column-name><column-value><![CDATA[");
        sb.append(getMiddleName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sex</column-name><column-value><![CDATA[");
        sb.append(getSex());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>birthdayDate</column-name><column-value><![CDATA[");
        sb.append(getBirthdayDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>positionId</column-name><column-value><![CDATA[");
        sb.append(getPositionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>employmentDate</column-name><column-value><![CDATA[");
        sb.append(getEmploymentDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>salary</column-name><column-value><![CDATA[");
        sb.append(getSalary());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>workPhone</column-name><column-value><![CDATA[");
        sb.append(getWorkPhone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mobilePhone</column-name><column-value><![CDATA[");
        sb.append(getMobilePhone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bankId</column-name><column-value><![CDATA[");
        sb.append(getBankId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isArchived</column-name><column-value><![CDATA[");
        sb.append(getIsArchived());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
