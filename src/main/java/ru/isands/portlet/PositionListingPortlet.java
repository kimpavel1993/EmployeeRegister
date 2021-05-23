package ru.isands.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.isands.model.Position;
import ru.isands.service.PositionLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

public class PositionListingPortlet extends MVCPortlet {
    private static final Log _log = LogFactoryUtil.getLog(BankListingPortlet.class);

    public void addPosition(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            String name = ParamUtil.getString(actionRequest, "name");
            boolean isArchived = ParamUtil.getBoolean(actionRequest, "isArchived");

            long positionId = CounterLocalServiceUtil.increment();

            Position position = PositionLocalServiceUtil.createPosition(positionId);

            position.setName(name);
            position.setIsArchived(isArchived);

            PositionLocalServiceUtil.addPosition(position);
        } catch (Exception e) {
            _log.error("called method addPosition");
            e.printStackTrace();
        }
    }

    public void deletePosition(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            long positionId = ParamUtil.getLong(actionRequest, "positionId");
            PositionLocalServiceUtil.deletePosition(positionId);
        } catch (Exception e) {
            _log.error("called method deletePosition");
            e.printStackTrace();
        }
    }

    public void editPosition(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            long positionId = ParamUtil.getLong(actionRequest, "positionId");
            String name = ParamUtil.getString(actionRequest, "name");
            boolean isArchived = ParamUtil.getBoolean(actionRequest, "isArchived");

            Position position = PositionLocalServiceUtil.getPosition(positionId);
            position.setName(name);
            position.setIsArchived(isArchived);

            PositionLocalServiceUtil.updatePosition(position);
        } catch (Exception e) {
            _log.error("called method editPosition");
            e.printStackTrace();
        }
    }
}
