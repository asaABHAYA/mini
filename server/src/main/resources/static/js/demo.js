const events = [
    { name: "Concert", date: "2024-04-20", category: "music" },
    { name: "Art Exhibition", date: "2024-04-25", category: "art" },
    { name: "Football Match", date: "2024-04-22", category: "sports" }
  ];
  
  const eventsList = document.getElementById("eventsList");
  const searchInput = document.getElementById("searchInput");
  const filterSelect = document.getElementById("filterSelect");
  const sortSelect = document.getElementById("sortSelect");
  
  function renderEvents() {
    eventsList.innerHTML = "";
    const filteredEvents = events.filter(event => {
      const searchValue = searchInput.value.toLowerCase();
      const filterValue = filterSelect.value;
      return (filterValue === "all" || event.category === filterValue) &&
             (event.name.toLowerCase().includes(searchValue) || event.category.toLowerCase().includes(searchValue));
    });
    const sortValue = sortSelect.value;
    filteredEvents.sort((a, b) => {
      if (sortValue === "name") {
        return a.name.localeCompare(b.name);
      } else if (sortValue === "date") {
        return new Date(a.date) - new Date(b.date);
      } else if (sortValue === "category") {
        return a.category.localeCompare(b.category);
      }
    });
    filteredEvents.forEach(event => {
      const eventElem = document.createElement("div");
      eventElem.classList.add("event");
      eventElem.innerHTML = `
        <h3>${event.name}</h3>
        <p>Date: ${event.date}</p>
        <p>Category: ${event.category}</p>
      `;
      eventsList.appendChild(eventElem);
    });
  }
  
  searchInput.addEventListener("input", renderEvents);
  filterSelect.addEventListener("change", renderEvents);
  sortSelect.addEventListener("change", renderEvents);
  
  renderEvents();