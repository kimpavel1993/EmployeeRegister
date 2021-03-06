package ru.isands.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import ru.isands.model.Employee;
import ru.isands.model.EmployeeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Employee service. Represents a row in the &quot;Employee_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ru.isands.model.EmployeeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeImpl}.
 * </p>
 *
 * @author Joe Bloggs
 * @see EmployeeImpl
 * @see ru.isands.model.Employee
 * @see ru.isands.model.EmployeeModel
 * @generated
 */
public class EmployeeModelImpl extends BaseModelImpl<Employee>
    implements EmployeeModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a employee model instance should use the {@link ru.isands.model.Employee} interface instead.
     */
    public static final String TABLE_NAME = "Employee_Employee";
    public static final Object[][] TABLE_COLUMNS = {
            { "employeeId", Types.BIGINT },
            { "lastName", Types.VARCHAR },
            { "firstName", Types.VARCHAR },
            { "middleName", Types.VARCHAR },
            { "sex", Types.VARCHAR },
            { "birthdayDate", Types.TIMESTAMP },
            { "positionId", Types.BIGINT },
            { "employmentDate", Types.TIMESTAMP },
            { "salary", Types.VARCHAR },
            { "workPhone", Types.VARCHAR },
            { "mobilePhone", Types.VARCHAR },
            { "bankId", Types.BIGINT },
            { "isArchived", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table Employee_Employee (employeeId LONG not null primary key,lastName VARCHAR(75) null,firstName VARCHAR(75) null,middleName VARCHAR(75) null,sex VARCHAR(75) null,birthdayDate DATE null,positionId LONG,employmentDate DATE null,salary VARCHAR(75) null,workPhone VARCHAR(75) null,mobilePhone VARCHAR(75) null,bankId LONG,isArchived BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table Employee_Employee";
    public static final String ORDER_BY_JPQL = " ORDER BY employee.lastName ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Employee_Employee.lastName ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.ru.isands.model.Employee"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.ru.isands.model.Employee"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.ru.isands.model.Employee"),
            true);
    public static long BANKID_COLUMN_BITMASK = 1L;
    public static long POSITIONID_COLUMN_BITMASK = 2L;
    public static long LASTNAME_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.ru.isands.model.Employee"));
    private static ClassLoader _classLoader = Employee.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Employee.class
        };
    private long _employeeId;
    private String _lastName;
    private String _firstName;
    private String _middleName;
    private String _sex;
    private Date _birthdayDate;
    private long _positionId;
    private long _originalPositionId;
    private boolean _setOriginalPositionId;
    private Date _employmentDate;
    private String _salary;
    private String _workPhone;
    private String _mobilePhone;
    private long _bankId;
    private long _originalBankId;
    private boolean _setOriginalBankId;
    private Boolean _isArchived;
    private long _columnBitmask;
    private Employee _escapedModel;

    public EmployeeModelImpl() {
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

    @Override
    public long getEmployeeId() {
        return _employeeId;
    }

    @Override
    public void setEmployeeId(long employeeId) {
        _employeeId = employeeId;
    }

    @Override
    public String getLastName() {
        if (_lastName == null) {
            return StringPool.BLANK;
        } else {
            return _lastName;
        }
    }

    @Override
    public void setLastName(String lastName) {
        _columnBitmask = -1L;

        _lastName = lastName;
    }

    @Override
    public String getFirstName() {
        if (_firstName == null) {
            return StringPool.BLANK;
        } else {
            return _firstName;
        }
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    @Override
    public String getMiddleName() {
        if (_middleName == null) {
            return StringPool.BLANK;
        } else {
            return _middleName;
        }
    }

    @Override
    public void setMiddleName(String middleName) {
        _middleName = middleName;
    }

    @Override
    public String getSex() {
        if (_sex == null) {
            return StringPool.BLANK;
        } else {
            return _sex;
        }
    }

    @Override
    public void setSex(String sex) {
        _sex = sex;
    }

    @Override
    public Date getBirthdayDate() {
        return _birthdayDate;
    }

    @Override
    public void setBirthdayDate(Date birthdayDate) {
        _birthdayDate = birthdayDate;
    }

    @Override
    public long getPositionId() {
        return _positionId;
    }

    @Override
    public void setPositionId(long positionId) {
        _columnBitmask |= POSITIONID_COLUMN_BITMASK;

        if (!_setOriginalPositionId) {
            _setOriginalPositionId = true;

            _originalPositionId = _positionId;
        }

        _positionId = positionId;
    }

    public long getOriginalPositionId() {
        return _originalPositionId;
    }

    @Override
    public Date getEmploymentDate() {
        return _employmentDate;
    }

    @Override
    public void setEmploymentDate(Date employmentDate) {
        _employmentDate = employmentDate;
    }

    @Override
    public String getSalary() {
        if (_salary == null) {
            return StringPool.BLANK;
        } else {
            return _salary;
        }
    }

    @Override
    public void setSalary(String salary) {
        _salary = salary;
    }

    @Override
    public String getWorkPhone() {
        if (_workPhone == null) {
            return StringPool.BLANK;
        } else {
            return _workPhone;
        }
    }

    @Override
    public void setWorkPhone(String workPhone) {
        _workPhone = workPhone;
    }

    @Override
    public String getMobilePhone() {
        if (_mobilePhone == null) {
            return StringPool.BLANK;
        } else {
            return _mobilePhone;
        }
    }

    @Override
    public void setMobilePhone(String mobilePhone) {
        _mobilePhone = mobilePhone;
    }

    @Override
    public long getBankId() {
        return _bankId;
    }

    @Override
    public void setBankId(long bankId) {
        _columnBitmask |= BANKID_COLUMN_BITMASK;

        if (!_setOriginalBankId) {
            _setOriginalBankId = true;

            _originalBankId = _bankId;
        }

        _bankId = bankId;
    }

    public long getOriginalBankId() {
        return _originalBankId;
    }

    @Override
    public Boolean getIsArchived() {
        return _isArchived;
    }

    @Override
    public void setIsArchived(Boolean isArchived) {
        _isArchived = isArchived;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Employee.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Employee toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Employee) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        EmployeeImpl employeeImpl = new EmployeeImpl();

        employeeImpl.setEmployeeId(getEmployeeId());
        employeeImpl.setLastName(getLastName());
        employeeImpl.setFirstName(getFirstName());
        employeeImpl.setMiddleName(getMiddleName());
        employeeImpl.setSex(getSex());
        employeeImpl.setBirthdayDate(getBirthdayDate());
        employeeImpl.setPositionId(getPositionId());
        employeeImpl.setEmploymentDate(getEmploymentDate());
        employeeImpl.setSalary(getSalary());
        employeeImpl.setWorkPhone(getWorkPhone());
        employeeImpl.setMobilePhone(getMobilePhone());
        employeeImpl.setBankId(getBankId());
        employeeImpl.setIsArchived(getIsArchived());

        employeeImpl.resetOriginalValues();

        return employeeImpl;
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

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee employee = (Employee) obj;

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
    public void resetOriginalValues() {
        EmployeeModelImpl employeeModelImpl = this;

        employeeModelImpl._originalPositionId = employeeModelImpl._positionId;

        employeeModelImpl._setOriginalPositionId = false;

        employeeModelImpl._originalBankId = employeeModelImpl._bankId;

        employeeModelImpl._setOriginalBankId = false;

        employeeModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Employee> toCacheModel() {
        EmployeeCacheModel employeeCacheModel = new EmployeeCacheModel();

        employeeCacheModel.employeeId = getEmployeeId();

        employeeCacheModel.lastName = getLastName();

        String lastName = employeeCacheModel.lastName;

        if ((lastName != null) && (lastName.length() == 0)) {
            employeeCacheModel.lastName = null;
        }

        employeeCacheModel.firstName = getFirstName();

        String firstName = employeeCacheModel.firstName;

        if ((firstName != null) && (firstName.length() == 0)) {
            employeeCacheModel.firstName = null;
        }

        employeeCacheModel.middleName = getMiddleName();

        String middleName = employeeCacheModel.middleName;

        if ((middleName != null) && (middleName.length() == 0)) {
            employeeCacheModel.middleName = null;
        }

        employeeCacheModel.sex = getSex();

        String sex = employeeCacheModel.sex;

        if ((sex != null) && (sex.length() == 0)) {
            employeeCacheModel.sex = null;
        }

        Date birthdayDate = getBirthdayDate();

        if (birthdayDate != null) {
            employeeCacheModel.birthdayDate = birthdayDate.getTime();
        } else {
            employeeCacheModel.birthdayDate = Long.MIN_VALUE;
        }

        employeeCacheModel.positionId = getPositionId();

        Date employmentDate = getEmploymentDate();

        if (employmentDate != null) {
            employeeCacheModel.employmentDate = employmentDate.getTime();
        } else {
            employeeCacheModel.employmentDate = Long.MIN_VALUE;
        }

        employeeCacheModel.salary = getSalary();

        String salary = employeeCacheModel.salary;

        if ((salary != null) && (salary.length() == 0)) {
            employeeCacheModel.salary = null;
        }

        employeeCacheModel.workPhone = getWorkPhone();

        String workPhone = employeeCacheModel.workPhone;

        if ((workPhone != null) && (workPhone.length() == 0)) {
            employeeCacheModel.workPhone = null;
        }

        employeeCacheModel.mobilePhone = getMobilePhone();

        String mobilePhone = employeeCacheModel.mobilePhone;

        if ((mobilePhone != null) && (mobilePhone.length() == 0)) {
            employeeCacheModel.mobilePhone = null;
        }

        employeeCacheModel.bankId = getBankId();

        employeeCacheModel.isArchived = getIsArchived();

        return employeeCacheModel;
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
