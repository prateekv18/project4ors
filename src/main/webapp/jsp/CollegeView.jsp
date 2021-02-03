<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.rays.ors.util.DataUtility"%>
<%@page import="com.rays.ors.controller.CollegeCtl"%>
<%@page import="com.rays.ors.util.ServletUtility"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<form action="CollegeCtl" method="post">
		<%@include file="Header.jsp"%>

		<jsp:useBean id="bean" class="com.rays.ors.bean.CollegeBean"
			scope="request"></jsp:useBean>

		<center>
			<h1>Add College</h1>

			<h2>
				<font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font>
			</h2>

			<h2>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h2>

			I<input type="hidden" name="id" value="<%=bean.getId()%>"><input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>"><input type="hidden"
				name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDateTime())%>">
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDateTime())%>">

			<table>
				<tr>
					<th>Name*</th>
					<td><input type="text" name="name"
						value="<%=DataUtility.getStringData(bean.getName())%>"><font
						color="red"><%=ServletUtility.getErrorMessage("name", request)%></font>
					</td>
				</tr>
				<tr>
					<th>Address*</th>
					<td><input type="text" name="address"
						value="<%=DataUtility.getStringData(bean.getAddress())%>"><font
						color="red"> <%=ServletUtility.getErrorMessage("address", request)%>
					</font></td>
				</tr>
				<tr>
					<th>State*</th>
					<td><input type="text" name="state"
						value="<%=DataUtility.getStringData(bean.getState())%>"><font
						color="red"> <%=ServletUtility.getErrorMessage("state", request)%>
					</font></td>
				</tr>
				<tr>
					<th>City*</th>
					<td><input type="text" name="city"
						value="<%=DataUtility.getStringData(bean.getCity())%>"><font
						color="red"> <%=ServletUtility.getErrorMessage("city", request)%>
					</font></td>
				</tr>
				<tr>
					<th>PhoneNo*</th>
					<td><input type="text" name="phoneNo"
						value="<%=DataUtility.getStringData(bean.getPhoneNo())%>"><font
						color="red"> <%=ServletUtility.getErrorMessage("phoneNo", request)%>
					</font></td>
				</tr>
				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_SAVE%>"> <%
 	if (bean.getId() > 0) {
 %>&emsp;<input type="submit" name="operation"
						value="<%=CollegeCtl.OP_DELETE%>"> <%
 	}
 %> &emsp;<input type="submit" name="operation"
						value="<%=CollegeCtl.OP_CANCEL%>"></td>
				</tr>
			</table>
	</form>
	</center>
	<%@include file="Footer.jsp"%>
</body>
</html>