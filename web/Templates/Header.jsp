<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="style/main.css" type="text/css" rel="stylesheet">
    <script src="script/main.js"></script>
    <title>ieCinema</title>
</head>
<body>
<div class="PreHeader">
    <div class="header">
        <img src="images/siteLogo.png" id="siteLogo">
        <div class="logoHeader">
            <span id="siteName"> ieCinema</span>
            <br>
            <span id="siteDescription"> Ваш проводник в мир кино!</span>
        </div>
        <div class="menu">
            <div class="menuItem" onclick="location.href='/'">
                <span class="ItemText">Новинки <br> кино</span>
            </div>
            <div class="menuItem" onclick="location.href='/find'">
                <span class="ItemText">Корзина</span>
            </div>
            <div class="menuItem" onclick="location.href='/reviews'">
                <span class="ItemText">Отзывы</span>
            </div>
            <div class="menuItem" onclick="location.href='/about'">
                <span class="ItemText">О кинотеатре</span>
            </div>
        </div>
    </div>
</div>
