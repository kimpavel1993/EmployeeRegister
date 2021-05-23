<%@ page import="com.liferay.counter.service.CounterLocalServiceUtil" %>
<%@ page import="ru.isands.model.Position" %>
<%@ page import="ru.isands.service.PositionLocalServiceUtil" %>
<%@ page import="ru.isands.service.BankLocalServiceUtil" %>
<%@ page import="ru.isands.model.Bank" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects/>

<portlet:actionURL name="addEmployee" var="addEmployeeURL"/>

<aui:form action="<%= addEmployeeURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input name="lastName" label="Last Name">
            <aui:validator name="required"/>
        </aui:input>

        <aui:input name="firstName" label="First Name">
            <aui:validator name="required"/>
        </aui:input>

        <aui:input name="middleName" label="Middle Name">
            <aui:validator name="required"/>
        </aui:input>

        <label>Sex:</label>
        <aui:input name="sex" label="Male" type="radio" value="Male" checked="true"/>
        <aui:input name="sex" label="Female" type="radio" value="Female"/>

        <aui:input name="birthdayDate" label="Birthday Date" cssClass="datepicker">
            <aui:validator name="required"/>
        </aui:input>

        <aui:select name="positionId" label="Position">
            <%
                for (Position position : PositionLocalServiceUtil.getPositions(0, (int) CounterLocalServiceUtil.increment())) {
            %>
            <aui:option label="<%= position.getName() %>" value="<%= position.getPositionId() %>"/>
            <%
                }
            %>
        </aui:select>

        <aui:input name="employmentDate" label="Employment Date" cssClass="datepicker">
            <aui:validator name="required"/>
        </aui:input>

        <aui:input name="salary" label="Salary">
            <aui:validator name="required"/>
        </aui:input>

        <aui:input name="workPhone" label="Work Phone Number">
            <aui:validator name="required"/>
        </aui:input>

        <aui:input name="mobilePhone" label="Mobile Phone Number">
            <aui:validator name="required"/>
        </aui:input>

        <aui:select name="bankId" label="Bank">
            <%
                for (Bank bank : BankLocalServiceUtil.getBanks(0, (int) CounterLocalServiceUtil.increment())) {
            %>
            <aui:option label="<%= bank.getName() %>" value="<%= bank.getBankId() %>"/>
            <%
                }
            %>
        </aui:select>

        <label>Archive Status:</label>
        <aui:input name="isArchived" label="Archived" type="radio" checked="true"/>
        <aui:input name="isArchived" label="Not Archived" type="radio"/>
    </aui:fieldset>

    <portlet:renderURL var="mainEmployeeURL">
        <portlet:param name="mvcPath" value="/view/employee/main-employee.jsp"/>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= mainEmployeeURL %>"/>
    </aui:button-row>
</aui:form>

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