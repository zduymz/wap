$(function(){

    function updateTicket(data) {
        for(let item of data) {
            let row = $("<tr>");
            let ticketid = $("<td>").text(item.id);
            let movieName = $("<td>").text(item.movieobj.name);
            let cinemaname = $("<td>").text(item.cinemaobj.name);
            let timeshow = $("<td>").text(item.timeShow);
            let seats = $("<td>").text(item.seats);
            let price = $("<td>").text("$"+item.price);
            row.append(ticketid);
            row.append(movieName);
            row.append(cinemaname);
            row.append(timeshow);
            row.append(seats);
            row.append(price);
            $("#tickettable").append(row);
        }
    }

    $.get("/ticketinfo")
        .done(updateTicket)
        .fail();
})