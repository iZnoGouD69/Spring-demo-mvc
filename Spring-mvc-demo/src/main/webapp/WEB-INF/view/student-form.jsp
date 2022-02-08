<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Student Form</title>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="student">
	
	First Name: <form:input path="firstName"/>
	
	<br><br>
	
	Last Name : <form:input path="lastName" />
	
	<br><br>
	
	Country :
	<form:select path="country">
		<form:options items="${student.countryOptions}"/>
	</form:select>
	
	<br><br>
	
	Favourite Language:
	Java <form:radiobutton path="favouriteLanguage" value="Java"/>
	C++ <form:radiobutton path="favouriteLanguage" value="C++" />
	.Net <form:radiobutton path="favouriteLanguage" value=".Net" />
	GO <form:radiobutton path="favouriteLanguage" value="GO"/>
	
	<br><br>
	
	Experience with OS:
	Linux <form:checkbox path="favouriteOs" value="Linux" />
	Windows <form:checkbox path="favouriteOs" value="Microsoft Windows" />
	Mac <form:checkbox path="favouriteOs" value="Mac" />
	
	<br><br>
	
	<input type="submit" value="Submit" />

	</form:form>

</body>
</html>