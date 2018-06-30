$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  var $this = $(this),
  label = $this.prev('label');

  if (e.type === 'keyup') {
    if ($this.val() === '') {
      label.removeClass('active highlight');
    } else {
      label.addClass('active highlight');
    }
  } else if (e.type === 'blur') {
    if( $this.val() === '' ) {
      label.removeClass('active highlight');
    } else {
      label.removeClass('highlight');
    }
  } else if (e.type === 'focus') {
    if( $this.val() === '' ) {
      label.removeClass('highlight');
    }
    else if( $this.val() !== '' ) {
      label.addClass('highlight');
    }
  }
});

$('.tab a').on('click', function (e) {
  e.preventDefault();

  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');

  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  $(target).fadeIn(600);
});

$("#form").submit(function(event) {
    event.preventDefault();
    var username = $("#username").val().toLowerCase();
    var password = $("#password").val().toLowerCase();

    console.log(username);

    $.post("/login/usuario", JSON.stringify({'username': username, 'password': password}), function(data){
        console.log("mano....");
        if(data) {
            sessionStorage.setItem("username", data.username)
            if(data.admin == 1) {
                $(location).attr('href', '../screens/admin/home.html');
            }
            else {
                console.log(data);
                $(location).attr('href', '../screens/users/home.html');
            }
        } else {
            $(".aux").show();
        }
    }, "json");
});

$("#form").submit(function(e) {
    e.preventDefault();

    var firstName = $("#firstName").val().toLowerCase();
    var lastName = $("#lastName").val().toLowerCase();
    var cpf = $("#cpf").val().toLowerCase();
    var email = $("#email").val().toLowerCase();
    var username = $("#username").val().toLowerCase();
    var password = $("#password").val().toLowerCase();
    var confirmPassword = $("#confirmPassword").val().toLowerCase();
    var nomePessoaCartao = $("#nomePessoaCartao").val().toLowerCase();
    var numeroCartao = $("#numeroCartao").val().toLowerCase();
    var numeroSeguranca = $("#numeroSeguranca").val().toLowerCase();
    var bandeiraCartao = $("#bandeiraCartao").val().toLowerCase();
    var dataVencimento = $("#dataVencimento").val().toLowerCase();
    var aux = dataVencimento.split("/");
    var dia = aux[0];
    var mes = aux[1];
    var ano = aux[2];

    if(password != confirmPassword) {
        //warning
    }
    else {
        $.post("/usuario/addUsuario", JSON.stringify({'firstName': firstName, 'lastName': lastName, 'cpf': cpf, 'email': email, 'username': username, 'password': password, 'nomePessoaCartao': nomePessoaCartao, 'numeroCartao': numeroCartao, 'numeroSeguranca': numeroSeguranca, 'bandeiraCartao': bandeiraCartao, 'dia': dia, 'mes': mes, 'ano': ano}), function(data) {
            if(data) {
                $(location).attr('href', '../screens/form-login.html');
            }
            else {
                console.log("erro");
            }
        }, "json");
    }

});
