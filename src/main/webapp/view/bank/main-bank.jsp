<%@ page import="ru.isands.model.Bank" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.isands.service.BankLocalServiceUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects/>

<% List<Bank> list = BankLocalServiceUtil.getBanks(0, BankLocalServiceUtil.getBanksCount()); %>
<liferay-ui:search-container>
    <liferay-ui:search-container-results
            results="<%= BankLocalServiceUtil.getBanks(searchContainer.getStart(), searchContainer.getEnd()) %>"
            total="<%=BankLocalServiceUtil.getBanksCount()%>"/>


    <liferay-ui:search-container-row className="ru.isands.model.Bank" modelVar="bank">
        <liferay-ui:search-container-column-text property="name"/>
        <liferay-ui:search-container-column-text property="bik"/>
        <liferay-ui:search-container-column-text property="streetAddress"/>
        <liferay-ui:search-container-column-text>
            <liferay-ui:icon-menu>
                <portlet:renderURL var="editBankURL">
                    <portlet:param name="bankId" value="<%= String.valueOf(bank.getBankId()) %>"/>
                    <portlet:param name="mvcPath" value="/view/bank/edit-bank.jsp"/>
                </portlet:renderURL>

                <liferay-ui:icon iconCssClass="icon-edit" message="Edit" url="<%= editBankURL %>" />

                <portlet:actionURL name="deleteBank"  var="deleteBankURL">
                    <portlet:param name="bankId" value="<%= String.valueOf(bank.getBankId()) %>"/>
                </portlet:actionURL>
                <liferay-ui:icon iconCssClass="icon-trash" message="Delete" url="<%= deleteBankURL %>" />
            </liferay-ui:icon-menu>

        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

<aui:button-row>
    <portlet:renderURL var="addBankURL">
        <portlet:param name="mvcPath" value="/view/bank/add-bank.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%= addBankURL%>" value="Add Bank"/>
</aui:button-row>