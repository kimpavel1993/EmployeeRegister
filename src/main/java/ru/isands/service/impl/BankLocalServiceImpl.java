package ru.isands.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import ru.isands.model.Bank;
import ru.isands.service.BankLocalServiceUtil;
import ru.isands.service.base.BankLocalServiceBaseImpl;
import ru.isands.service.persistence.BankPersistence;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the bank local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.isands.service.BankLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Joe Bloggs
 * @see ru.isands.service.base.BankLocalServiceBaseImpl
 * @see ru.isands.service.BankLocalServiceUtil
 */
public class BankLocalServiceImpl extends BankLocalServiceBaseImpl {
    public Bank addBank(String name, long bik, String streetAddress,
            ServiceContext serviceContext) throws PortalException, SystemException {
        long bankId = counterLocalService.increment(Bank.class.getName());

        Bank bank = bankPersistence.create(bankId);

        bank.setName(name);
        bank.setBik(bik);
        bank.setStreetAddress(streetAddress);

        super.addBank(bank);

        return bank;
    }

    public Bank deleteBank(Bank bank) throws SystemException {
        return bankPersistence.remove(bank);
    }

    public Bank deleteBank(long bankId) throws PortalException, SystemException {
        Bank bank = bankPersistence.findByPrimaryKey(bankId);

        return deleteBank(bank);
    }

    public Bank getBank(long bankId) throws SystemException, PortalException {
        return bankPersistence.findByPrimaryKey(bankId);
    }

    public Bank updateBank(long bankId, long bik, String streetAddress,
            ServiceContext serviceContext) throws PortalException, SystemException {

        Bank bank = bankPersistence.findByPrimaryKey(bankId);

        bank.setBik(bik);
        bank.setStreetAddress(streetAddress);

        super.updateBank(bank);

        return bank;
    }
}