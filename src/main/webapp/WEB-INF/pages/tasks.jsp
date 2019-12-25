<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Book List</h1>

<c:if test="${!empty listTask}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">start</th>
            <th width="120">end</th>
            <th width="120">status</th>
            <th width="120">target</th>
            <th width="120">comment</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTask}" var="task">
            <tr>
                <td>${tasks.id}</td>
                <td><a href="/tasksdata/${tasks.id}" target="_blank">${tasks.target}</a></td>
                <td>${task.start}</td>
                <td>${task.end}</td>
                <td>${task.status}</td>
                <td>${task.comment}</td>
                <td><a href="<c:url value='/edit/${task.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${task.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a task</h1>

<c:url var="addAction" value="/task/add"/>

<form:form action="${addAction}" commandName="task">
    <table>
        <c:if test="${!empty task.target}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="start">
                    <spring:message text="start"/>
                </form:label>
            </td>
            <td>
                <form:input path="start"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="end">
                    <spring:message text="end"/>
                </form:label>
            </td>
            <td>
                <form:input path="end"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="status">
                        <spring:message text="status"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="status"/>
                </td>
            </tr>
        </tr>
        <tr>
            <td>
                <form:label path="target">
                        <spring:message text="target"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="target"/>
                </td>
            </tr>
        </tr>
                <tr>
                    <td>
                        <form:label path="comment">
                                <spring:message text="comment"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="comment"/>
                        </td>
                    </tr>
                </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty task.target}">
                    <input type="submit"
                           value="<spring:message text="Edit task"/>"/>
                </c:if>
                <c:if test="${empty task.target}">
                    <input type="submit"
                           value="<spring:message text="Add task"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
