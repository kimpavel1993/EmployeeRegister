package ru.isands.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.isands.model.Employee;
import ru.isands.service.EmployeeLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeListingPortlet extends MVCPortlet {
    private static final Log _log = LogFactoryUtil.getLog(BankListingPortlet.class);

    public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String middleName = ParamUtil.getString(actionRequest, "middleName");
            String sex = ParamUtil.getString(actionRequest, "sex");

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date birthdayDate = ParamUtil.getDate(actionRequest, "birthdayDate", df);

            long positionId = ParamUtil.getLong(actionRequest, "positionId");
            Date employmentDate = ParamUtil.getDate(actionRequest, "employmentDate", df);
            String salary = ParamUtil.getString(actionRequest, "salary");
            String workPhone = ParamUtil.getString(actionRequest, "workPhone");
            String mobilePhone = ParamUtil.getString(actionRequest, "mobilePhone");
            long bankId = ParamUtil.getLong(actionRequest, "bankId");
            boolean isArchived = ParamUtil.getBoolean(actionRequest, "isArchived");

            long employeeId = CounterLocalServiceUtil.increment();

            Employee employee = EmployeeLocalServiceUtil.createEmployee(employeeId);

            employee.setLastName(lastName);
            employee.setFirstName(firstName);
            employee.setMiddleName(middleName);
            employee.setSex(sex);
            employee.setBirthdayDate(birthdayDate);
            employee.setPositionId(positionId);
            employee.setEmploymentDate(employmentDate);
            employee.setSalary(salary);
            employee.setWorkPhone(workPhone);
            employee.setMobilePhone(mobilePhone);
            employee.setBankId(bankId);
            employee.setIsArchived(isArchived);

            EmployeeLocalServiceUtil.addEmployee(employee);
        } catch (Exception e) {
            _log.error("called method addEmployee");
            e.printStackTrace();
        }
    }

    public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            long employeeId = ParamUtil.getLong(actionRequest, "employeeId");

            EmployeeLocalServiceUtil.deleteEmployee(employeeId);
        } catch (Exception e) {
            _log.error("called method deleteEmployee");
            e.printStackTrace();
        }
    }

    public void editEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String middleName = ParamUtil.getString(actionRequest, "middleName");
            String sex = ParamUtil.getString(actionRequest, "sex");

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date birthdayDate = ParamUtil.getDate(actionRequest, "birthdayDate", df);

            long positionId = ParamUtil.getLong(actionRequest, "positionId");
            Date employmentDate = ParamUtil.getDate(actionRequest, "employmentDate", df);
            String salary = ParamUtil.getString(actionRequest, "salary");
            String workPhone = ParamUtil.getString(actionRequest, "workPhone");
            String mobilePhone = ParamUtil.getString(actionRequest, "mobilePhone");
            long bankId = ParamUtil.getLong(actionRequest, "bankId");
            boolean isArchived = ParamUtil.getBoolean(actionRequest, "isArchived");

            Employee employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
            employee.setLastName(lastName);
            employee.setFirstName(firstName);
            employee.setMiddleName(middleName);
            employee.setSex(sex);
            employee.setBirthdayDate(birthdayDate);
            employee.setPositionId(positionId);
            employee.setEmploymentDate(employmentDate);
            employee.setSalary(salary);
            employee.setWorkPhone(workPhone);
            employee.setMobilePhone(mobilePhone);
            employee.setBankId(bankId);
            employee.setIsArchived(isArchived);

            EmployeeLocalServiceUtil.updateEmployee(employee);
        } catch (Exception e) {
            _log.error("called method editEmployee");
            e.printStackTrace();
        }
    }
}
