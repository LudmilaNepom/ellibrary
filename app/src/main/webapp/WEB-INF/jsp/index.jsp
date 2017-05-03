<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <meta charset="UTF-8"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <style type="text/css">
        #box {
            position: relative;
            width: 1200px;
            display: block;
            margin: 20px auto 0px auto;
            height: 98%;
        }

        .inner {
            width: 198px;
            padding: 10pt;
            background-color: lightyellow;
            float: left;
            border: 1px solid #000000;
            text-align: left;
        }

        .footer {
            position: absolute;
            bottom: 0;
            width: 95%;
            float: left;
            text-align: right;

        }

        .text {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="box">
    <div>
        <h1 class="text">welcome to ellibrary</h1>
    </div>
    <div class="inner">
        <%--<p><a href="<c:url value='/book'/>">books</a></p>--%>
        <p><a href="${pageContext.request.contextPath}/book/">books</a></p>
    </div>
    <div class="inner">
        <%--<p><a href="<c:url value='/author'/>">authors</a></p>--%>
        <p><a href="${pageContext.request.contextPath}/author/">authors</a></p>
    </div>
    <div class="inner">
        <%--<p><a href="<c:url value='/category'/>">categories</a></p>--%>
        <p><a href="${pageContext.request.contextPath}/category/">categories</a></p>
    </div>
    <div class="footer">
        <p>&copyNepomnyachshaya L V, 2017</p>
    </div>
</div>


</body>
</html>