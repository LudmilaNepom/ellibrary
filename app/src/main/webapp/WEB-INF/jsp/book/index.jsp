<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <style type="text/css">
        #box {
            width: 1350px;
            display: block;
            margin: 20px auto 0 auto;
        }

        .title {
            width: 100%;
            color: steelblue;
            border: 1px solid transparent;
            text-align: center;
        }

        .inner_box_th {
            width: 148px;
            color: steelblue;
            float: left;
            border: 1px solid #000000;
            text-align: center;
        }

        .inner_box {
            width: 148px;
            height: 90px;
            float: left;
            border: 1px solid #000000;
            text-align: center;
        }

        .text {
            text-align: center;
        }

        .hidden {
            display: none;
            width: 600px;
            margin: 20px auto 0 auto;
        }

        .active {
            width: 600px;
            margin: 20px auto 0 auto;

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
            bottom: 10%;
            width: 95%;
            float: left;
            text-align: right;

        }
    </style>
    <script>
        function show() {
            $('#new_book_form').removeClass('hidden').addClass('active');
        }
        $(function () {
            $('#create_new_book').on('click', show);
        });
    </script>
</head>
<body>
<div class="title">
    <h2>Books</h2>
</div>
<div id="box">
    <div class="inner_box_th">
        <p class="text">name</p>
    </div>
    <div class="inner_box_th">
        <p class="text">description</p>
    </div>
    <div class="inner_box_th">
        <p class="text">year</p>
    </div>
    <div class="inner_box_th">
        <p class="text">isbnOrIssn</p>
    </div>
    <div class="inner_box_th">
        <p class="text">authors</p>
    </div>
    <div class="inner_box_th">
        <p class="text">publisher</p>
    </div>
    <div class="inner_box_th">
        <p class="text">works</p>
    </div>
    <div class="inner_box_th">
        <p class="text">reviews</p>
    </div>
    <div class="inner_box_th">
        <p class="text">view details/edit/delete</p>
    </div>

    <c:forEach items="${books}" var="book">
        <div class="inner_box">
            <p class="text">${book.name}</p>
        </div>
        <div class="inner_box">
            <p class="text">${book.description}</p>
        </div>
        <div class="inner_box">
            <p class="text">${book.year}</p>
        </div>
        <div class="inner_box">
            <p class="text">${book.isbnOrIssn}</p>
        </div>
        <div class="inner_box">
            <p class="text"></p>
        </div>
        <div class="inner_box">
            <p class="text">${book.publisher.publisherName}, ${book.publisher.country}</p>
        </div>
        <div class="inner_box">
            <p class="text"></p>
        </div>
        <div class="inner_box">
            <p class="text"></p>
        </div>
        <div class="inner_box">
            <p class="text"><a href="${pageContext.request.contextPath}/book/${book.id}">go to the book's page</a></p>
        </div>


    </c:forEach>
    <div class="inner_box">
        <p><input id="create_new_book" type="button" value="NEWBOOK" class="btn"/></p>
    </div>
</div>
<div id="new_book_form" class="hidden">
    <div class="header">Book Form</div>
    <form:form id="form_id" method="POST" modelAttribute="book" class="form-horizontal">
    <form:input type="hidden" path="id" id="id" value="0"/>
    <div class="row">
        <div class="cell">
            <label class="lable" for="name">Name</label>
            <div class="inp">
                <form:input type="text" path="name" id="name" class="form_input"/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="cell">
            <label class="lable" for="description">Description</label>
            <div class="inp">
                <form:input type="text" path="description" id="description" class="form_input"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="cell">
            <label class="lable" for="year">Year</label>
            <div class="inp">
                <form:input type="text" path="year" id="year" class="form_input"/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="cell">
            <label class="lable" for="isbn">ISBN</label>
            <div class="inp">
                <form:input type="text" path="isbn" id="isbn" class="form_input"/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="cell">
            <label class="lable"
                   for="publisher">Publisher </label>
            <div class="inp">

                <p class="lable">select:</p>
                <form:select path="publisher" id="publisher" class="form_input">
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
            <div><p><input id="create_new" type="submit" value="CREATE NEW BOOK" class="btn"/></p></div>
        </div>


    </form:form>
    </div>

</div>
<div id="message">
    <c:choose>
        <c:when test="${message}">
            <h3> ${content} </h3>
        </c:when>
    </c:choose>
</div>
<div class="footer">
    <%--<p><a href="<c:url value='/'/>">HOME</a> </p>--%>
    <p><a href="${pageContext.request.contextPath}/">HOME</a></p>
    <p>&copyNepomnyachshaya L V, 2017</p>
</div>
</body>
</html>
