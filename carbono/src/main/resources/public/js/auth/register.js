$("#register-form").on("submit", (e) => {
    e.preventDefault();
    
    let request = {
        username : $("#username").val(),
        password : $("#password").val(),
        rol      : $("#rol").val()
    }

    console.log(request);

    $.ajax({
        url: "/register",
        method: "POST",
        data: JSON.stringify(request),
        success:function(response){
            // let data = JSON.parse(response);
            // location.href = data.uri
            console.log(response)
        },
        error: (response, jqXHR, textStatus, errorThrown) => {
            if (response.status === 400)
                handleFieldsErrors(JSON.parse(response.responseText));
            if (response.status > 400)
                handleError(response.responseText);
        }
    })
});

$("input").on("click", function(e) {
    $(this).removeClass("error");
});