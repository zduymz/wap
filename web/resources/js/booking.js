$(function(){

    //hide confirm button
    $("#confirm_submit").hide();

    function getCookie(cname) {
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for(var i = 0; i <ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }

    function clickConfirmEvent(evt) {
        let uid = getCookie("login_id");
        if (uid == "") {
            // in case shit happen
            window.location.href = '/index';
        } else {

            if (parseInt($("#seatNo").val()) != 0) {
                //show popup
                alert("you need to fill all seat");
                return false;
            }

            $("#noTicket_id").val($("#seat").text());
            $("#ticketPrice_id").val($("#total-price").text());
            $("#confirm_submit").click();
        }
    }

    function updateSeat(){
        $("#seat").text("");
        $(".seat-col li[class=active]").each(function(){
            let self = $(this);
            let seatR = self.parents("[class=seat-row]").find("li[class=index]").first().text();
            let seatN = self.text();
            let currentSeat = $("#seat").text();
            let newValue = currentSeat + ", " + seatR + seatN;
            $("#seat").text(newValue.replace(/^,/,""));
        })
    }

    function updatePrice() {
        $("#total-price").text("");
        let totalprice = 0;
        $(".seat-col li[class=active]").each(function(){
            totalprice += parseInt($("#tprice").val());
        });
        $("#total-price").text(totalprice);
    }

    $(".seat-col li").not("[class=selected]").click(function(){
        let self = $(this);
        let seatNo = parseInt($("#seatNo").val());
        if (self.attr("class") == "active") {
            $("#seatNo").val(seatNo + 1);
            self.removeClass("active");
            updateSeat();
            updatePrice();
            return;
        }
        if (seatNo > 0) {
            $("#seatNo").val(seatNo - 1);
            self.addClass("active");
            updateSeat();
            updatePrice();
        }
    })

    $("div .select-ticket").click(clickConfirmEvent);
})

