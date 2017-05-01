<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <meta charset="UTF-8"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <style type="text/css">
        #box {
            width: 1600px;
            display: block;
            margin: 20px auto 0px auto;
        }

        .title {
            width: 100%;
            color: steelblue;
            border: 1px solid transparent;
            text-align: center;
        }

        .inner_box_th {
            width: 198px;
            color: steelblue;
            float: left;
            border: 1px solid #000000;
            text-align: center;
        }

        .inner_box {
            width: 198px;
            float: left;
            border: 1px solid #000000;
            text-align: center;
        }

        .text {
            text-align: center;
        }

        .footer {
            position: absolute;
            bottom: 10%;
            width: 100%;
            float: left;
            text-align: right;

        }
    </style>
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
    <div class="inner_box">
        <p class="text"></p>
    </div>
    <div class="inner_box">
        <p class="text"></p>
    </div>
    <div class="inner_box">
        <p class="text"></p>
    </div>
    <div class="inner_box">
        <p class="text"></p>
    </div>
    <div class="inner_box">
        <p class="text"></p>
    </div>
    <div class="inner_box">
        <p class="text"></p>
    </div>
    <div class="inner_box">
        <p class="text"></p>
    </div>
    <div class="inner_box">
        <p class="text"></p>
    </div>
</div>
<div class="footer">
    <%--<p><a href="<c:url value='/'/>">HOME</a> </p>--%>
    <p><a href="${pageContext.request.contextPath}/">HOME</a></p>
    <p>&copyNepomnyachshaya L V, 2017</p>
</div>
</body>
</html>
