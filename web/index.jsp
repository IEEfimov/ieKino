<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="Templates/Header.jsp"/>
<div class="MainPage">


        <c:forEach var="row" items="${films}">
            <div class="filmCard">
                <img src="images/films/${row.id}.jpg" class="filmImage">
                <div class="filmDescription">
                    <br> <span class="filmName"> ${row.name} </span>
                    <br>
                    <br>
                    <%--<div class="filmParamName">Описание :</div>--%>
                    <br> <span class="filmParam"> ${row.description} </span>
                    <br>
                    <br>
                    <div class="filmParamName">Возрастное ограничение:</div>
                    <span class="filmParam"> ${row.age} </span>
                    <br>
                    <div class="filmParamName">Продолжительность:</div>
                    <span class="filmParam"> ${row.duration} мин</span>
                    <br>
                    <div class="filmParamName">Рейтинг :</div>
                    <span class="filmParam"> ${row.rating}/10 Кинопоиск </span>
                    <br>
                    <br>
                    <div class="filmParamName">Стоимость билета :</div>
                    <span class="filmParam"> ${row.cost} грн </span>
                    <div class="buyTicket" onclick="location.href='buy?Id=${row.id}'"> Купить билет</div>
                </div>
            </div>
        </c:forEach> </span>
</div>

<jsp:include page="Templates/Footer.jsp"/>