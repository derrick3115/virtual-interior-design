$(document).ready(function(){
    $("#signIn").hide();
    $("#goToSignInSection").click(function(){
        $("#signInSection").toggleClass("signIn");
        $("#login, #signIn").toggle();
    });
});
