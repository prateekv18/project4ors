<%@page import="com.rays.ors.controller.UserCtl"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.ors.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.rays.ors.util.DataUtility"%>
<%@page import="com.rays.ors.util.ServletUtility"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<head>
<link rel="icon" type="image/png"
	href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16" />
<title>User Page</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#udatee").datepicker({
			changeMonth : true,
			changeYear : true,
			yearRange : '1980:2020',
			dateFormat : 'dd-mm-yy'
		});
	});
</script>
</head>


<body>
    <form action="<%=ORSView.USER_CTL%>" method="post">
        <%@ include file="Header.jsp"%>
        <script type="text/javascript" src="../js/calendar.js"></script>
        <jsp:useBean id="bean" class="com.rays.ors.bean.UserBean"
            scope="request"></jsp:useBean>

        <%
            List l = (List) request.getAttribute("roleList");
        %>

        <center>
            <h1>Add User</h1>

            <H2>
                <font color="red"> <%=ServletUtility.getErrorMessage(request)%>
                </font>
            </H2>

            <H2>
                <font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
                </font>
            </H2>



            <input type="hidden" name="id" value="<%=bean.getId()%>">
            <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
            <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>">
            <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDateTime())%>">
            <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDateTime())%>">


            <table>
                <tr>
                    <th>First Name*</th>
                    <td><input type="text" name="firstName"
                         value="<%=DataUtility.getStringData(bean.getFirstName())%>"> 
                       <%-- value="<%=ServletUtility.getParameter("firstName", request) %>">--%><font
                        color="red"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></td>
                </tr>
                <tr>
                    <th>Last Name*</th>
                    <td><input type="text" name="lastName"
                        value="<%=DataUtility.getStringData(bean.getLastName())%>"><font
                        color="red"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></td>
                </tr>
                <tr>
                    <th>LoginId*</th>
                    <td><input type="text" name="login"
                        value="<%=DataUtility.getStringData(bean.getLogin())%>"
                        <%=(bean.getId() > 0) ? "readonly" : ""%>>
                        <font
                        color="red"> <%=ServletUtility.getErrorMessage("login", request)%></font></td>
                </tr>
                <tr>
                    <th>Password*</th>
                    <td><input type="password" name="password"
                        value="<%=DataUtility.getStringData(bean.getPassword())%>"><font
                        color="red"> <%=ServletUtility.getErrorMessage("password", request)%></font></td>
                </tr>
                <tr>
                    <th>Confirm Password*</th>
                    <td><input type="password" name="confirmPassword"
                        value="<%=DataUtility.getStringData(bean.getPassword())%>"><font
                        color="red"> <%=ServletUtility.getErrorMessage("confirmPassword",
                    request)%></font></td>
                </tr>
                <tr>
                    <th>Gender</th>
                    <td>
                        <%
                            HashMap map = new HashMap();
                            map.put("M", "Male");
                            map.put("F", "Female");

                            String htmlList = HTMLUtility.getList("gender", bean.getGender(),
                                    map);
                        %> <%=htmlList%>
                    <b>Role :</b>
                    <%=HTMLUtility.getList("roleId",
                    String.valueOf(bean.getRoleId()), l)%></td>
                </tr>
                
                				<tr>
					<th align="left">Date Of Birth<font color="red">*</font></th>
					<td><input type="text" name="dob" id="datepicker"
						placeholder="Enter Date Of Birth" readonly="readonly"
						value="<%=DataUtility.getDateString(bean.getDob())%>">
						&nbsp;<font style="position: fixed;" color="red"> <%=ServletUtility.getErrorMessage("dob", request)%></font></td>
				</tr>
                <tr>
                    <th></th>
                    <td colspan="2"><input type="submit" name="operation"
                        value="<%=UserCtl.OP_SAVE%>">&emsp; <input type="submit"
                        name="operation" value="<%=UserCtl.OP_RESET%>"></td>
                </tr>
            </table>
    </form>
    </center>
    <%@ include file="Footer.jsp"%>
</body>


</html>
