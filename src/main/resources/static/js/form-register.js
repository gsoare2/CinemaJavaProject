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