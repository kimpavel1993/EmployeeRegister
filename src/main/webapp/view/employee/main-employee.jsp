<%@ page import="ru.isands.service.PositionLocalServiceUtil" %>
<%@ page import="ru.isands.service.EmployeeLocalServiceUtil" %>
<%@ page import="ru.isands.service.BankLocalServiceUtil" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects/>

<%
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
%>

<liferay-ui:search-container>
    <liferay-ui:search-container-results
            results="<%= EmployeeLocalServiceUtil.getEmployees(searchContainer.getStart(), searchContainer.getEnd()) %>"/>

    <liferay-ui:search-container-row className="ru.isands.model.Employee" modelVar="employee">

        <liferay-ui:search-container-column-text property="lastName" name="Last Name"/>
        <liferay-ui:search-container-column-text property="firstName" name="First Name"/>
        <liferay-ui:search-container-column-text property="middleName" name="Middle Name"/>
        <liferay-ui:search-container-column-text property="sex" name="Sex"/>
        <liferay-ui:search-container-column-text value="<%= df.format(employee.getBirthdayDate()) %>" name="Birthday"/>
        <liferay-ui:search-container-column-text
                value="<%=PositionLocalServiceUtil.getPosition(employee.getPositionId()).getName()%>" name="Position"/>
        <liferay-ui:search-container-column-text value="<%= df.format(employee.getEmploymentDate()) %>" name="Date of Employment"/>
        <liferay-ui:search-container-column-text property="salary" name="Salary"/>
        <liferay-ui:search-container-column-text property="workPhone" name="Work Phone Number"/>
        <liferay-ui:search-container-column-text property="mobilePhone" name="Mobile Phone Number"/>
        <liferay-ui:search-container-column-text
                value="<%=BankLocalServiceUtil.getBank(employee.getBankId()).getName()%>" name="Bank"/>
        <liferay-ui:search-container-column-text property="isArchived" name="Archived"/>
        <liferay-ui:search-container-column-text name="Edit">
            <liferay-ui:icon-menu>
                <portlet:renderURL var="editEmployeeURL">
                    <portlet:param name="employeeId" value="<%= String.valueOf(employee.getEmployeeId()) %>"/>
                    <portlet:param name="mvcPath" value="/view/employee/edit-employee.jsp"/>
                </portlet:renderURL>

                <liferay-ui:icon iconCssClass="icon-edit" message="Edit" url="<%= editEmployeeURL %>"/>
            </liferay-ui:icon-menu>

        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Delete">
            <liferay-ui:icon-menu>
                <portlet:actionURL name="deleteEmployee" var="deleteEmployeeURL">
                    <portlet:param name="employeeId" value="<%= String.valueOf(employee.getEmployeeId()) %>"/>
                </portlet:actionURL>

                <liferay-ui:icon iconCssClass="icon-trash" message="Delete" url="<%= deleteEmployeeURL %>"/>
            </liferay-ui:icon-menu>

        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

<aui:button-row>
    <portlet:renderURL var="addEmployeeURL">
        <portlet:param name="mvcPath" value="/view/employee/add-employee.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%= addEmployeeURL%>" value="Add Employee"/>
</aui:button-row>