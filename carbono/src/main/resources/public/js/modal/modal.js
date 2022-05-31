var modal = function(id) {
    $("#" + id).addClass("carbono-modal");
    $("#" + id).removeClass("hidden");
    $("#" + id).addClass("shown");
}

var hideModal = function(id) {
    $("#" + id).addClass("hidden");
    $("#" + id).removeClass("shown");
}

$(".carbono-modal").on("click", function(e) {
    e.preventDefault();
    let modal = $(this);
    if (modal.hasClass("shown"))
        hideModal(modal.attr('id'))
}).children().click(function(e) {
    return false;
});