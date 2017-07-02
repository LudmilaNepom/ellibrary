<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<title>view book</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
      crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/static/app.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/bootstrap-rating-master/bootstrap-rating.css" rel="stylesheet">

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
            <h3>Current rating:<input type="hidden" class="rating" data-fractions="2" value="${rating}" disabled="disabled"/></h3>
            <h3>Vote:<input type="hidden" class="rating" data-fractions="2" value="0"/></h3>


            <form:form id="form_id" modelAttribute="bookFromView" action="javascript:void(null);"
                       class="form-horizontal">
                <form:input type="hidden" path="id" id="id"/>

                <div class="form-group">

                    <label class="col-sm-2 control-label" for="name">Name</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="name" id="name" disabled="true" class="form-control"/>
                    </div>


                </div>

                <div class="form-group">

                    <label class="col-sm-2 control-label" for="description">Description</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="description" id="description" disabled="true" class="form-control"/>
                    </div>

                </div>

                <div class="form-group">

                    <label class="col-sm-2 control-label" for="year">Year</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="year" id="year" disabled="true" class="form-control"/>
                    </div>


                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="isbnOrIssn">ISBN</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="isbnOrIssn" id="isbnOrIssn" disabled="true" class="form-control"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="${book.publisher.publisherName}">Publisher</label>
                    <div class="col-sm-10">
                        <input type="text" path="${book.publisher.publisherName}" value="${book.publisher.publisherName} ${book.publisher.country}" disabled="true" class="form-control"/>
                    </div>
                </div>

                <div class="col-sm-12">
                    <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/book/">Back to books</a>
                </div>
            </form:form>

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
<script src="${pageContext.request.contextPath}/static/bootstrap-rating-master/bootstrap-rating.js"></script>
<script type="text/javascript" language="javascript">
    $('input').on('change', function () {
        alert('You set raiting: ' + $(this).val());
        var data="rating="+$(this).val();
        var url = "${pageContext.request.contextPath}/book/${bookFromView.id}/vote";
        $.post(url, data);
    });

</script>

</body>
</html>


