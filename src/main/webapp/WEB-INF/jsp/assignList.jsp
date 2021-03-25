<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<h3>ASSIGNMENT LIST</h3>

<br/><br/>
<div>
    <table border="5">
        <tr>
            <th>ID</th>
            <th>Course ID</th>
            <th>Student ID</th>
            </tr>
        <c:forEach  items="${assign}" var ="assign">
            <tr>
                <td>${assign.id}</td>
                <td>${assign.courseId}</td>
                <td>${assign.studentId}</td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>