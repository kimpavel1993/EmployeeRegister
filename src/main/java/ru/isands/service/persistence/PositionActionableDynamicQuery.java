package ru.isands.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.isands.model.Position;

import ru.isands.service.PositionLocalServiceUtil;

/**
 * @author Joe Bloggs
 * @generated
 */
public abstract class PositionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PositionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PositionLocalServiceUtil.getService());
        setClass(Position.class);

        setClassLoader(ru.isands.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("positionId");
    }
}
