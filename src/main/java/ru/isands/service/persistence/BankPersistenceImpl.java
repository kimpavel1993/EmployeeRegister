package ru.isands.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.isands.NoSuchBankException;

import ru.isands.model.Bank;
import ru.isands.model.impl.BankImpl;
import ru.isands.model.impl.BankModelImpl;

import ru.isands.service.persistence.BankPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the bank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Joe Bloggs
 * @see BankPersistence
 * @see BankUtil
 * @generated
 */
public class BankPersistenceImpl extends BasePersistenceImpl<Bank>
    implements BankPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BankUtil} to access the bank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BankImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BankModelImpl.ENTITY_CACHE_ENABLED,
            BankModelImpl.FINDER_CACHE_ENABLED, BankImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BankModelImpl.ENTITY_CACHE_ENABLED,
            BankModelImpl.FINDER_CACHE_ENABLED, BankImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BankModelImpl.ENTITY_CACHE_ENABLED,
            BankModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_BANK = "SELECT bank FROM Bank bank";
    private static final String _SQL_COUNT_BANK = "SELECT COUNT(bank) FROM Bank bank";
    private static final String _ORDER_BY_ENTITY_ALIAS = "bank.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Bank exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BankPersistenceImpl.class);
    private static Bank _nullBank = new BankImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Bank> toCacheModel() {
                return _nullBankCacheModel;
            }
        };

    private static CacheModel<Bank> _nullBankCacheModel = new CacheModel<Bank>() {
            @Override
            public Bank toEntityModel() {
                return _nullBank;
            }
        };

    public BankPersistenceImpl() {
        setModelClass(Bank.class);
    }

    /**
     * Caches the bank in the entity cache if it is enabled.
     *
     * @param bank the bank
     */
    @Override
    public void cacheResult(Bank bank) {
        EntityCacheUtil.putResult(BankModelImpl.ENTITY_CACHE_ENABLED,
            BankImpl.class, bank.getPrimaryKey(), bank);

        bank.resetOriginalValues();
    }

    /**
     * Caches the banks in the entity cache if it is enabled.
     *
     * @param banks the banks
     */
    @Override
    public void cacheResult(List<Bank> banks) {
        for (Bank bank : banks) {
            if (EntityCacheUtil.getResult(BankModelImpl.ENTITY_CACHE_ENABLED,
                        BankImpl.class, bank.getPrimaryKey()) == null) {
                cacheResult(bank);
            } else {
                bank.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all banks.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BankImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BankImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the bank.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Bank bank) {
        EntityCacheUtil.removeResult(BankModelImpl.ENTITY_CACHE_ENABLED,
            BankImpl.class, bank.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Bank> banks) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Bank bank : banks) {
            EntityCacheUtil.removeResult(BankModelImpl.ENTITY_CACHE_ENABLED,
                BankImpl.class, bank.getPrimaryKey());
        }
    }

    /**
     * Creates a new bank with the primary key. Does not add the bank to the database.
     *
     * @param bankId the primary key for the new bank
     * @return the new bank
     */
    @Override
    public Bank create(long bankId) {
        Bank bank = new BankImpl();

        bank.setNew(true);
        bank.setPrimaryKey(bankId);

        return bank;
    }

    /**
     * Removes the bank with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param bankId the primary key of the bank
     * @return the bank that was removed
     * @throws ru.isands.NoSuchBankException if a bank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bank remove(long bankId) throws NoSuchBankException, SystemException {
        return remove((Serializable) bankId);
    }

    /**
     * Removes the bank with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the bank
     * @return the bank that was removed
     * @throws ru.isands.NoSuchBankException if a bank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bank remove(Serializable primaryKey)
        throws NoSuchBankException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Bank bank = (Bank) session.get(BankImpl.class, primaryKey);

            if (bank == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(bank);
        } catch (NoSuchBankException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Bank removeImpl(Bank bank) throws SystemException {
        bank = toUnwrappedModel(bank);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(bank)) {
                bank = (Bank) session.get(BankImpl.class,
                        bank.getPrimaryKeyObj());
            }

            if (bank != null) {
                session.delete(bank);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (bank != null) {
            clearCache(bank);
        }

        return bank;
    }

    @Override
    public Bank updateImpl(ru.isands.model.Bank bank) throws SystemException {
        bank = toUnwrappedModel(bank);

        boolean isNew = bank.isNew();

        Session session = null;

        try {
            session = openSession();

            if (bank.isNew()) {
                session.save(bank);

                bank.setNew(false);
            } else {
                session.merge(bank);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(BankModelImpl.ENTITY_CACHE_ENABLED,
            BankImpl.class, bank.getPrimaryKey(), bank);

        return bank;
    }

    protected Bank toUnwrappedModel(Bank bank) {
        if (bank instanceof BankImpl) {
            return bank;
        }

        BankImpl bankImpl = new BankImpl();

        bankImpl.setNew(bank.isNew());
        bankImpl.setPrimaryKey(bank.getPrimaryKey());

        bankImpl.setBankId(bank.getBankId());
        bankImpl.setName(bank.getName());
        bankImpl.setBik(bank.getBik());
        bankImpl.setStreetAddress(bank.getStreetAddress());

        return bankImpl;
    }

    /**
     * Returns the bank with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the bank
     * @return the bank
     * @throws ru.isands.NoSuchBankException if a bank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bank findByPrimaryKey(Serializable primaryKey)
        throws NoSuchBankException, SystemException {
        Bank bank = fetchByPrimaryKey(primaryKey);

        if (bank == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchBankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return bank;
    }

    /**
     * Returns the bank with the primary key or throws a {@link ru.isands.NoSuchBankException} if it could not be found.
     *
     * @param bankId the primary key of the bank
     * @return the bank
     * @throws ru.isands.NoSuchBankException if a bank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bank findByPrimaryKey(long bankId)
        throws NoSuchBankException, SystemException {
        return findByPrimaryKey((Serializable) bankId);
    }

    /**
     * Returns the bank with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the bank
     * @return the bank, or <code>null</code> if a bank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bank fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Bank bank = (Bank) EntityCacheUtil.getResult(BankModelImpl.ENTITY_CACHE_ENABLED,
                BankImpl.class, primaryKey);

        if (bank == _nullBank) {
            return null;
        }

        if (bank == null) {
            Session session = null;

            try {
                session = openSession();

                bank = (Bank) session.get(BankImpl.class, primaryKey);

                if (bank != null) {
                    cacheResult(bank);
                } else {
                    EntityCacheUtil.putResult(BankModelImpl.ENTITY_CACHE_ENABLED,
                        BankImpl.class, primaryKey, _nullBank);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(BankModelImpl.ENTITY_CACHE_ENABLED,
                    BankImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return bank;
    }

    /**
     * Returns the bank with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param bankId the primary key of the bank
     * @return the bank, or <code>null</code> if a bank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Bank fetchByPrimaryKey(long bankId) throws SystemException {
        return fetchByPrimaryKey((Serializable) bankId);
    }

    /**
     * Returns all the banks.
     *
     * @return the banks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bank> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the banks.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.BankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of banks
     * @param end the upper bound of the range of banks (not inclusive)
     * @return the range of banks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bank> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the banks.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.BankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of banks
     * @param end the upper bound of the range of banks (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of banks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Bank> findAll(int start, int end,
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

        List<Bank> list = (List<Bank>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BANK);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BANK;

                if (pagination) {
                    sql = sql.concat(BankModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Bank>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Bank>(list);
                } else {
                    list = (List<Bank>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the banks from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Bank bank : findAll()) {
            remove(bank);
        }
    }

    /**
     * Returns the number of banks.
     *
     * @return the number of banks
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

                Query q = session.createQuery(_SQL_COUNT_BANK);

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
     * Initializes the bank persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.isands.model.Bank")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Bank>> listenersList = new ArrayList<ModelListener<Bank>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Bank>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BankImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
