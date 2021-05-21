<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />

<portlet:renderURL var="mainBankURL">
    <portlet:param name="mvcPath" value="/view/bank/main-bank.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="editBank" var="editBankURL"/>

<aui:form action="<%= editBankURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input name="bik" label="BIK"/>
        <aui:input name="streetAddress" label="Street Address"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= mainBankURL %>"/>
    </aui:button-row>
</aui:form>