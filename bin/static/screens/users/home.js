var username;

$(document).ready(function() {
    username = sessionStorage.getItem("username");

    if(username == null) {
        $(location).attr("href", "../form-login.html");
    }

    //getFilmes();
});

function getFilmes() {
    var url = "/salas";

    $.getJSON(url, function(data) {
        var itens = [];

        $.each(data, function(i) {

            itens.push(
                "<a href='../cadeiras.html?nomeFilme="+this.filme.nomeFilme+"'>"+this.filme.nomeFilme+"</a></p>"
            );
        });
        $(".moviefeed").append(itens);
    });
}

$("#sair").click(function() {
    sessionStorage.removeItem('username');
    $(location).attr("href", "../form-login.html");
});

$("#chat").click(function() {
    $(location).attr("href", "../../chat/public/index.html?"+username);
});
