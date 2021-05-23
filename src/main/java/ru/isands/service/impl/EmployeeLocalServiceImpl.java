package ru.isands.service.impl;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import ru.isands.model.Employee;
import ru.isands.portlet.BankListingPortlet;
import ru.isands.service.EmployeeLocalServiceUtil;
import ru.isands.service.base.EmployeeLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.isands.service.EmployeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Joe Bloggs
 * @see ru.isands.service.base.EmployeeLocalServiceBaseImpl
 * @see ru.isands.service.EmployeeLocalServiceUtil
 */
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
    private static final Log _log = LogFactoryUtil.getLog(BankListingPortlet.class);

    private Disjunction disjunction(String propertyName, List<String> names) {
        Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
        for (String e : names) {
            disjunction.add(RestrictionsFactoryUtil.ilike(propertyName, e));
        }

        return disjunction;
    }

    public List<Employee> findByName(List<String> name) {
        List<Employee> result = new ArrayList<Employee>();

        try {
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Employee.class);

            Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
            disjunction.add(disjunction("lastName", name));
            disjunction.add(disjunction("firstName", name));
            disjunction.add(disjunction("middleName", name));

            dynamicQuery.add(disjunction);

            result = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
        } catch (SystemException e) {
            _log.error("called method findByName");
            e.printStackTrace();
        }

        return result;
    }

    public List<Employee> findByDate(Date firstDate, Date lastDate) {
        List<Employee> result = new ArrayList<Employee>();

        try {
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Employee.class);
            dynamicQuery.add(RestrictionsFactoryUtil.between("birthdayDate", firstDate, lastDate));

            result = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
        } catch (SystemException e) {
            _log.error("called method findByDate");
            e.printStackTrace();
        }

        return result;
    }
}