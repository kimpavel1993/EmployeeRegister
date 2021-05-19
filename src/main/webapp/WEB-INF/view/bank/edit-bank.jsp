<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />

<portlet:renderURL var="mainBankURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addEntry" var="addEntryURL"/>

<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">

    <aui:fieldset>

        <aui:input name="name"/>
        <aui:input name="message"/>

    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>

    </aui:button-row>
</aui:form>