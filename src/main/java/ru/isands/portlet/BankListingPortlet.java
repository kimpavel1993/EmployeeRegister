package ru.isands.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.isands.model.Bank;
import ru.isands.service.BankLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;


public class BankListingPortlet extends MVCPortlet {
    private static final Log _log = LogFactoryUtil.getLog(BankListingPortlet.class);

    public void addBank(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            String name = ParamUtil.getString(actionRequest, "name");
            long bik = ParamUtil.getLong(actionRequest, "bik");
            String streetAddress = ParamUtil.getString(actionRequest, "streetAddress");

            long bankId = CounterLocalServiceUtil.increment();

            Bank bank = BankLocalServiceUtil.createBank(bankId);

            bank.setName(name);
            bank.setBik(bik);
            bank.setStreetAddress(streetAddress);

            BankLocalServiceUtil.addBank(bank);
        } catch (Exception e) {
            _log.error("called method addBank");
            e.printStackTrace();
        }
    }

    public void deleteBank(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            long bankId = ParamUtil.getLong(actionRequest, "bankId");

            BankLocalServiceUtil.deleteBank(bankId);
        } catch (Exception e) {
            _log.error("called method deleteBank");
            e.printStackTrace();
        }
    }

    public void editBank(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            long bankId = ParamUtil.getLong(actionRequest, "bankId");
            long bik = ParamUtil.getLong(actionRequest, "bik");
            String streetAddress = ParamUtil.getString(actionRequest, "streetAddress");

            Bank bank = BankLocalServiceUtil.getBank(bankId);
            bank.setBik(bik);
            bank.setStreetAddress(streetAddress);

            BankLocalServiceUtil.updateBank(bank);
        } catch (Exception e) {
            _log.error("called method editBank");
            e.printStackTrace();
        }
    }
}