package ru.isands.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.isands.model.Employee;

import java.util.List;

/**
 * The persistence utility for the employee service. This utility wraps {@link EmployeePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Joe Bloggs
 * @see EmployeePersistence
 * @see EmployeePersistenceImpl
 * @generated
 */
public class EmployeeUtil {
    private static EmployeePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Employee employee) {
        getPersistence().clearCache(employee);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Employee> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Employee> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Employee> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Employee update(Employee employee) throws SystemException {
        return getPersistence().update(employee);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Employee update(Employee employee,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(employee, serviceContext);
    }

    /**
    * Returns all the employees where bankId = &#63;.
    *
    * @param bankId the bank ID
    * @return the matching employees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.model.Employee> findByBankId(
        long bankId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByBankId(bankId);
    }

    /**
    * Returns a range of all the employees where bankId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bankId the bank ID
    * @param start the lower bound of the range of employees
    * @param end the upper bound of the range of employees (not inclusive)
    * @return the range of matching employees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.model.Employee> findByBankId(
        long bankId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByBankId(bankId, start, end);
    }

    /**
    * Returns an ordered range of all the employees where bankId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param bankId the bank ID
    * @param start the lower bound of the range of employees
    * @param end the upper bound of the range of employees (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching employees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.model.Employee> findByBankId(
        long bankId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByBankId(bankId, start, end, orderByComparator);
    }

    /**
    * Returns the first employee in the ordered set where bankId = &#63;.
    *
    * @param bankId the bank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching employee
    * @throws ru.isands.NoSuchEmployeeException if a matching employee could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee findByBankId_First(long bankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchEmployeeException {
        return getPersistence().findByBankId_First(bankId, orderByComparator);
    }

    /**
    * Returns the first employee in the ordered set where bankId = &#63;.
    *
    * @param bankId the bank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching employee, or <code>null</code> if a matching employee could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee fetchByBankId_First(long bankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByBankId_First(bankId, orderByComparator);
    }

    /**
    * Returns the last employee in the ordered set where bankId = &#63;.
    *
    * @param bankId the bank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching employee
    * @throws ru.isands.NoSuchEmployeeException if a matching employee could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee findByBankId_Last(long bankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchEmployeeException {
        return getPersistence().findByBankId_Last(bankId, orderByComparator);
    }

    /**
    * Returns the last employee in the ordered set where bankId = &#63;.
    *
    * @param bankId the bank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching employee, or <code>null</code> if a matching employee could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee fetchByBankId_Last(long bankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByBankId_Last(bankId, orderByComparator);
    }

    /**
    * Returns the employees before and after the current employee in the ordered set where bankId = &#63;.
    *
    * @param employeeId the primary key of the current employee
    * @param bankId the bank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next employee
    * @throws ru.isands.NoSuchEmployeeException if a employee with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee[] findByBankId_PrevAndNext(
        long employeeId, long bankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchEmployeeException {
        return getPersistence()
                   .findByBankId_PrevAndNext(employeeId, bankId,
            orderByComparator);
    }

    /**
    * Removes all the employees where bankId = &#63; from the database.
    *
    * @param bankId the bank ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByBankId(long bankId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByBankId(bankId);
    }

    /**
    * Returns the number of employees where bankId = &#63;.
    *
    * @param bankId the bank ID
    * @return the number of matching employees
    * @throws SystemException if a system exception occurred
    */
    public static int countByBankId(long bankId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByBankId(bankId);
    }

    /**
    * Returns all the employees where positionId = &#63;.
    *
    * @param positionId the position ID
    * @return the matching employees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.model.Employee> findByPositionId(
        long positionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPositionId(positionId);
    }

    /**
    * Returns a range of all the employees where positionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param positionId the position ID
    * @param start the lower bound of the range of employees
    * @param end the upper bound of the range of employees (not inclusive)
    * @return the range of matching employees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.model.Employee> findByPositionId(
        long positionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPositionId(positionId, start, end);
    }

    /**
    * Returns an ordered range of all the employees where positionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param positionId the position ID
    * @param start the lower bound of the range of employees
    * @param end the upper bound of the range of employees (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching employees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.model.Employee> findByPositionId(
        long positionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPositionId(positionId, start, end, orderByComparator);
    }

    /**
    * Returns the first employee in the ordered set where positionId = &#63;.
    *
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching employee
    * @throws ru.isands.NoSuchEmployeeException if a matching employee could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee findByPositionId_First(
        long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchEmployeeException {
        return getPersistence()
                   .findByPositionId_First(positionId, orderByComparator);
    }

    /**
    * Returns the first employee in the ordered set where positionId = &#63;.
    *
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching employee, or <code>null</code> if a matching employee could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee fetchByPositionId_First(
        long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPositionId_First(positionId, orderByComparator);
    }

    /**
    * Returns the last employee in the ordered set where positionId = &#63;.
    *
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching employee
    * @throws ru.isands.NoSuchEmployeeException if a matching employee could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee findByPositionId_Last(
        long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchEmployeeException {
        return getPersistence()
                   .findByPositionId_Last(positionId, orderByComparator);
    }

    /**
    * Returns the last employee in the ordered set where positionId = &#63;.
    *
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching employee, or <code>null</code> if a matching employee could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee fetchByPositionId_Last(
        long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPositionId_Last(positionId, orderByComparator);
    }

    /**
    * Returns the employees before and after the current employee in the ordered set where positionId = &#63;.
    *
    * @param employeeId the primary key of the current employee
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next employee
    * @throws ru.isands.NoSuchEmployeeException if a employee with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee[] findByPositionId_PrevAndNext(
        long employeeId, long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchEmployeeException {
        return getPersistence()
                   .findByPositionId_PrevAndNext(employeeId, positionId,
            orderByComparator);
    }

    /**
    * Removes all the employees where positionId = &#63; from the database.
    *
    * @param positionId the position ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPositionId(long positionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPositionId(positionId);
    }

    /**
    * Returns the number of employees where positionId = &#63;.
    *
    * @param positionId the position ID
    * @return the number of matching employees
    * @throws SystemException if a system exception occurred
    */
    public static int countByPositionId(long positionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPositionId(positionId);
    }

    /**
    * Caches the employee in the entity cache if it is enabled.
    *
    * @param employee the employee
    */
    public static void cacheResult(ru.isands.model.Employee employee) {
        getPersistence().cacheResult(employee);
    }

    /**
    * Caches the employees in the entity cache if it is enabled.
    *
    * @param employees the employees
    */
    public static void cacheResult(
        java.util.List<ru.isands.model.Employee> employees) {
        getPersistence().cacheResult(employees);
    }

    /**
    * Creates a new employee with the primary key. Does not add the employee to the database.
    *
    * @param employeeId the primary key for the new employee
    * @return the new employee
    */
    public static ru.isands.model.Employee create(long employeeId) {
        return getPersistence().create(employeeId);
    }

    /**
    * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param employeeId the primary key of the employee
    * @return the employee that was removed
    * @throws ru.isands.NoSuchEmployeeException if a employee with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee remove(long employeeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchEmployeeException {
        return getPersistence().remove(employeeId);
    }

    public static ru.isands.model.Employee updateImpl(
        ru.isands.model.Employee employee)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(employee);
    }

    /**
    * Returns the employee with the primary key or throws a {@link ru.isands.NoSuchEmployeeException} if it could not be found.
    *
    * @param employeeId the primary key of the employee
    * @return the employee
    * @throws ru.isands.NoSuchEmployeeException if a employee with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee findByPrimaryKey(long employeeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchEmployeeException {
        return getPersistence().findByPrimaryKey(employeeId);
    }

    /**
    * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param employeeId the primary key of the employee
    * @return the employee, or <code>null</code> if a employee with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Employee fetchByPrimaryKey(long employeeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(employeeId);
    }

    /**
    * Returns all the employees.
    *
    * @return the employees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.model.Employee> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the employees.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of employees
    * @param end the upper bound of the range of employees (not inclusive)
    * @return the range of employees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.model.Employee> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the employees.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of employees
    * @param end the upper bound of the range of employees (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of employees
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.model.Employee> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the employees from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of employees.
    *
    * @return the number of employees
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EmployeePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EmployeePersistence) PortletBeanLocatorUtil.locate(ru.isands.service.ClpSerializer.getServletContextName(),
                    EmployeePersistence.class.getName());

            ReferenceRegistry.registerReference(EmployeeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(EmployeePersistence persistence) {
    }
}
