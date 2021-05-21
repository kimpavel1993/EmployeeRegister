package ru.isands.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.isands.model.Bank;
import ru.isands.model.impl.BankImpl;
import ru.isands.service.BankLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.IOException;

public class BankListingPortlet extends MVCPortlet {
    public void addBank(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
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
            e.printStackTrace();
        }
    }

    public void deleteBank(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        try {
            long bankId = ParamUtil.getLong(actionRequest, "bankId");
            BankLocalServiceUtil.deleteBank(bankId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editBank(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        try {
            long bankId = ParamUtil.getLong(actionRequest, "bankId");
            long bik = ParamUtil.getLong(actionRequest, "bik");
            String streetAddress = ParamUtil.getString(actionRequest, "streetAddress");

            Bank bank = BankLocalServiceUtil.getBank(bankId);
            bank.setBik(bik);
            bank.setStreetAddress(streetAddress);

            BankLocalServiceUtil.updateBank(bank);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  /*  public void getBank(ActionRequest actionRequest,
                        ActionResponse actionResponse) throws IOException, PortletException {
        try {
            long bankId = ParamUtil.getLong(actionRequest, "bankId");
          BankLocalServiceUtil.getBank(bankId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}