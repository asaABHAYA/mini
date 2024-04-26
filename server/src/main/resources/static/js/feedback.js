function toFeedback(url){
    localStorage.setItem("prevPageUrl", url)
    if (localStorage.getItem("userName") === null){
        alert("Please sign in to your account to add feedback")
        window.location.replace("/login.html")
    }else {
        window.location.replace("/starfeed.html")
    }
}

function postFeedBack(msg, loc, rating) {
    var user = localStorage.getItem("userName")
    if (user === null) {
        return false
    }
    var mutation = `
             mutation AddFeedback {
                addFeedback(
                    feedBackInfo: {
                        feedbackMessage:"` + msg + `",
                        location:` + loc + `,
                        rating:` + rating + `,
                        userName:"` + user + `",
                     }){
                    userName
                }
             }`;
    //mutation = JSON.parse(mutation)
    console.log("Mutation\n" + mutation);
    return fetch("/graphql", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify({query: mutation})
    })
}