<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style type="text/css">
        #generic-container {
            width: 600px;
            display: block;
            margin: 20px auto 0 auto;
        }

        .header {
            width: 100%;
            color: steelblue;
            border: 1px solid transparent;
            text-align: center;
        }

        .row {
            width: 100%;
            color: steelblue;
            float: left;
            border: 1px solid #000000;
            text-align: center;
        }

        .cell {
            margin: 5%;
            border: 1px solid aqua;
            text-align: center;
        }

        .inp {
            color: azure;
            width: 80%;
            text-align: center;
        }

        .form_input {
            background-color: bisque;
            width: 70%;
            text-align: center;
            align-self: center;
        }

        .lable {
            color: midnightblue;
            text-align: left;
        }

        .footer {
            position: relative;
            bottom: 5%;
            width: 100%;
            float: left;
            text-align: right;

        }
    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" language="javascript">
        function updatebook(e) {
            var id = $('#id').val();
            var name = $('#name').val();
            var description = $('#description').val();
            var year = $('#year').val();
            var isbnOrIssn = $('#isbnOrIssn').val();
            var publisherId = $('#publisher').val();
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
                success: function (result) {
                    $('#generic-container').html(result);
                    $("input").prop('disabled', true);
                }
            });
            e.preventDefault
        };
        function deletebook() {
            var id = $('#id').val();
            var name = $('#name').val();
            var description = $('#description').val();
            var year = $('#year').val();
            var isbnOrIssn = $('#isbnOrIssn').val();
            var publisherId = $('#publisher').val();
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
                type: 'DELETE',
                url: url,
                data: JSON.stringify(json),
                contentType: 'application/json; charset=utf-8',
                cache: false,
                success: function (result) {
                    $('#generic-container').html(result);
                    $("input").prop('disabled', true);
                }
            });

        };
        $(function () {
            $('#form_id').on('submit', updatebook);
        });
        $(function () {
            $('#delete').on('click', deletebook);
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
                <form:input type="text" path="name" id="name" class="form_input"/>
            </div>
            <div class="has-error">
                <form:errors path="name" class="help-inline"/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="cell">
            <label class="lable" for="description">Description</label>
            <div class="inp">
                <form:input type="text" path="description" id="description" class="form_input"/>
            </div>
            <div class="has-error">
                <form:errors path="description" class="help-inline"/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="cell">
            <label class="lable" for="year">Year</label>
            <div class="inp">
                <form:input type="text" path="year" id="year" class="form_input"/>
            </div>
            <div class="has-error">
                <form:errors path="year" class="help-inline"/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="cell">
            <label class="lable" for="isbnOrIssn">ISBN</label>
            <div class="inp">
                <form:input type="text" path="isbnOrIssn" id="isbnOrIssn" class="form_input"/>
            </div>
            <div class="has-error">
                <form:errors path="isbnOrIssn" class="help-inline"/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="cell">
            <label class="lable"
                   for="publisher">Publisher: ${book.publisher.publisherName}, ${book.publisher.country} </label>
            <div class="inp">

                <p class="lable">If you are editing book, please select:</p>
                <form:select path="publisher" id="publisher" class="form_input">
                    <c:forEach var="publisher" items="${publ}">
                        <form:option value="${publisher.id}"><c:out
                                value="${publisher.publisherName}, ${publisher.country}"/></form:option>
                    </c:forEach>
                </form:select>
                <div class="has-error">
                    <form:errors path="publisher" class="help-inline"/>
                </div>
                    <%--<form:select path="publisher" items="${publ}" multiple="true" itemValue="id"  itemLabel="publisherName" class="form input" />--%>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="cell">
            <div><p><input type="submit" value="EDIT" class="btn"/></p></div>
        </div>
        </form:form>
        <div class="cell">
            <div><p><input id="delete" type="button" value="DELETE" class="btn"/></p></div>
        </div>
        <div class="cell"><a href="${pageContext.request.contextPath}/book/">Back to books</a></div>
        <div id="message">
            <c:choose>
                <c:when test="${message}">
                    <h3> ${content} </h3>
                </c:when>
            </c:choose>
        </div>
        <div class="footer">
            <p><a href="${pageContext.request.contextPath}/">HOME</a></p>
            <p>&copyNepomnyachshaya L V, 2017</p>
        </div>
    </div>

</body>
</html>
