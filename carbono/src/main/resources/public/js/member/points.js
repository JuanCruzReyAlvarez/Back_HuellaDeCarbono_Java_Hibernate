var searchInterval = null;
var newPoint = {};

var appendPointToTable = (point) => $("#points-table").append('<tr class="row-' + point.id + '">' +
                                    '<td>' + point.pais.nombre + '</td>' +
                                    '<td>' + point.provincia.nombre + '</td>' +
                                    '<td>' + point.municipio.nombre + '</td>' +
                                    '<td>' + point.localidad.nombre + '</td>' +
                                    '<td>' + point.calle + '</td>' +
                                    '<td>' + point.altura + '</td>' +
                                    '<td>' + point.detalle + '</td>' +
                                    '<td><button id="verTramosButton">Accion</button></td></tr>');

var newPointCreated = (point) => {
    showToast("<h5>Point Creado!<h5/>", "success")
    appendPointToTable(point);
  
    hideModal("agregar-point-modal");
}


var autocomplete = (params, callback) => {
    
    const renderResult = (item) => "<div class='autocomplete-result' label='" + 
                                    JSON.stringify(item) + "'>" + 
                                    item.nombre + 
                                    "</div>";

    const prevParam = (comp) => {
        let prev = $(comp).prev();
        if ($(prev).hasClass("field")) {
            let json = $((prev)[0]).children().last().val();
            try { return JSON.parse(json).id; } catch { return null; }
        }
        return null;
    }
    
    const nextActive = (comp) => {
        $(comp).removeClass("active");
        let nextcomp = $(comp).next();
        $(nextcomp).addClass("active");
    }

    const selectItem = (selected) => {
        let inputToShow = selected.parent().prev();
        inputToShow.val(selected.html());
        
        let hiddenInput = selected.parent().next();
        hiddenInput.val(selected.attr("label"))
        
        selected.parent().css("visibility", "hidden");
        selected.parent().html('')
        
        let title = $(".title.active")[0];
        nextActive(field);
        nextActive(title);
    }

    const callAutocomplete = (query) => $.ajax({
        url: "/member/points/autocomplete" + query,
        method: "GET",
        success: function(response) {
            let data = JSON.parse(response);
            results = "";
            data.forEach(d => results += renderResult(d));
            callback(results);
            $(".autocomplete-result").on("click", function() { selectItem($(this)) });
        },
    });

    let results = "";
    const field = $(".field.active")[0];
    let param = prevParam(field);

    if (param)
        params = {...params, id: param };
    
    callAutocomplete("?" + new URLSearchParams(params).toString());
}

var initNewPoint = function() {
    $(':input').val('');
    $(".active").removeClass("active");
    $(".form-field").first().addClass("active");
    $(".form-label").first().addClass("active");

    newPoint = {
        pais : null,
        provincia : null,
        municipio : null,
        localidad : null,
        calle : null,
        altura : null,
        detalle : null,
    }

    $(".autocomplete").on("keyup", function() {
        if ($(this).val().length >= 3) {
            clearInterval(searchInterval);
            
            searchInterval = setInterval(() => {
                clearInterval(searchInterval);
                
                let autocomp = $(this).next();
                let type = $(autocomp).attr("label")
                
                autocomp.html("");
                autocomp.css("visibility", "hidden");

                autocomplete({ type : type, q: $(this).val()}, (results) => {
                    autocomp.html(results)
                    autocomp.css("visibility", "visible");
                })
            }, 700);
        }
    })
}

$("#agregarPointButton").on("click", function(e) {
    e.preventDefault()
    modal("agregar-point-modal");
    setTimeout(() => initNewPoint(), 15);
})

$("#submitForm").on("click", function(e) {
    e.preventDefault();

    let data = {
        pais: JSON.parse($("#pais").val()),
        provincia: JSON.parse($("#provincia").val()),
        municipio: JSON.parse($("#municipio").val()),
        localidad: JSON.parse($("#localidad").val()),
        calle: $("#calle").val(),
        altura: $("#altura").val(),
        detalle: $("#detalle").val()
    }

    $.ajax({
        url: '/member/points',
        method: 'POST',
        data: JSON.stringify(data),
        success: (response) => {
            newPointCreated(JSON.parse(response));
        }
    })
})