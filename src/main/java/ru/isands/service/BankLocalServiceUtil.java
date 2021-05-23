package ru.isands.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Bank. This utility wraps
 * {@link ru.isands.service.impl.BankLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Joe Bloggs
 * @see BankLocalService
 * @see ru.isands.service.base.BankLocalServiceBaseImpl
 * @see ru.isands.service.impl.BankLocalServiceImpl
 * @generated
 */
public class BankLocalServiceUtil {
    private static BankLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ru.isands.service.impl.BankLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the bank to the database. Also notifies the appropriate model listeners.
    *
    * @param bank the bank
    * @return the bank that was added
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Bank addBank(ru.isands.model.Bank bank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addBank(bank);
    }

    /**
    * Creates a new bank with the primary key. Does not add the bank to the database.
    *
    * @param bankId the primary key for the new bank
    * @return the new bank
    */
    public static ru.isands.model.Bank createBank(long bankId) {
        return getService().createBank(bankId);
    }

    /**
    * Deletes the bank with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param bankId the primary key of the bank
    * @return the bank that was removed
    * @throws PortalException if a bank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Bank deleteBank(long bankId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteBank(bankId);
    }

    /**
    * Deletes the bank from the database. Also notifies the appropriate model listeners.
    *
    * @param bank the bank
    * @return the bank that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Bank deleteBank(ru.isands.model.Bank bank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteBank(bank);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.BankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.BankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static ru.isands.model.Bank fetchBank(long bankId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchBank(bankId);
    }

    /**
    * Returns the bank with the primary key.
    *
    * @param bankId the primary key of the bank
    * @return the bank
    * @throws PortalException if a bank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Bank getBank(long bankId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getBank(bankId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<ru.isands.model.Bank> getBanks(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBanks(start, end);
    }

    /**
    * Returns the number of banks.
    *
    * @return the number of banks
    * @throws SystemException if a system exception occurred
    */
    public static int getBanksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBanksCount();
    }

    /**
    * Updates the bank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param bank the bank
    * @return the bank that was updated
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.model.Bank updateBank(ru.isands.model.Bank bank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateBank(bank);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static BankLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    BankLocalService.class.getName());

            if (invokableLocalService instanceof BankLocalService) {
                _service = (BankLocalService) invokableLocalService;
            } else {
                _service = new BankLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(BankLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(BankLocalService service) {
    }
}
