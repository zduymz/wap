$(function(){

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
})

