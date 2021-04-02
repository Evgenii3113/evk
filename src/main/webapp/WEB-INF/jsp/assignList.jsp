<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<h3>STUDENTS</h3>

<br/><br/>
<div>
    <table border="5">
        <tr>
            <th>ID</th>
            <th>Surname</th>
            <th>Name</th>
            <th>Second name</th>
            <th>Course name</th>
            <th>Start date</th>
            </tr>
        <c:forEach  items="${assign}" var ="assign">
            <tr>
                <td>${assign.studentEntity.id}</td>
                <td>${assign.studentEntity.surname}</td>
                <td>${assign.studentEntity.name}</td>
                <td>${assign.studentEntity.secondName}</td>
                <td>${assign.courseEntity.courseName}</td>
                <td>${assign.courseEntity.startDate}</td>


            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>