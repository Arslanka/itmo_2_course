function openLink() {
    const a = 'https://t.me/IarslanT';
    window.open(a);
}

$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'handler.php',
        success: (data) => $("#result_table tbody").html(data)
    });

    $("#form #submit").click(function (event) {
        if (!validate_form()) {
            return false;
        }

        const formData = $("#form").serializeArray();
        formData.push({"name" : "type", "value" : "update"});
        formData.push({"name": "local_time", "value" : new Date().toLocaleString()});
        // console.log(formData);

        $.ajax({
            type: 'POST',
            url: 'handler.php',
            data: formData,
            success: (data) => $("#result_table tbody").html(data)
        });
        event.preventDefault();
    });

    $("#form #clear").click(function (event) {
        const formData = [];
        formData.push({"name" : "type", "value" : "clear"});
        console.log(formData);

        $.ajax({
            type: 'POST',
            url: 'handler.php',
            data: formData,
            success: (data) => $("#result_table tbody").html(data)
        });
        event.preventDefault();
    });
});