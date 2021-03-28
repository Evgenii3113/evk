<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<h3>ASSIGNMENT LIST</h3>

<br/><br/>
<div>
    <table border="5">
        <tr>
            <th>ID</th>
            <th>Surname</th>
            <th>Name</th>
            <th>Second name</th>
            <th>Course name</th>
            </tr>
        <c:forEach  items="${assign}" var ="assign">
            <tr>
                <td>${assign.id}</td>
                <td>${assign.studentEntity.surname}</td>
                <td>${assign.studentEntity.name}</td>
                <td>${assign.studentEntity.secondName}</td>
                <td>${assign.courseEntity.courseName}</td>


            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>