<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="Templates/Header.jsp"/>
<div class="MainPage">
    <div class="filmCard">
        <img src="images/films/${film.id}.jpg" class="filmImage">
        <div class="filmDescription">
            <br> <span id="filmName"> ${film.name} </span>
            <br>
            <br>
            <%--<div class="filmParamName">Описание :</div>--%>
            <br> <span class="filmParam"> ${film.description} </span>
            <br>
            <br>
            <div class="filmParamName">Возрастное ограничение:</div>
            <span class="filmParam"> ${film.age} </span>
            <br>
            <div class="filmParamName">Продолжительность:</div>
            <span class="filmParam"> ${film.duration} мин</span>
            <br>
            <div class="filmParamName">Рейтинг :</div>
            <span class="filmParam"> ${film.rating}/10 Кинопоиск </span>
            <br>
            <br>
            <div class="filmParamName">Стоимость билета :</div>
            <span class="filmParam"> ${film.cost} грн </span>
        </div>
    </div>
    <h3> Стоимость билета ${film.cost} грн</h3>
    <input type="email" placeholder="Введите ваш Email" id="emailInput">
    <h2> Для покупки выберите место:</h2>
    <div class="places">
        <c:forEach var="line" items="${places}">

            <div class="placeLine">
                <c:forEach var="place" items="${line}">
                    <div class="selectPlace${place.modificator}"
                         onclick="buyTicket(${film.id}, ${place.num}, '${place.modificator}')">
                            ${place.num}
                    </div>
                </c:forEach>
            </div>
            <br>

        </c:forEach>


    </div>

</div>

<jsp:include page="Templates/Footer.jsp"/>