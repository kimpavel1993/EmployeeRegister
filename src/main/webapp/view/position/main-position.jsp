<%@ page import="java.util.List" %>
<%@ page import="ru.isands.model.Position" %>
<%@ page import="ru.isands.service.PositionLocalServiceUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects/>

<% List<Position> list = PositionLocalServiceUtil.getPositions(0, PositionLocalServiceUtil.getPositionsCount()); %>
<liferay-ui:search-container>
    <liferay-ui:search-container-results
            results="<%= PositionLocalServiceUtil.getPositions(searchContainer.getStart(), searchContainer.getEnd()) %>"
            total="<%=PositionLocalServiceUtil.getPositionsCount()%>"/>


    <liferay-ui:search-container-row className="ru.isands.model.Position" modelVar="position">
        <liferay-ui:search-container-column-text property="name"/>
        <liferay-ui:search-container-column-text property="isArchived"/>
        <liferay-ui:search-container-column-text>
            <liferay-ui:icon-menu>
                <portlet:renderURL var="editPositionURL">
                    <portlet:param name="positionId" value="<%= String.valueOf(position.getPositionId()) %>"/>
                    <portlet:param name="mvcPath" value="/view/position/edit-position.jsp"/>
                </portlet:renderURL>

                <liferay-ui:icon iconCssClass="icon-edit" message="Edit" url="<%= editPositionURL %>" />

                <portlet:actionURL name="deletePosition"  var="deletePositionURL">
                    <portlet:param name="positionId" value="<%= String.valueOf(position.getPositionId()) %>"/>
                </portlet:actionURL>
                <liferay-ui:icon iconCssClass="icon-trash" message="Delete" url="<%= deletePositionURL %>" />
            </liferay-ui:icon-menu>

        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

<aui:button-row>
    <portlet:renderURL var="addPositionURL">
        <portlet:param name="mvcPath" value="/view/bank/add-position.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%= addPositionURL%>" value="Add Position"/>
</aui:button-row>