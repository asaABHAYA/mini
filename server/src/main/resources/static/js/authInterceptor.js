function authInterceptor(request) {

    const token = localStorage.getItem('authToken'); // Or fetch token from other source
    if (token) {
        request.headers.set('Authorization', `${token}`);
    }
    return request;
}

function processAjaxData(response, urlPath){
    document.write(response);
    //document.title = response.pageTitle;
    window.history.pushState({},"", urlPath);
}

function loginRequest(auth){
    try {
        localStorage.setItem("authToken", auth);
        redirect("/events.html")
    }catch (err){
        console.log(err);
    }

}
function getHTML(url, auth){
    $.ajax({
        type: "GET",
        url: url,
        dataType: "html",
        async: false,
        headers: {
            "Authorization": auth
        },
        success: function (response) {
            self.addEventListener("fetch", (event) => {
                var currentUrl = new URL(event.request.url);
                if (currentUrl.origin === location.origin){
                    var newRequest = new Request(event.request, {
                        mode: "cors",
                        credentials: "same-origin",
                        headers: {
                            "Authorization": auth
                        }
                    });
                    event.respondWith(fetch(newRequest));
                }
                else {
                    event.respondWith(fetch(event.request));
                }
            });
            processAjaxData(response, url)
        }
    });

}

function redirect(url) {
    var auth = localStorage.getItem("authToken");
    $.ajax({
        type: "GET",
        url: url,
        dataType: "html",
        async: false,
        headers: {
            "Authorization": auth
        },
        success: function (response) {
            processAjaxData(response, auth)

        }});
}