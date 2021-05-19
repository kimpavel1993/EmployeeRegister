<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects/>
<jsp:useBean id="banks" class="java.util.ArrayList" scope="request"/>

<liferay-ui:search-container>
    <liferay-ui:search-container-results results="<%= banks %>"/>

    <liferay-ui:search-container-row className="ru.isands.model.Bank" modelVar="bank">
        <liferay-ui:search-container-column-text property="name"/>
        <liferay-ui:search-container-column-text property="bik"/>
        <liferay-ui:search-container-column-text property="streetAddress"/>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

<aui:button-row cssClass="bank-buttons">
    <portlet:renderURL var="editBankURL">
        <portlet:param name="mvcPath" value="/edit_bank.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%= editBankURL%>" value="Изменить таблицу"/>
</aui:button-row>