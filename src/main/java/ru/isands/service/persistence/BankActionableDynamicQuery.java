package ru.isands.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.isands.model.Bank;

import ru.isands.service.BankLocalServiceUtil;

/**
 * @author Joe Bloggs
 * @generated
 */
public abstract class BankActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public BankActionableDynamicQuery() throws SystemException {
        setBaseLocalService(BankLocalServiceUtil.getService());
        setClass(Bank.class);

        setClassLoader(ru.isands.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("bankId");
    }
}
