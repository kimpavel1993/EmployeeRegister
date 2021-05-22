<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects/>

<portlet:actionURL name="addBank" var="addBankURL"/>

<aui:form action="<%= addBankURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input name="name" label="Bank">
            <aui:validator name="required"/>
        </aui:input>

        <aui:input name="bik" label="BIK">
            <aui:validator name="digits"/>
            <aui:validator name="required "/>
        </aui:input>

        <aui:input name="streetAddress" label="Street Address">
            <aui:validator name="required"/>
        </aui:input>
    </aui:fieldset>

    <portlet:renderURL var="mainBankURL">
        <portlet:param name="mvcPath" value="/view/bank/main-bank.jsp"/>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= mainBankURL %>"/>
    </aui:button-row>
</aui:form>