package ru.isands.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.isands.model.Position;

/**
 * The persistence interface for the position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Joe Bloggs
 * @see PositionPersistenceImpl
 * @see PositionUtil
 * @generated
 */
public interface PositionPersistence extends BasePersistence<Position> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PositionUtil} to access the position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the position in the entity cache if it is enabled.
    *
    * @param position the position
    */
    public void cacheResult(ru.isands.model.Position position);

    /**
    * Caches the positions in the entity cache if it is enabled.
    *
    * @param positions the positions
    */
    public void cacheResult(java.util.List<ru.isands.model.Position> positions);

    /**
    * Creates a new position with the primary key. Does not add the position to the database.
    *
    * @param positionId the primary key for the new position
    * @return the new position
    */
    public ru.isands.model.Position create(long positionId);

    /**
    * Removes the position with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param positionId the primary key of the position
    * @return the position that was removed
    * @throws ru.isands.NoSuchPositionException if a position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.model.Position remove(long positionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchPositionException;

    public ru.isands.model.Position updateImpl(
        ru.isands.model.Position position)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the position with the primary key or throws a {@link ru.isands.NoSuchPositionException} if it could not be found.
    *
    * @param positionId the primary key of the position
    * @return the position
    * @throws ru.isands.NoSuchPositionException if a position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.model.Position findByPrimaryKey(long positionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.NoSuchPositionException;

    /**
    * Returns the position with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param positionId the primary key of the position
    * @return the position, or <code>null</code> if a position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.model.Position fetchByPrimaryKey(long positionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the positions.
    *
    * @return the positions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.model.Position> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the positions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of positions
    * @param end the upper bound of the range of positions (not inclusive)
    * @return the range of positions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.model.Position> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the positions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of positions
    * @param end the upper bound of the range of positions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of positions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.model.Position> findAll(int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the positions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of positions.
    *
    * @return the number of positions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
