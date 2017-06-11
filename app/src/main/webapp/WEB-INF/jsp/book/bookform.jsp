<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<title>Book form</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
      crossorigin="anonymous">


<link href="${pageContext.request.contextPath}/static/app.css" rel="stylesheet">

<style>
    .glyphicon.glyphicon-book {
        margin-left: 20pt;
        font-size: 7em;
    }
    .addclass {
        color: cadetblue !important;
        background: cadetblue !important;
        background-color: cadetblue !important; ;
    }
    </style>
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
                <li class="active"><a href="#">Book form</a></li>
            </ul>

        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="bg-info"><span class="glyphicon glyphicon-book" aria-hidden="true"></span></li>
            </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h1 class="page-header bg-info">Book Form</h1>


            <form:form id="form_id" modelAttribute="bookFromView" action="javascript:void(null);"
                       class="form-horizontal">
            <form:input type="hidden" path="id" id="id"/>

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

                <label class="col-sm-2 control-label" for="publisher">Publisher</label>
                <div class="col-sm-10">

                    <h4><span class="glyphicon glyphicon-check"></span> select:</h4>
                    <form:select path="publisherId" id="publisher" class="form-control">
                        <c:forEach var="publisher" items="${publ}">
                            <form:option value="${publisher.id}"><c:out
                                    value="${publisher.publisherName}, ${publisher.country}"/></form:option>
                        </c:forEach>
                    </form:select>
                        <form:errors path="publisherId" class="help-inline"/>
                        <%--<form:select path="publisher" items="${publ}" multiple="true" itemValue="id"  itemLabel="publisherName" class="form input" />--%>
                </div>

            </div>

            <div class="form-group">
                <div class="col-sm-3">
                    <button type="submit" value="edit" class="btn btn-warning">EDIT</button>
                </div>
                <div class="col-sm-3">
                    <button id="delete" type="button" value="delete" class="btn btn-danger">DELETE</button>
                </div>
                <div class="col-sm-6">
                    <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/book/">Back to books</a>
                </div>
            </div>
                    </form:form>

            <div id="message">
                <c:choose>
                    <c:when test="${message}">
                        <h2 class="text-info bg-info"> ${content} </h2>
                    </c:when>
                </c:choose>
            </div>
            <div class="footer pull-right">
                <p><a href="${pageContext.request.contextPath}/">HOME</a></p>
                <p>&copyNepomnyachshaya L V, 2017</p>
            </div>


                </div>
            </div>
        </div>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
                crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/static/holder.js"></script>
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
                        $('body').html(result);
                        $("input").prop('disabled', true);
                    }
                });
                e.preventDefault
            }
            ;
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
                        $('body').html(result);
                        $("input").prop('disabled', true);
                        $(".form-group .col-sm-3 button").remove();
                    }
                });

            }
            ;
            $(function () {
                $('#form_id').on('submit', updatebook);
            });
            $(function () {
                $('#delete').on('click', deletebook);
            });
        </script>

</body>
</html>


