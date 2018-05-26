<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Templates/Header.jsp"/>

<div class="MainPage">
    <h2>Результат поиска для ${email}</h2>
    <div class="allTickets">
        <c:forEach var="item" items="${tickets}">
            <div class="myTicket">
                <img class="ticketImg" src="images/films/${item.film}.jpg">
                <div class="ticketName" style="font-size: 16pt">${item.filmname}
                <br>${item.place} место</div>
            </div>
        </c:forEach>
    </div>

</div>
</p>
</div>
<jsp:include page="Templates/Footer.jsp"/>