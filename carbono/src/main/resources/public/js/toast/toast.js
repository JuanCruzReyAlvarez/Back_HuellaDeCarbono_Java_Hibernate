const showToast = (display, severity) => {
    const toast = $("#toast");
    toast.html(display);
    toast.addClass("toast-" + severity);
    toast.slideToggle();
    setTimeout(() => { toast.slideToggle() }, 3000);
}

const handleFieldsErrors = (errors) => {
    let errorDisplay = $('<ul></ul>');

    Object.entries(errors).forEach(entry => {
        const [key, value] = entry;
        $("#" + key).addClass("error");
        errorDisplay.append("<li>" + value + "</li>");
    });

    showToast(errorDisplay, "error");
}

const handleError = (message) => {
    let errorDisplay = $('<h5><u><b>' + message + '</b></u></h5>');
    showToast(errorDisplay, "error");
}