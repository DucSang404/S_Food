<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Multi-Step Registration Form</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="<c:url value='/static/register/style.css' />" rel="stylesheet" type="text/css" />
</head>

<body>
<dec:body/>

<script>
    document.querySelector('.next').addEventListener('click', () => {
        const container = document.querySelector('.container');
        const step1 = document.querySelector('#step1');
        const step2 = document.querySelector('#step2');

        // Switch states
        step1.style.display = 'none';
        step2.style.display = 'block';
        container.classList.add('active');
    });

    document.querySelector('.back').addEventListener('click', () => {
        const container = document.querySelector('.container');
        const step1 = document.querySelector('#step1');
        const step2 = document.querySelector('#step2');

        // Switch back to Step 1
        step2.style.display = 'none';
        step1.style.display = 'block';
        container.classList.remove('active');
    });
</script>
</body>

</html>