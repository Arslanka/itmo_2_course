function openLink() {
    const a = 'https://t.me/IarslanT';
    window.open(a);
}

$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: '../php/query.php',
        success: (data) => $("#result_table tbody").html(data)
    });

    $("#form #submit").click(function () {
        if (!validateForm()) {
            return false;
        }

        const formData = $("#form").serializeArray();
        formData.push({"name" : "type", "value" : "update"});
        formData.push({"name": "local_time", "value" : new Date().toLocaleString()});

        $.ajax({
            type: 'POST',
            url: '../php/query.php',
            data: formData,
            success: (data) => $("#result_table tbody").html(data)
        });
    });

    $("#form #clear").click(function () {
        const formData = [];
        formData.push({"name" : "type", "value" : "clear"});
        //console.log(formData);

        $.ajax({
            type: 'POST',
            url: '../php/query.php',
            data: formData,
            success: (data) => $("#result_table tbody").html(data)
        });
    });
});