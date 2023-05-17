<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-xxxxxx" crossorigin="anonymous" />
    <link rel="shortcut icon" href="<c:url value='/favicon.ico' />" type="image/x-icon" sizes="16x16">
    <title>JSP Page</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;900&display=swap');

        input {
            caret-color: red;
        }

        body {
            margin: 0;
            width: 100vw;
            height: 100vh;
            background: #ecf0f3;
            display: flex;
            align-items: center;
            text-align: center;
            justify-content: center;
            place-items: center;
            overflow: hidden;
            font-family: poppins;
        }

        .container {
            position: relative;
            width: 350px;
            height: 500px;
            border-radius: 20px;
            padding: 40px;
            box-sizing: border-box;
            background: #ecf0f3;
            box-shadow: 14px 14px 20px #cbced1, -14px -14px 20px white;
        }


        .inputs {
            text-align: left;
            margin-top: 30px;
        }

        label, input, button {
            display: block;
            width: 100%;
            padding: 0;
            border: none;
            outline: none;
            box-sizing: border-box;
        }

        label {
            margin-bottom: 4px;
        }

        label:nth-of-type(2) {
            margin-top: 12px;
        }

        input::placeholder {
            color: gray;
        }

        input {
            background: #ecf0f3;
            padding: 10px;
            padding-left: 20px;
            height: 50px;
            font-size: 14px;
            border-radius: 50px;
            box-shadow: inset 6px 6px 6px #cbced1, inset -6px -6px 6px white;
        }

        button {
            color: white;
            margin-top: 20px;
            background: #1DA1F2;
            height: 40px;
            border-radius: 20px;
            cursor: pointer;
            font-weight: 900;
            box-shadow: 6px 6px 6px #cbced1, -6px -6px 6px white;
            transition: 0.5s;
        }

        button:hover {
            box-shadow: none;
        }

        /*a {*/
        /*    position: absolute;*/
        /*    font-size: 8px;*/
        /*    bottom: 4px;*/
        /*    right: 4px;*/
        /*    text-decoration: none;*/
        /*    color: black;*/
        /*    background: yellow;*/
        /*    border-radius: 10px;*/
        /*    padding: 2px;*/
        /*}*/

        h1 {
            position: absolute;
            top: 0;
            left: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="inputs">
        <form action="/login/authen" method="post">
        <div>
            <label>EMAIL</label>
            <input type="email" placeholder="example@test.com" name="email" id="email" />
            <c:if test="${not empty error}">
                <div class="error-message">${error}</div>
            </c:if>
        </div>
        <div>
            <label>PASSWORD</label>
            <input type="password" placeholder="Min 6 charaters long" name="password" id="password" />
            <c:if test="${not empty error}">
                <div class="error-message">${error}</div>
            </c:if>
        </div>
        <button type="submit">LOGIN</button>
        <button><a href="/oauth2/authorization/google"><i class="fab fa-google"></i>
            Login With Google</a></button>
        </form>
    </div>
</div>
</body>
</html>