<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="Templates/Header.jsp"/>
<div class="MainPage">
    <c:forEach var="item" items="${reviews}">
        <div class="review" style="margin-left: 0">
            <span class="reviewTitle">
                ${item.name}  о фильме ${item.film}</span>
            <hr>
            <p class="reviewText"> ${item.review}</p>
        </div>
    </c:forEach>

    <h2> Новый отзыв:</h2>
    <form class="review" style="padding: 30px; width: 600px" method="get" action="/reviews">
        <input style="font-size:13pt" placeholder="Отображаемое имя" name="name" required type="text">
        <input style="font-size:13pt" placeholder="Фильм" name="film" type="text"><br><br>

        <textarea name="text" placeholder="Ваш отзыв" id="rewiewText"></textarea>
        <br>
        <button type="submit" style="width: 150px; left: 0" class="buyTicket">Отправить</button>
    </form>

</div>
<jsp:include page="Templates/Footer.jsp"/>