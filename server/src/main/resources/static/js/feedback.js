function toFeedback(url, eventName){
    localStorage.setItem("prevPageUrl", url)
    localStorage.setItem("eventName", eventName)
    if (localStorage.getItem("userName") === null){
        alert("Please sign in to your account to add feedback")
        window.location.replace("/login.html")
    }else {
        window.location.replace("/starfeed.html")
    }
}

function postFeedBack(msg, loc, rating) {
    var user = localStorage.getItem("userName")
    var eventName = localStorage.getItem("eventName")
    if (user === null || eventName === null) {
        return false
    }
    var mutation = `
             mutation AddFeedback {
                addFeedback(
                    feedBackInfo: {
                        feedbackMessage:"` + msg + `",
                        location:` + loc + `,
                        eventName:"` + eventName + `",
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

function getAllFeedbacks() {
    var query = `
             query GetAllFeedBackInfo {
                  getAllFeedBackInfo {
                    feedbackMessage
                    location
                    eventName
                    rating
                    userName
                  }
    }`;
    return fetch("/graphql", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify({query: query})
    })
}

function toStars(rating){
    var stars;
    switch (rating) {
        case "FIVE_STARS":
            stars = "⭐️⭐️⭐️⭐️⭐️️️️";
            break
        case "FOUR_STARS":
            stars = "⭐️⭐️⭐️⭐️️️️";
            break
        case "THREE_STARS":
            stars = "⭐️⭐️⭐️️️️️";
            break
        case "TWO_STARS":
            stars = "⭐️⭐️️️️";
            break
        case "ONE_STAR":
            stars = "⭐️";
            break
        default:
            stars = "⭐️";
    }
    return stars
}