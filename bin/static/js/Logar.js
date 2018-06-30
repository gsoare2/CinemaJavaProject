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

