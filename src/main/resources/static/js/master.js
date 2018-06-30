var username;

$(document).ready(function() {


  //getFilmes();
  $.getJSON("/salas", function(data) {
    var itens = [];

    $.each(data, function(i) {
      itens.push("<div class='myCard'><img class='img' src="+this.filme.imagemFilmeUrl+"><div class='info'><a class='nomeFilme' href='../cadeiras.html?nomeFilme="+this.filme.nomeFilme+"'>"+this.filme.nomeFilme+"</a></p></div></div>")
    });

    $("#myBodyContent").append(itens);
  });
});

$("#sair").click(function() {
    sessionStorage.removeItem('username');
    $(location).attr("href", "../../index.html");
});
$("#chat").click(function() {
    $(location).attr("href", "../../chat/public/index.html?"+username);
});

$(".searchInput").keydown(function(e) {
  if(e.which == 13) {
    var text = $(this).val();
    $("#myBodyContent").empty();
    $.getJSON("/salaFilme/"+text+"", function(data) {
      var itens = [];

      $.each(data, function(i) {
        itens.push("<div class='myCard'><img class='img' src="+this.filme.imagemFilmeUrl+"><div class='info'><a class='nomeFilme' href='../cadeiras.html?nomeFilme="+this.filme.nomeFilme+"'>"+this.filme.nomeFilme+"</a></p></div></div>")
      });

      $("#myBodyContent").append(itens);
    });
  }
})
