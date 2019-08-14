<%@page import="uk.ac.uea.www.course.service.FooLocalServiceUtil"%>
<%@page import="uk.ac.uea.www.course.model.Foo"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<p>
	<b><liferay-ui:message key="course.caption" /></b>
</p>

<div class="container">
	<b>Add Foo</b>
	<portlet:actionURL name="addFoo" var="addFooUrl">
	</portlet:actionURL>
	<aui:form action="<%=addFooUrl%>">
		<aui:input name="name" type="text" style="width: 50%;" />
		<aui:button type="submit" value="submit" />
	</aui:form>
</div>
<%
	List<Foo> fooList = FooLocalServiceUtil.getFoos(-1, -1);
%>
<h4>List of Foo's</h4>
<c:choose>
	<c:when test="<%=fooList != null && fooList.size() > 0%>">
		<table>
			<thead>
				<th>
				<td>Field1</td>
				</th>
			</thead>
			<tbody>
				<c:forEach items="<%=fooList%>" var="foo">
					<tr>
						<td>${foo.field1 }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
 Empty Foo's
 </c:otherwise>
</c:choose>