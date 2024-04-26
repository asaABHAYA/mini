function getAllUsers() {
    var query = `
         query GetAllUserLoginInfo {
              getAllUserLoginInfo {
                email
                firstName
                lastName
                phoneNo
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