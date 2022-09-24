$(function () {
    $("#form #submit").click(function (event) {
       validateForm();
        event.preventDefault();
    });
});


function myLink(){
    const tg="https://t.me/IarslanT";
    window.open(tg);
}