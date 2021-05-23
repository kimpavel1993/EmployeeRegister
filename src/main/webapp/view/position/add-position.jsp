<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects/>

<portlet:actionURL name="addPosition" var="addPositionURL"/>

<aui:form action="<%= addPositionURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input name="name" label="Position">
            <aui:validator name="required"/>
        </aui:input>

        <label>Archive Status:</label>
        <aui:input name="isArchived" label="Archived" type="radio" checked="true"/>
        <aui:input name="isArchived" label="Not Archived" type="radio"/>
    </aui:fieldset>

    <portlet:renderURL var="mainPositionURL">
        <portlet:param name="mvcPath" value="/view/position/main-position.jsp"/>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= mainPositionURL %>"/>
    </aui:button-row>
</aui:form>