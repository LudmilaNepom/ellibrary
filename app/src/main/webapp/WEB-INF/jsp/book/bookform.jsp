<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script>
        function send_form(){
            $('#form_id').submit(function(event){
                event.preventDefault()
                $.ajax({
                    url: '/book/', // путь к обработчику
                    type: 'PUT', // метод передачи
                    data: this.data,
                    dataType: 'text/html',
                });
            });
            }
    </script>
    <title>Book form</title>
</head>
<body>
<div class="generic-container">
    <div class="header">Book Form</div>
    <form:form  id="form_id" modelAttribute="book" class="form-horizontal">
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
                    <form:input type="text" path="description" id="description" class="form input" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="cell">
                <label class="lable" for="year">Year</label>
                <div class="inp">
                    <form:input type="text" path="year" id="year" class="form input" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="cell">
                <label class="lable" for="isbnOrIssn">ISBN</label>
                <div class="inp">
                    <form:input type="text" path="isbnOrIssn" id="isbnOrIssn" class="form input" />
                </div>
            </div>
        </div>

        <%--<div class="row">--%>
            <%--<div class="cell">--%>
                <%--<label class="lable" for="publisher">Publisher</label>--%>
                <%--<div class="inp">--%>
                    <%--<form:select path="publisher" items="${publ}" multiple="true" itemValue="id" itemLabel="publisher" class="form input" />--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

       <div class="row">
            <div class="cell">
                <%--<input type="submit" value="Create" id="submit" onclick="send_form(form_id)" class="form input"/>--%>
                    <a href="#" class="add" onclick='send_form()'>Submit</a>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
