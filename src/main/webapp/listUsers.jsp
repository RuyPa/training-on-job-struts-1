<%@taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="l"%>
<table border="1">
	<tr>
		<th>Name</th>
		<th>Address</th>
	</tr>
	<l:iterate id="u" name="dynaUserListForm" property="items">
		<tr>
			<td><b:write name="u" property="name" /></td>
			<td><b:write name="u" property="address" /></td>
		</tr>
	</l:iterate>
</table>