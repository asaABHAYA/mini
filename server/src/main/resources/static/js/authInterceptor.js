function authInterceptor(request) {

    const token = localStorage.getItem('authToken'); // Or fetch token from another source
    if (token) {
        request.headers.set('Authorization', `${token}`);
    }
    return request;
}

function setLoginToken(userName, password) {
    localStorage.setItem("authToken", btoa( userName + ":" + password));
}

function processAjaxData(response, urlPath){
    document.write(response);
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

function vaildateRegisterInfo(firstName, lastName, email, phoneNo){
    let userReg = /^(?=.{1,50}$)[a-z]+(?:['_.\s][a-z]+)*$/i
    let mailReg = /^\S+@\S+\.\S+$/
    let phoneReg = /^1[3456789]\d{9}$/;
    if (!userReg.test(firstName)){
        alert("Invalid first name");
        return false;
    }
    if (!userReg.test(lastName)){
        alert("Invalid last name");
        return false;
    }
    if (!mailReg.test(email)){
        alert("Invalid email");
        return false;
    }
    if(phoneReg.test(phoneNo)){
        alert("Invalid phoneNo");
        return false;
    }
    return true;
}


function addUserMutation(firstName, lastName, email, phoneNo, password){
    if (!vaildateRegisterInfo(firstName, lastName, email, phoneNo)) {
        console.log("Invalid register info");
        return null;
    }
    var mutation = `
             mutation AddUser {
                addUser(
                    userLoginInfo: {
                        firstName:"` + firstName + `",
                        lastName:"` + lastName + `",
                        email:"` + email + `",
                        phoneNo:` + phoneNo + `,
                        password:"` + password + `"
                     })
             }`;
    console.log("Mutation\n" + mutation);
    return fetch("/graphql", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify({query: mutation})
    }).then(r => {
      if (r.ok) {
          r.json().then(data =>{
              if(data.data.addUser) {
                  console.log("Successfully added user");
                  setLoginToken(firstName, password);
                  setTimeout(()=>redirect("/events.html"),  10)
              }
              else {
                  console.log("Failed to save user");
              }
          })

      }
      else{
          console.log("Failed to save user");
      }
    })
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
            "Authorization": "Basic " + auth.replace("=", "") + "="
        },
        success: function (response) {
            processAjaxData(response, url)

        }});
}