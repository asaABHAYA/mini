function postSiteFeedBack(name, email , subject, message) {
    var mutation = `
             mutation MyMutation {
                  saveSiteFeedBackInfo(
                    siteFeedBack: {
                      email: "`+ email + `",
                      message: "`+ message + `",
                      name: "`+ name + `",
                      subject: "`+ subject + `"
                    }) {
                    name
                  }
            }`;
    //mutation = JSON.parse(mutation)
    console.log("Mutation\n" + mutation);
    fetch("/graphql", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify({query: mutation})
    }).then((r) => alert("Thank you for your feedback")).catch((e)=>{
            alert("Try again later\nCannot send feedback");
        }
    )
}

function getAllSiteFeedbacks() {
    var query = `
             query GetSiteFeedBackInfo {
                  getSiteFeedBackInfo {
                    email
                    message
                    name
                    subject
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
