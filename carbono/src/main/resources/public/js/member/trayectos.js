var searchInterval = null;
var mapEnabledForMarking = false;
var mapMarker = null;
var newTrayecto = {};

var map = null;

var autocomplete = function(params, callback) {
    let results = "";
    let query = "?" + new URLSearchParams(params).toString();
    console.log(query)

    $.ajax({
        url: "/member/trayectos/autocomplete" + query,
        method: "GET",
        success:function(response) {
            let data = JSON.parse(response);
            results = "";
            data.forEach(d => results += "<div class='autocomplete-result' label='" + JSON.stringify(d) + "'>" + d.label + "</div>");

            if (params.type === "point" && (!data || data.length === 0))
                results += "<div label='/member/points' class='autocomplete-result-create'>Crear Nuevo Punto</div>";

            callback(results);

            $(".autocomplete-result-create").on("click", function() {
                window.open($(this).attr("label"), "_blank");
            });

            $(".autocomplete-result").on("click", function() {
                if ($(this).parent().hasClass("origen")){
                    newTrayecto.origen = JSON.parse($(this).attr("label"))
                    $("#origen").val(newTrayecto.origen.label);
                }
                else if ($(this).parent().hasClass("destino")) {
                    newTrayecto.destino = JSON.parse($(this).attr("label"))
                    $("#destino").val(newTrayecto.destino.label);
                }

                $(this).parent().css("visibility", "hidden");
                $(this).parent().html('')
            });
        },
    });
}

var initNewTrayecto = function() {
    newTrayecto = {
        origen : {
            isOrg : false
        },
        destino : {
            isOrg : true
        },
        tramos : []
    }
    $(".horizontal-options span").removeClass("selected");
    $("#origen-type span").last().addClass("selected");
    $("#destino-type span").first().addClass("selected");

    $(".autocomplete").on("keyup", function() {
        if ($(this).val().length >= 3) {
            clearInterval(searchInterval);
            searchInterval = setInterval(() => {
                clearInterval(searchInterval);
                let type = $(this).prev().children(".selected").first().attr("label");
                console.log()
                let autocomp = $(this).next();
                autocomp.html("");
                autocomp.css("visibility", "hidden");
                autocomplete({ 
                    type : type, 
                    q: $(this).val()
                }, (results) => {
                    autocomp.html(results)
                    autocomp.css("visibility", "visible");
                })
            }, 700);
        }
    })
}

$("#agregarTrayectoButton").on("click", function(e) {
    e.preventDefault()
    modal("agregar-trayecto-modal");
    setTimeout(() => initNewTrayecto(), 15);
})

$(".horizontal-options").on("click", function() {
    $(this).children().removeClass("selected");
    if ($(this).attr("id").includes("origen"))
        $("#origen").val('')
    else if ($(this).attr("id").includes("destino"))
        $("#destino").val('')

}).children().click(function(e) {
    setTimeout(() => $(this).addClass("selected"), 15);
});

$("#new-trayecto-tabs").on("click", function() {
    $(this).siblings().css("visibility", "hidden");
    $(this).children().removeClass("active");
}).children().click(function(e) {
    e.preventDefault();
    setTimeout(() => {
        $(this).addClass("active");
        let tabContent = $($(this).children()[0]).attr("href");
        $(tabContent).css("visibility", "visible");
    }, 15); 
});
