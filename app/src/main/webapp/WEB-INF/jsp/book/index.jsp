<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Welcome to Ellibrary</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
      crossorigin="anonymous">


<link href="${pageContext.request.contextPath}/static/app.css" rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Ellibrary</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${pageContext.request.contextPath}/book/">Books</a></li>
                <li><a href="${pageContext.request.contextPath}/author/">Authors</a></li>
                <li><a href="${pageContext.request.contextPath}/publisher/">Publishers</a></li>
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/logout/">Logout</a></li>
            </ul>

        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="bg-info"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="${pageContext.request.contextPath}/book/">Books</a></li>
                <li><a href="${pageContext.request.contextPath}/author/">Authors</a></li>
                <li><a href="${pageContext.request.contextPath}/publisher/">Publishers</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/logout/">Logout</a></li>
            </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h2 class="sub-header">Books</h2>
            <table class="table table-striped">
                <thead>
                <th>id</th>
                <th>name</th>
                <th>description</th>
                <th>year</th>
                <th>isbnOrIssn</th>
                <th>authors</th>
                <th>publisher</th>
                <th>works</th>
                <th>reviews</th>
                <th>edit/delete</th>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <th>
                                ${book.id}
                        </th>
                        <th>
                                ${book.name}
                        </th>
                        <th>
                                ${book.description}
                        </th>
                        <th>
                                ${book.year}
                        </th>
                        <th>
                                ${book.isbnOrIssn}
                        </th>
                        <th>

                        </th>
                        <th>
                                ${book.publisher.publisherName}, ${book.publisher.country}
                        </th>
                        <th>

                        </th>
                        <th>

                        </th>
                        <th>
                            <a href="${pageContext.request.contextPath}/book/${book.id}">edit/delete</a>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="inner_box">
                <p><input id="create_new_book" type="button" value="NEWBOOK" class="btn"/></p>
            </div>
            <div id="new_book_form" class="hidden">

                <div class="bg-info">
                    <h3>Book Form</h3>
                </div>
                <form:form id="form_id" method="POST" action="javascript:void(null);" modelAttribute="bookFromView"
                           class="form-horizontal">
                    <form:input type="hidden" path="id" id="id" value="0"/>
                    <div class="form-group">

                        <label class="col-sm-2 control-label" for="name">Name</label>
                        <div class="col-sm-10">
                            <form:input type="text" path="name" id="name" class="form-control"/>
                            <form:errors path="name" class="help-inline text-danger"/>
                        </div>

                    </div>

                    <div class="form-group">

                        <label class="col-sm-2 control-label" for="description">Description</label>
                        <div class="col-sm-10">
                            <form:input type="text" path="description" id="description" class="form-control"/>
                            <form:errors path="description" class="help-inline text-danger"/>
                        </div>

                    </div>
                    <div class="form-group">

                        <label class="col-sm-2 control-label" for="year">Year</label>
                        <div class="col-sm-10">
                            <form:input type="text" path="year" id="year" class="form-control"/>
                            <form:errors path="year" class="help-inline text-danger"/>
                        </div>

                    </div>

                    <div class="form-group">

                        <label class="col-sm-2 control-label" for="isbnOrIssn">ISBN</label>
                        <div class="col-sm-10">
                            <form:input type="text" path="isbnOrIssn" id="isbnOrIssn" class="form-control"/>
                            <form:errors path="isbnOrIssn" class="help-inline text-danger"/>
                        </div>

                    </div>

                    <div class="form-group">

                        <label class="col-sm-2 control-label"
                               for="publisherId">Publisher </label>
                        <div class="col-sm-10">

                                <%--<div class="input-group">--%>
                            <h4><span class="glyphicon glyphicon-check"></span> select:</h4>
                            <form:select path="publisherId" id="publisher" class="form-control">
                                <c:forEach var="publisher" items="${publ}">

                                    <form:option value="${publisher.id}">
                                        <c:out value="${publisher.publisherName}, ${publisher.country}"/>
                                    </form:option>
                                </c:forEach>
                            </form:select>
                            <form:errors path="publisherId" class="help-inline text-danger"/>
                                <%--</div>--%>


                                <%--<form:select path="publisher" items="${publ}" multiple="true" itemValue="id"  itemLabel="publisherName" class="form input" />--%>
                        </div>

                    </div>

                    <div class="form-group">

                        <input id="create_new" type="submit" value="CREATE NEW BOOK" class="btn btn-primary"/>


                    </div>
                </form:form>
            </div>
            <div id="message">
                <c:choose>
                    <c:when test="${message}">
                        <h3> ${content} </h3>
                    </c:when>
                </c:choose>
            </div>
            <div class="footer pull-right">
                <p>&copyNepomnyachshaya L V, 2017</p>
            </div>

        </div>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/static/holder.js"></script>
    <script>
    function show() {
    $('#new_book_form').removeClass('hidden').addClass('active');
    }
    $(function () {
    $('#create_new_book').on('click', show);
    });
    </script>
    <script type="text/javascript" language="javascript">
        function savebook(e) {
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
            var url = "${pageContext.request.contextPath}/book/";
            $.ajax({
                type: 'POST',
                url: url,
                data: JSON.stringify(json),
                contentType: 'application/json; charset=utf-8',
                cache: false,
                success: function (result) {
                    $('body').html(result);
                    $('#new_book_form').removeClass('hidden').addClass('active');
                }
            });
            e.preventDefault
        }
        ;
        $(function () {
            $('#form_id').on('submit', savebook);
        });
    </script>
</div>
</body>
</html>


