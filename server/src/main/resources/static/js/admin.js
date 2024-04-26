
function processAjaxData(response, urlPath){
    document.write(response);
    console.log("Done")
    window.history.pushState({},"", urlPath);
}

function redirect(url) {
    var auth = localStorage.getItem("authToken");
    $.ajax({
        type: "GET",
        url: url,
        dataType: "html",
        async: false,
        headers: {
            "Authorization": "Basic " + auth.replace("=", "") + "="
        },
        success: function (response) {
            processAjaxData(response, url)

        }});
}

function addEvent() {
    redirect("/addevent.html")
}
function addCat() {
    redirect("/addcat.html")
}

function dash() {
    redirect("/dash.html")
}