<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<h3>STUDENTS LIST</h3>

<br/><br/>
<div>
    <table border="5">
        <tr>
            <th>Surname</th>
            <th>Name</th>
            <th>Second Name</th>
            <th>Phone Number</th>
            <th>E-mail</th>
                    </tr>
        <c:forEach  items="${student}" var ="student">
            <tr>
                <td>${student.surname}</td>
                <td>${student.name}</td>
                <td>${student.secondName}</td>
                <td>${student.phone}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>