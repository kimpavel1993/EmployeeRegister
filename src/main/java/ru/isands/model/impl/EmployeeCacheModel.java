package ru.isands.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.isands.model.Employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author Joe Bloggs
 * @see Employee
 * @generated
 */
public class EmployeeCacheModel implements CacheModel<Employee>, Externalizable {
    public long employeeId;
    public String lastName;
    public String firstName;
    public String middleName;
    public String sex;
    public long birthdayDate;
    public long positionId;
    public long employmentDate;
    public String salary;
    public String workPhone;
    public String mobilePhone;
    public long bankId;
    public Boolean isArchived;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{employeeId=");
        sb.append(employeeId);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", middleName=");
        sb.append(middleName);
        sb.append(", sex=");
        sb.append(sex);
        sb.append(", birthdayDate=");
        sb.append(birthdayDate);
        sb.append(", positionId=");
        sb.append(positionId);
        sb.append(", employmentDate=");
        sb.append(employmentDate);
        sb.append(", salary=");
        sb.append(salary);
        sb.append(", workPhone=");
        sb.append(workPhone);
        sb.append(", mobilePhone=");
        sb.append(mobilePhone);
        sb.append(", bankId=");
        sb.append(bankId);
        sb.append(", isArchived=");
        sb.append(isArchived);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Employee toEntityModel() {
        EmployeeImpl employeeImpl = new EmployeeImpl();

        employeeImpl.setEmployeeId(employeeId);

        if (lastName == null) {
            employeeImpl.setLastName(StringPool.BLANK);
        } else {
            employeeImpl.setLastName(lastName);
        }

        if (firstName == null) {
            employeeImpl.setFirstName(StringPool.BLANK);
        } else {
            employeeImpl.setFirstName(firstName);
        }

        if (middleName == null) {
            employeeImpl.setMiddleName(StringPool.BLANK);
        } else {
            employeeImpl.setMiddleName(middleName);
        }

        if (sex == null) {
            employeeImpl.setSex(StringPool.BLANK);
        } else {
            employeeImpl.setSex(sex);
        }

        if (birthdayDate == Long.MIN_VALUE) {
            employeeImpl.setBirthdayDate(null);
        } else {
            employeeImpl.setBirthdayDate(new Date(birthdayDate));
        }

        employeeImpl.setPositionId(positionId);

        if (employmentDate == Long.MIN_VALUE) {
            employeeImpl.setEmploymentDate(null);
        } else {
            employeeImpl.setEmploymentDate(new Date(employmentDate));
        }

        if (salary == null) {
            employeeImpl.setSalary(StringPool.BLANK);
        } else {
            employeeImpl.setSalary(salary);
        }

        if (workPhone == null) {
            employeeImpl.setWorkPhone(StringPool.BLANK);
        } else {
            employeeImpl.setWorkPhone(workPhone);
        }

        if (mobilePhone == null) {
            employeeImpl.setMobilePhone(StringPool.BLANK);
        } else {
            employeeImpl.setMobilePhone(mobilePhone);
        }

        employeeImpl.setBankId(bankId);
        employeeImpl.setIsArchived(isArchived);

        employeeImpl.resetOriginalValues();

        return employeeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        employeeId = objectInput.readLong();
        lastName = objectInput.readUTF();
        firstName = objectInput.readUTF();
        middleName = objectInput.readUTF();
        sex = objectInput.readUTF();
        birthdayDate = objectInput.readLong();
        positionId = objectInput.readLong();
        employmentDate = objectInput.readLong();
        salary = objectInput.readUTF();
        workPhone = objectInput.readUTF();
        mobilePhone = objectInput.readUTF();
        bankId = objectInput.readLong();
        isArchived = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(employeeId);

        if (lastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lastName);
        }

        if (firstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(firstName);
        }

        if (middleName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(middleName);
        }

        if (sex == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sex);
        }

        objectOutput.writeLong(birthdayDate);
        objectOutput.writeLong(positionId);
        objectOutput.writeLong(employmentDate);

        if (salary == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(salary);
        }

        if (workPhone == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(workPhone);
        }

        if (mobilePhone == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mobilePhone);
        }

        objectOutput.writeLong(bankId);
        objectOutput.writeBoolean(isArchived);
    }
}
