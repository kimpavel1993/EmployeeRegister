<%@ page import="ru.isands.service.PositionLocalServiceUtil" %>
<%@ page import="ru.isands.service.EmployeeLocalServiceUtil" %>
<%@ page import="ru.isands.service.BankLocalServiceUtil" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="ru.isands.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects/>

<portlet:renderURL var="mainEmployeeURL">
    <portlet:param name="mvcPath" value="/view/employee/main-employee.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="searchURL"/>

<aui:form name="search" action="<%=searchURL%>">
    <aui:fieldset>
        <aui:input name="searchName" label="Search by name"/>
        <aui:input name="searchFirstDate" cssClass="datepicker" label="First Date"/>
        <aui:input name="searchLastDate" cssClass="datepicker" label="Last Date"/>

        <aui:button-row>
            <aui:button name="searchURL" type="submit" value="Search"/>
            <aui:button type="cancel" onClick="<%= mainEmployeeURL %>"/>
        </aui:button-row>
    </aui:fieldset>
</aui:form>

<liferay-ui:search-container>
    <%
        List<Employee> result = EmployeeLocalServiceUtil.getEmployees(0, EmployeeLocalServiceUtil.getEmployeesCount());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String name = ParamUtil.getString(request, "searchName");
        Date firstDate = ParamUtil.getDate(request, "searchFirstDate", df, null);
        Date lastDate = ParamUtil.getDate(request, "searchLastDate", df, null);

        String[] names = name.split(" ");
        List<String> fullName = Arrays.asList(names);

        if (!name.isEmpty()) {
            result = EmployeeLocalServiceUtil.findByName(fullName);
        } else if (firstDate != null && lastDate != null) {
            result = EmployeeLocalServiceUtil.findByDate(firstDate, lastDate);
        }
    %>

    <liferay-ui:search-container-results
            results="<%= result %>"
    />

    <liferay-ui:search-container-row className="ru.isands.model.Employee" modelVar="employee">

        <liferay-ui:search-container-column-text property="lastName" name="Last Name"/>
        <liferay-ui:search-container-column-text property="firstName" name="First Name"/>
        <liferay-ui:search-container-column-text property="middleName" name="Middle Name"/>
        <liferay-ui:search-container-column-text property="sex" name="Sex"/>
        <liferay-ui:search-container-column-text value="<%= df.format(employee.getBirthdayDate()) %>" name="Birthday"/>
        <liferay-ui:search-container-column-text
                value="<%= PositionLocalServiceUtil.getPosition(employee.getPositionId()).getName() %>" name="Position"/>
        <liferay-ui:search-container-column-text value="<%= df.format(employee.getEmploymentDate()) %>"
                                                 name="Date of Employment"/>
        <liferay-ui:search-container-column-text property="salary" name="Salary"/>
        <liferay-ui:search-container-column-text property="workPhone" name="Work Phone Number"/>
        <liferay-ui:search-container-column-text property="mobilePhone" name="Mobile Phone Number"/>
        <liferay-ui:search-container-column-text
                value="<%= BankLocalServiceUtil.getBank(employee.getBankId()).getName() %>" name="Bank"/>
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

<script>
    YUI().use(
        'aui-datepicker',
        function (Y) {
            var datepicker = new Y.DatePicker(
                {
                    trigger: '.datepicker',
                    mask: '%d/%m/%Y',
                    popover: {
                        toolbars: {
                            header: [[
                                {
                                    icon: 'icon-trash',
                                    label: 'Clear',
                                    on: {
                                        click: function () {
                                            datepicker.clearSelection();
                                        }
                                    }
                                },
                                {
                                    label: 'date',
                                    on: {
                                        click: function () {
                                            datepicker.clearSelection();
                                            datepicker.selectDates(new Date());
                                        }
                                    }
                                }
                            ]]
                        },
                        zIndex: 1
                    }
                }
            );
        }
    );
</script>