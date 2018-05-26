<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Templates/Header.jsp"/>

<div class="MainPage">
    <h2> Введите свой email:</h2>
    <form action="show" method="get">
        <input placeholder="Ваш email" name="Email" required type="text" id="emailInput">
        <button type="submit">Отобразить корзину</button>
    </form>

</div>

<jsp:include page="Templates/Footer.jsp"/>