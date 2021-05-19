package ru.isands.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.isands.model.Bank;
import ru.isands.service.BankLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

public class BankListingPortlet extends MVCPortlet {
        public void addBank(ActionRequest request, ActionResponse response) throws Exception {
            _updateBank(request);

            sendRedirect(request, response);
        }

        public void deleteBank(ActionRequest request, ActionResponse response) throws Exception {
            long bankId = ParamUtil.getLong(request, "bankId");

            BankLocalServiceUtil.deleteBank(bankId);

            sendRedirect(request, response);
        }

        public void updateBank(ActionRequest request, ActionResponse response) throws Exception {
            _updateBank(request);

            sendRedirect(request, response);
        }

        private Bank _updateBank(ActionRequest request) throws PortalException, SystemException {
            long bankId = ParamUtil.getLong(request, "bankId");
            String name = ParamUtil.getString(request, "name");
            long bik = ParamUtil.getLong(request, "bik");
            String streetAddress = ParamUtil.getString(request, "streetAddress");

            ServiceContext serviceContext = ServiceContextFactory.getInstance(Bank.class.getName(), request);

            Bank bank = null;

            if (bankId <= 0) {
                bank = BankLocalServiceUtil.addBank(name, bik, streetAddress, serviceContext);
            } else {
                bank = BankLocalServiceUtil.getBank(bankId);

                bank = BankLocalServiceUtil.updateBank(bankId, bik, streetAddress, serviceContext);
            }

            return bank;
        }
    }