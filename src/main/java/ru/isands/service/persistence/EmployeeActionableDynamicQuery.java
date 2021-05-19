package ru.isands.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.isands.model.Employee;

import ru.isands.service.EmployeeLocalServiceUtil;

/**
 * @author Joe Bloggs
 * @generated
 */
public abstract class EmployeeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EmployeeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EmployeeLocalServiceUtil.getService());
        setClass(Employee.class);

        setClassLoader(ru.isands.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("employeeId");
    }
}
