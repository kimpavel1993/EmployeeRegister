package ru.isands.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.isands.NoSuchEmployeeException;

import ru.isands.model.Employee;
import ru.isands.model.impl.EmployeeImpl;
import ru.isands.model.impl.EmployeeModelImpl;

import ru.isands.service.persistence.EmployeePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Joe Bloggs
 * @see EmployeePersistence
 * @see EmployeeUtil
 * @generated
 */
public class EmployeePersistenceImpl extends BasePersistenceImpl<Employee>
    implements EmployeePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EmployeeUtil} to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EmployeeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BANKID = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBankId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANKID =
        new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBankId",
            new String[] { Long.class.getName() },
            EmployeeModelImpl.BANKID_COLUMN_BITMASK |
            EmployeeModelImpl.LASTNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BANKID = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBankId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_BANKID_BANKID_2 = "employee.bankId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONID =
        new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPositionId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID =
        new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPositionId",
            new String[] { Long.class.getName() },
            EmployeeModelImpl.POSITIONID_COLUMN_BITMASK |
            EmployeeModelImpl.LASTNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONID = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPositionId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_POSITIONID_POSITIONID_2 = "employee.positionId = ?";
    private static final String _SQL_SELECT_EMPLOYEE = "SELECT employee FROM Employee employee";
    private static final String _SQL_SELECT_EMPLOYEE_WHERE = "SELECT employee FROM Employee employee WHERE ";
    private static final String _SQL_COUNT_EMPLOYEE = "SELECT COUNT(employee) FROM Employee employee";
    private static final String _SQL_COUNT_EMPLOYEE_WHERE = "SELECT COUNT(employee) FROM Employee employee WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "employee.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Employee exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Employee exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EmployeePersistenceImpl.class);
    private static Employee _nullEmployee = new EmployeeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Employee> toCacheModel() {
                return _nullEmployeeCacheModel;
            }
        };

    private static CacheModel<Employee> _nullEmployeeCacheModel = new CacheModel<Employee>() {
            @Override
            public Employee toEntityModel() {
                return _nullEmployee;
            }
        };

    public EmployeePersistenceImpl() {
        setModelClass(Employee.class);
    }

    /**
     * Returns all the employees where bankId = &#63;.
     *
     * @param bankId the bank ID
     * @return the matching employees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Employee> findByBankId(long bankId) throws SystemException {
        return findByBankId(bankId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Employee> findByBankId(long bankId, int start, int end)
        throws SystemException {
        return findByBankId(bankId, start, end, null);
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
    @Override
    public List<Employee> findByBankId(long bankId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANKID;
            finderArgs = new Object[] { bankId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BANKID;
            finderArgs = new Object[] { bankId, start, end, orderByComparator };
        }

        List<Employee> list = (List<Employee>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Employee employee : list) {
                if ((bankId != employee.getBankId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EMPLOYEE_WHERE);

            query.append(_FINDER_COLUMN_BANKID_BANKID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EmployeeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bankId);

                if (!pagination) {
                    list = (List<Employee>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Employee>(list);
                } else {
                    list = (List<Employee>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Employee findByBankId_First(long bankId,
        OrderByComparator orderByComparator)
        throws NoSuchEmployeeException, SystemException {
        Employee employee = fetchByBankId_First(bankId, orderByComparator);

        if (employee != null) {
            return employee;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bankId=");
        msg.append(bankId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEmployeeException(msg.toString());
    }

    /**
     * Returns the first employee in the ordered set where bankId = &#63;.
     *
     * @param bankId the bank ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching employee, or <code>null</code> if a matching employee could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee fetchByBankId_First(long bankId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Employee> list = findByBankId(bankId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Employee findByBankId_Last(long bankId,
        OrderByComparator orderByComparator)
        throws NoSuchEmployeeException, SystemException {
        Employee employee = fetchByBankId_Last(bankId, orderByComparator);

        if (employee != null) {
            return employee;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("bankId=");
        msg.append(bankId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEmployeeException(msg.toString());
    }

    /**
     * Returns the last employee in the ordered set where bankId = &#63;.
     *
     * @param bankId the bank ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching employee, or <code>null</code> if a matching employee could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee fetchByBankId_Last(long bankId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByBankId(bankId);

        if (count == 0) {
            return null;
        }

        List<Employee> list = findByBankId(bankId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Employee[] findByBankId_PrevAndNext(long employeeId, long bankId,
        OrderByComparator orderByComparator)
        throws NoSuchEmployeeException, SystemException {
        Employee employee = findByPrimaryKey(employeeId);

        Session session = null;

        try {
            session = openSession();

            Employee[] array = new EmployeeImpl[3];

            array[0] = getByBankId_PrevAndNext(session, employee, bankId,
                    orderByComparator, true);

            array[1] = employee;

            array[2] = getByBankId_PrevAndNext(session, employee, bankId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Employee getByBankId_PrevAndNext(Session session,
        Employee employee, long bankId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EMPLOYEE_WHERE);

        query.append(_FINDER_COLUMN_BANKID_BANKID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EmployeeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(bankId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(employee);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Employee> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the employees where bankId = &#63; from the database.
     *
     * @param bankId the bank ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByBankId(long bankId) throws SystemException {
        for (Employee employee : findByBankId(bankId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(employee);
        }
    }

    /**
     * Returns the number of employees where bankId = &#63;.
     *
     * @param bankId the bank ID
     * @return the number of matching employees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByBankId(long bankId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_BANKID;

        Object[] finderArgs = new Object[] { bankId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EMPLOYEE_WHERE);

            query.append(_FINDER_COLUMN_BANKID_BANKID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bankId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the employees where positionId = &#63;.
     *
     * @param positionId the position ID
     * @return the matching employees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Employee> findByPositionId(long positionId)
        throws SystemException {
        return findByPositionId(positionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Employee> findByPositionId(long positionId, int start, int end)
        throws SystemException {
        return findByPositionId(positionId, start, end, null);
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
    @Override
    public List<Employee> findByPositionId(long positionId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID;
            finderArgs = new Object[] { positionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONID;
            finderArgs = new Object[] { positionId, start, end, orderByComparator };
        }

        List<Employee> list = (List<Employee>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Employee employee : list) {
                if ((positionId != employee.getPositionId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EMPLOYEE_WHERE);

            query.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EmployeeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(positionId);

                if (!pagination) {
                    list = (List<Employee>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Employee>(list);
                } else {
                    list = (List<Employee>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Employee findByPositionId_First(long positionId,
        OrderByComparator orderByComparator)
        throws NoSuchEmployeeException, SystemException {
        Employee employee = fetchByPositionId_First(positionId,
                orderByComparator);

        if (employee != null) {
            return employee;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("positionId=");
        msg.append(positionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEmployeeException(msg.toString());
    }

    /**
     * Returns the first employee in the ordered set where positionId = &#63;.
     *
     * @param positionId the position ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching employee, or <code>null</code> if a matching employee could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee fetchByPositionId_First(long positionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Employee> list = findByPositionId(positionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Employee findByPositionId_Last(long positionId,
        OrderByComparator orderByComparator)
        throws NoSuchEmployeeException, SystemException {
        Employee employee = fetchByPositionId_Last(positionId, orderByComparator);

        if (employee != null) {
            return employee;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("positionId=");
        msg.append(positionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEmployeeException(msg.toString());
    }

    /**
     * Returns the last employee in the ordered set where positionId = &#63;.
     *
     * @param positionId the position ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching employee, or <code>null</code> if a matching employee could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee fetchByPositionId_Last(long positionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPositionId(positionId);

        if (count == 0) {
            return null;
        }

        List<Employee> list = findByPositionId(positionId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Employee[] findByPositionId_PrevAndNext(long employeeId,
        long positionId, OrderByComparator orderByComparator)
        throws NoSuchEmployeeException, SystemException {
        Employee employee = findByPrimaryKey(employeeId);

        Session session = null;

        try {
            session = openSession();

            Employee[] array = new EmployeeImpl[3];

            array[0] = getByPositionId_PrevAndNext(session, employee,
                    positionId, orderByComparator, true);

            array[1] = employee;

            array[2] = getByPositionId_PrevAndNext(session, employee,
                    positionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Employee getByPositionId_PrevAndNext(Session session,
        Employee employee, long positionId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EMPLOYEE_WHERE);

        query.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EmployeeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(positionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(employee);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Employee> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the employees where positionId = &#63; from the database.
     *
     * @param positionId the position ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPositionId(long positionId) throws SystemException {
        for (Employee employee : findByPositionId(positionId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(employee);
        }
    }

    /**
     * Returns the number of employees where positionId = &#63;.
     *
     * @param positionId the position ID
     * @return the number of matching employees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPositionId(long positionId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITIONID;

        Object[] finderArgs = new Object[] { positionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EMPLOYEE_WHERE);

            query.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(positionId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the employee in the entity cache if it is enabled.
     *
     * @param employee the employee
     */
    @Override
    public void cacheResult(Employee employee) {
        EntityCacheUtil.putResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeImpl.class, employee.getPrimaryKey(), employee);

        employee.resetOriginalValues();
    }

    /**
     * Caches the employees in the entity cache if it is enabled.
     *
     * @param employees the employees
     */
    @Override
    public void cacheResult(List<Employee> employees) {
        for (Employee employee : employees) {
            if (EntityCacheUtil.getResult(
                        EmployeeModelImpl.ENTITY_CACHE_ENABLED,
                        EmployeeImpl.class, employee.getPrimaryKey()) == null) {
                cacheResult(employee);
            } else {
                employee.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all employees.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EmployeeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EmployeeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the employee.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Employee employee) {
        EntityCacheUtil.removeResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeImpl.class, employee.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Employee> employees) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Employee employee : employees) {
            EntityCacheUtil.removeResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
                EmployeeImpl.class, employee.getPrimaryKey());
        }
    }

    /**
     * Creates a new employee with the primary key. Does not add the employee to the database.
     *
     * @param employeeId the primary key for the new employee
     * @return the new employee
     */
    @Override
    public Employee create(long employeeId) {
        Employee employee = new EmployeeImpl();

        employee.setNew(true);
        employee.setPrimaryKey(employeeId);

        return employee;
    }

    /**
     * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param employeeId the primary key of the employee
     * @return the employee that was removed
     * @throws ru.isands.NoSuchEmployeeException if a employee with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee remove(long employeeId)
        throws NoSuchEmployeeException, SystemException {
        return remove((Serializable) employeeId);
    }

    /**
     * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the employee
     * @return the employee that was removed
     * @throws ru.isands.NoSuchEmployeeException if a employee with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee remove(Serializable primaryKey)
        throws NoSuchEmployeeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Employee employee = (Employee) session.get(EmployeeImpl.class,
                    primaryKey);

            if (employee == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEmployeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(employee);
        } catch (NoSuchEmployeeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Employee removeImpl(Employee employee) throws SystemException {
        employee = toUnwrappedModel(employee);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(employee)) {
                employee = (Employee) session.get(EmployeeImpl.class,
                        employee.getPrimaryKeyObj());
            }

            if (employee != null) {
                session.delete(employee);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (employee != null) {
            clearCache(employee);
        }

        return employee;
    }

    @Override
    public Employee updateImpl(ru.isands.model.Employee employee)
        throws SystemException {
        employee = toUnwrappedModel(employee);

        boolean isNew = employee.isNew();

        EmployeeModelImpl employeeModelImpl = (EmployeeModelImpl) employee;

        Session session = null;

        try {
            session = openSession();

            if (employee.isNew()) {
                session.save(employee);

                employee.setNew(false);
            } else {
                session.merge(employee);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EmployeeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((employeeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANKID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        employeeModelImpl.getOriginalBankId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BANKID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANKID,
                    args);

                args = new Object[] { employeeModelImpl.getBankId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BANKID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BANKID,
                    args);
            }

            if ((employeeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        employeeModelImpl.getOriginalPositionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSITIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID,
                    args);

                args = new Object[] { employeeModelImpl.getPositionId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSITIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID,
                    args);
            }
        }

        EntityCacheUtil.putResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
            EmployeeImpl.class, employee.getPrimaryKey(), employee);

        return employee;
    }

    protected Employee toUnwrappedModel(Employee employee) {
        if (employee instanceof EmployeeImpl) {
            return employee;
        }

        EmployeeImpl employeeImpl = new EmployeeImpl();

        employeeImpl.setNew(employee.isNew());
        employeeImpl.setPrimaryKey(employee.getPrimaryKey());

        employeeImpl.setEmployeeId(employee.getEmployeeId());
        employeeImpl.setLastName(employee.getLastName());
        employeeImpl.setFirstName(employee.getFirstName());
        employeeImpl.setMiddleName(employee.getMiddleName());
        employeeImpl.setSex(employee.getSex());
        employeeImpl.setBirthdayDate(employee.getBirthdayDate());
        employeeImpl.setPositionId(employee.getPositionId());
        employeeImpl.setEmploymentDate(employee.getEmploymentDate());
        employeeImpl.setSalary(employee.getSalary());
        employeeImpl.setWorkPhone(employee.getWorkPhone());
        employeeImpl.setMobilePhone(employee.getMobilePhone());
        employeeImpl.setBankId(employee.getBankId());
        employeeImpl.setIsArchived(employee.getIsArchived());

        return employeeImpl;
    }

    /**
     * Returns the employee with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the employee
     * @return the employee
     * @throws ru.isands.NoSuchEmployeeException if a employee with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEmployeeException, SystemException {
        Employee employee = fetchByPrimaryKey(primaryKey);

        if (employee == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEmployeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return employee;
    }

    /**
     * Returns the employee with the primary key or throws a {@link ru.isands.NoSuchEmployeeException} if it could not be found.
     *
     * @param employeeId the primary key of the employee
     * @return the employee
     * @throws ru.isands.NoSuchEmployeeException if a employee with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee findByPrimaryKey(long employeeId)
        throws NoSuchEmployeeException, SystemException {
        return findByPrimaryKey((Serializable) employeeId);
    }

    /**
     * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the employee
     * @return the employee, or <code>null</code> if a employee with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Employee employee = (Employee) EntityCacheUtil.getResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
                EmployeeImpl.class, primaryKey);

        if (employee == _nullEmployee) {
            return null;
        }

        if (employee == null) {
            Session session = null;

            try {
                session = openSession();

                employee = (Employee) session.get(EmployeeImpl.class, primaryKey);

                if (employee != null) {
                    cacheResult(employee);
                } else {
                    EntityCacheUtil.putResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
                        EmployeeImpl.class, primaryKey, _nullEmployee);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
                    EmployeeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return employee;
    }

    /**
     * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param employeeId the primary key of the employee
     * @return the employee, or <code>null</code> if a employee with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Employee fetchByPrimaryKey(long employeeId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) employeeId);
    }

    /**
     * Returns all the employees.
     *
     * @return the employees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Employee> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Employee> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Employee> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Employee> list = (List<Employee>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EMPLOYEE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EMPLOYEE;

                if (pagination) {
                    sql = sql.concat(EmployeeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Employee>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Employee>(list);
                } else {
                    list = (List<Employee>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the employees from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Employee employee : findAll()) {
            remove(employee);
        }
    }

    /**
     * Returns the number of employees.
     *
     * @return the number of employees
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_EMPLOYEE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the employee persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.isands.model.Employee")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Employee>> listenersList = new ArrayList<ModelListener<Employee>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Employee>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EmployeeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
