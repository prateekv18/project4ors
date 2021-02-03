<%@page import="com.rays.ors.controller.ORSView"%>
<%@page import="com.rays.ors.controller.MyProfileCtl"%>
<%@page import="com.rays.ors.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.rays.ors.util.DataUtility"%>
<%@page import="com.rays.ors.util.ServletUtility"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<form action="<%=ORSView.MY_PROFILE_CTL%>" method="post">

		<%@include file="Header.jsp"%>
		<jsp:useBean id="bean" class="com.rays.ors.bean.UserBean"
			scope="request"></jsp:useBean>

		<center>
			<h1>My Profile</h1>

			<h2>
				<font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font>
			</h2>

			<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>"> <input type="hidden"
				name="createdBy" value="<%=bean.getCreatedBy()%>">
			<table>
				<tr>
					<th>LoginId*</th>
					<td><input type="text" name="login"
						value="<%=DataUtility.getStringData(bean.getLogin())%>"
						readonly="readonly"> <font color="red"><%=ServletUtility.getErrorMessage("login", request)%></font>
					</td>
				</tr>
				<tr>
					<th>First Name*</th>
					<td><input type="text" name="firstName"
						value="<%=DataUtility.getStringData(bean.getFirstName())%>"
						readonly="readonly"> <font color="red"><%=ServletUtility.getErrorMessage("firstName", request)%></font>
					</td>
				</tr>
				<tr>
					<th>Last Name*</th>
					<td><input type="text" name="lastName"
						value="<%=DataUtility.getStringData(bean.getLastName())%>"
						readonly="readonly"> <font color="red"><%=ServletUtility.getErrorMessage("lastName", request)%></font>
					</td>
				</tr>

				<tr>
					<th>Gender</th>
					<td>
						<%
							HashMap map = new HashMap();
							map.put("M", "Male");
							map.put("F", "Female");

							String htmlList = HTMLUtility.getList("gender", bean.getGender(), map);
						%> <%=htmlList%>
					</td>
				</tr>

				<tr>
					<th>Mobile No*</th>
					<td><input type="text" name="mobileNo"
						value="<%=DataUtility.getStringData(bean.getMobileNo())%>">
						<font color="red"></font></td>
				</tr>

				<tr>
					<th>Date Of Birth(dd/MM/yyyy)</th>
					<td><input type="text" name="dob" readonly="readonly"
						value="<%=DataUtility.getDateString(bean.getDob())%>"> <a
						href="javascript:getCalender(documents.forms[0].dob);"> 
						<!-- <img	src="../img/Calender.jpg" width="16" height="15" border="0"
							alt="Calender"> -->
					</a><font color="red"> <%=ServletUtility.getErrorMessage("dob", request)%>
					</font></td>
				</tr>

				<h2>
					<font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
					</font>
				</h2>

				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation"
						value="<%=MyProfileCtl.OP_CHANGE_MY_PASSWORD%>"> &nbsp;<input
						type="submit" name="operation" value="<%=MyProfileCtl.OP_SAVE%>>">
						&nbsp;</td>
				</tr>
			</table>
	</form>
	</center>
	<%@include file="Footer.jsp"%>
</body>
</html>