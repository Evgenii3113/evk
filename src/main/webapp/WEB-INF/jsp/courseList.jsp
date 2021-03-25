<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<h3>COURSE LIST</h3>

<br/><br/>
<div>
    <table border="5">
        <tr>
            <th>Course ID</th>
            <th>Course name</th>
            <th>Start date</th>
            </tr>
        <c:forEach  items="${course}" var ="course">
            <tr>
                <td>${course.id}</td>
                <td>${course.courseName}</td>
                <td>${course.startDate}</td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>