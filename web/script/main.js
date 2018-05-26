function buyTicket(film, place, modificator) {
    if (modificator == 'N'){
        alert("Это место уже занято!");
        return;
    }
    var email = document.getElementById("emailInput");
    var str = email.value;
    if (str != ""){
        var filmbox = document.getElementById("filmName");
        var filmName = filmbox.innerHTML;
        var isTrue = confirm("Фильм: " + filmName +
            "\nВыбранное место: " + place +
            "\nПочта: " + str +
            "\n\n  Всё верно?");
        if (isTrue) location.href="/buyTicket?film="+film+"&place="+place+"&email="+str;
    }else {
        email.className = "notEmail";
        email.focus();
        email.value="Введите email!";
        email.select();
    }

}
