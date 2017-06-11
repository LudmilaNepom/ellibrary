<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<link>
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
                <li><a href="${pageContext.request.contextPath}/book/">Books</a></li>
                <li><a href="${pageContext.request.contextPath}/author/">Authors</a></li>
                <li><a href="${pageContext.request.contextPath}/publisher/">Publishers</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
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
                <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/book/">Books</a></li>
                <li><a href="${pageContext.request.contextPath}/author/">Authors</a></li>
                <li><a href="${pageContext.request.contextPath}/publisher/">Publishers</a></li>
            </ul>
            <ul class="nav nav-sidebar">

                <li><a href="${pageContext.request.contextPath}/logout/">Logout</a></li>
            </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Welcome to ellibrary</h1>

            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="${pageContext.request.contextPath}/static/1.jpg" width="200" height="200"
                         class="img-responsive" alt="Generic placeholder thumbnail">
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="${pageContext.request.contextPath}/static/2.jpg" width="200" height="200"
                         class="img-responsive" alt="Generic placeholder thumbnail">
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="${pageContext.request.contextPath}/static/4.jpg" width="200" height="200"
                         class="img-responsive" alt="Generic placeholder thumbnail">
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="${pageContext.request.contextPath}/static/3.jpg" width="200" height="200"
                         class="img-responsive" alt="Generic placeholder thumbnail">
                </div>
            </div>

            <h2 class="sub-header">Home page</h2>
            <table class="table table-striped">
                <tbody>
                <tr>
                    <%--<p><a href="<c:url value='/book'/>">books</a></p>--%>
                    <th><a href="${pageContext.request.contextPath}/book/">books</a></th>
                </tr>
                <tr>
                    <%--<p><a href="<c:url value='/author'/>">authors</a></p>--%>
                    <th><a href="${pageContext.request.contextPath}/author/">authors</a></th>
                </tr>
                <tr>
                    <%--<p><a href="<c:url value='/category'/>">categories</a></p>--%>
                    <th><a href="${pageContext.request.contextPath}/category/">categories</a></th>
                </tr>
                <tr>
                    <%--<p><a href="<c:url value='/category'/>">categories</a></p>--%>
                    <th><a href="${pageContext.request.contextPath}/publisher/">publishers</a></th>

                </tr>
                </tbody>
            </table>
            <div class="footer pull-right">
                <p>&copyNepomnyachshaya L V, 2017</p>
            </div>
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
</body>
</html>

