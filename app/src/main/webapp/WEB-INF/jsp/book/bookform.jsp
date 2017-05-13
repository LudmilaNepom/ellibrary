<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" language="javascript">
        function send(e) {
            var id = $('#id').val();
//            var id = parseInt (idString);
            var name = $('#name').val();
            var description = $('#description').val();
            var year = $('#year').val();
//            var year = parseInt(yearString);
            var isbnOrIssn = $('#isbnOrIssn').val();
            var publisherId = $('#publisher').val();
//           var publisherId = parseInt(publisherIdString);
            var json = {
                "id": id,
                "name": name,
                "description": description,
                "year": year,
                "isbnOrIssn": isbnOrIssn,
                "publisherId": publisherId
            };
            var url = "${pageContext.request.contextPath}/book/" + parseInt(id);
            $.ajax({
                type: 'PUT',
                url: url,
                data: JSON.stringify(json),
                contentType: 'application/json; charset=utf-8',
                cache: false,
                success: function(result) {
                    $('#generic-container').html(result);
                }
            });
            e.preventDefault
        }
        ;
        $(function () {
            $('#form_id').on('submit', send);
        });
    </script>
    <title>Book form</title>
</head>
<body>
<div id="generic-container">
    <div class="header">Book Form</div>
    <form:form id="form_id" modelAttribute="book" action="javascript:void(null);" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="cell">
                <label class="lable" for="name">Name</label>
                <div class="inp">
                    <form:input type="text" path="name" id="name" class="form input"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="cell">
                <label class="lable" for="description">Description</label>
                <div class="inp">
                    <form:input type="text" path="description" id="description" class="form input"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="cell">
                <label class="lable" for="year">Year</label>
                <div class="inp">
                    <form:input type="text" path="year" id="year" class="form input"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="cell">
                <label class="lable" for="isbnOrIssn">ISBN</label>
                <div class="inp">
                    <form:input type="text" path="isbnOrIssn" id="isbnOrIssn" class="form input"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="cell">
                <label class="lable" for="publisher">Publisher</label>
                <div class="inp">
                    <form:select path="publisher" id="publisher">
                        <c:forEach var="publisher" items="${publ}">
                            <form:option value="${publisher.id}"><c:out
                                    value="${publisher.publisherName}, ${publisher.country}"/></form:option>
                        </c:forEach>
                    </form:select>
                        <%--<form:select path="publisher" items="${publ}" multiple="true" itemValue="id"  itemLabel="publisherName" class="form input" />--%>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="cell">
                <c:choose>
                <c:when test="${message}">
                    <input type="button" value="done" class="btn"/>
                </c:when>
                    <c:otherwise>
                        <input type="submit" value="Edit" class="btn"/>
                    </c:otherwise>
                </c:choose> or <a href="<c:url value='/book/' />">Back to books</a>
                    <%--<a href="#" class="add" onclick='send_form()'>Submit</a>--%>
            </div>
        </div>
    </form:form>
    <div id="message">
    <c:choose>
    <c:when test="${message}">
    <h3> Book has been edited </h3>
        </c:when>
        </c:choose>
            <p><a href="${pageContext.request.contextPath}/">HOME</a></p>
    </div>
</div>
</body>
</html>
