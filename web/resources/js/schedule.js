
function enableLogin(evt) {
    $("#id01").css("display", "block");
    rememberMeCheck();
    evt.stopPropagation();
}

function disableLogin(evt) {
    if(evt.target == $("#id01")[0]){
        $("#id01").hide();
        evt.stopPropagation();
    }
}

function enableRegister(evt) {
    $("#id02").css("display", "block");
    evt.stopPropagation();
}

function disableRegister(evt){
    if (evt.target == $("#id02")[0]) {
        $("#id02").hide();
        evt.stopPropagation();
    }
}

function disablePopup(evt){
    $("#popupContent").text("");
    $("#id03").hide();
    evt.stopPropagation();
}

// function checkPassword() {
//     var password = $("#id02 input[name='upassword']").val();
//     var confirm_password = $("#id02 input[name='upasswordCheck']").val();
//
//     function validatePassword(){
//         if(password.value != confirm_password.value) {
//             confirm_password.setCustomValidity("Passwords Don't Match");
//         } else {
//             confirm_password.setCustomValidity('');
//         }
//     }
//
//     password.onchange = validatePassword;
//     confirm_password.onkeyup = validatePassword;
// }


function getMovieList() {

    function decorateMovie(data){

        function getCinema(self) {

            function decorateCinema(data) {

                function getTime(self) {
                    function decorateTime(data) {
                        $("#col-m-3 li[class=fake]").hide();
                        $("#col-m-3 li").not("[class=fake]").remove();

                        function showTicketPick(self) {
                            $("#col-m-3 .showtime-row input").hide();
                            $("#col-m-3 .showtime-row a").css("color", "#555");
                            self.css("color", "#f26b38")
                            $("#col-m-3 .showtime-row input").val("");
                            $("#click-continue").hide();
                            $("#time_id").val(self.parent().children("p").text() +" " + self.text());
                            self.parent().children("input[class=showtimes-tickets]").show();
                        }

                        // console.log(data);
                        for (let item of data) {
                            let li = $("<li>");
                            let div = $("<div>", {"class": "showtime-row"});
                            let p = $("<p>").text(item.dayOfWeekLabel + " " + item.showDate);
                            div.append(p);
                            for (let t of item.showTime) {
                                let a = $("<a>", {"class": "showtimes-list"}).text(t);
                                a.click(function(evt){
                                    let self = $(this);
                                    showTicketPick(self);
                                    evt.stopPropagation();
                                })
                                div.append(a);
                            }
                            let input = $("<input>", {"type": "text", "class":"showtimes-tickets", "placeholder": "Ticket"}).hide();
                            input.keyup(checkNumberOnly());
                            div.append(input);
                            li.append(div);
                            $("#col-m-3 .list-group").append(li);
                        }

                    }

                    const cinema_id = self.children("input[name=cinemaId]").val();
                    const movie_id = $("#movie_id").val();
                    $("#cinema_id").val(cinema_id);
                    $("#col-m-2").find(".showtime-row p").css("color", "#555");
                    self.find(".showtime-row p").css("color", "#f26b38");

                    $.get("/showtime/movieid="+ movie_id +",cinemaid=" + cinema_id)
                        .done(decorateTime)
                        .fail()
                    // let dumpdata = [{"showDate":"2/14/2018","dayOfWeekLabel":"Wed","showTime": ["14:30", "15:40", "18:30"]},
                    //     {"showDate":"2/15/2018","dayOfWeekLabel":"Thu","showTime": ["10:30", "11:40", "12:30", "12:30", "12:30", "12:30"]}];
                    // decorateTime(dumpdata);
                }

                $("#col-m-2 li[class=fake]").hide();
                $("#col-m-2 li").not("[class=fake]").remove();
                for(let item of data) {
                    console.log(item);
                    let li = $("<li>");
                    let div1 = $("<div>", {"class": "showtime-row"});
                    let p = $("<p>").text(item.name);
                    let p2 = $("<p>", {"class": "title-sub"}).text(item.address);
                    let hidden = $("<input>", {"name":"cinemaId", "type": "hidden", "value": item.id});

                    // add li listener
                    li.click(function(){
                        let self = $(this);
                        getTime(self);
                    })

                    $("#col-m-2 .list-group").append(li.append(div1.append(p, p2), hidden));
                }
            }

            const movie_id = self.children("input[name=movieId]").val();
            $("#movie_id").val(movie_id);

            $.get("/cinema/movieid=" + movie_id)
                .done(decorateCinema)
                .fail();
        }

        for(let item of data) {
            // console.log(item);
            let li = $("<li>");
            let div1 = $("<div>", {"class": "showtime-row"});
            let image = $("<img>", {"src": item.imageLandscape, "alt": "thumbnail"});
            let div2 = $("<div>", {"class": "title-movie"});
            let p1 = $("<p>").text(item.name);
            let p2 = $("<p>", {"class": "title-sub"}).text("IMDB: " + item.imdb);
            let input = $("<input>", {"name":"movieId", "type": "hidden", "value": item.id});

            // add listener event on li
            li.click(function(){
                let self = $(this);
                $("#cinema_id").val("");
                $("#time_id").val("");
                $("#col-m-3 li").not("[class=fake]").remove();
                $("#col-m-3 li[class=fake]").show();
                $("#click-continue").hide();
                $("#col-m-1").find(".title-movie p").css("color", "#555");
                self.find(".title-movie p").css("color", "#f26b38");
                getCinema(self);
            });

            $("#col-m-1 .list-group").append(li.append(input, div1.append(image, div2.append(p1, p2))));
            // $("#col-m-1 .list-group").append(hidden);
        };
    }

    $.get("/movie/list")
        .done(decorateMovie)
        .fail();
}

function loginEvent(){
    function checkLoginReturn(data){
        if (data.result == "successful") {
            loginSuccess();
        } else {
            loginFail();
        }
    }

    function loginSuccess() {
        $(".col-2 .entry").hide();
        $("#id01").hide();

        let div = $("<div>", {"class": "welcome"});
        let p = $("<p>").text("Welcome: " + $("#id01 input[name='uname']").val() + " ");
        let a = $("<a>", {"href":"/logout"}).text("[Logout]");
        $(".col-2").append(div.append(p.append(a)));
    };

    function loginFail() {
        $("#id01").hide();
        $("#popupContent ").text("Username or Password is incorrect!");
        $("#id03").show();
    };

    let uname = $("#id01 input[name='uname']").val();
    let upassword = $("#id01 input[name='upassword']").val();
    let rememberMe = $("#id01 input[name='remember']").is(":checked");

    $.post("/login", {"uname": uname, "upassword": upassword, "remember": rememberMe}).done(checkLoginReturn).fail();
}

function registerEvent(evt) {
    function checkRegsterFields() {
        if ($("#id02 input[name='uname']").val() == "") {
            return false;
        }
        if ($("#id02 input[name='upassword']").val() == "") {
            return false;
        }
        if ($("#id02 input[name='upasswordCheck']").val() == "") {
            return false;
        }
        if ($("#id02 input[name='uemail']").val() == "") {
            return false;
        } else {
            let email = $("#id02 input[name='uemail']").val();
            let patt = new RegExp("^\\w+@\\w+\\..{2,3}(.{2,3})?$");
            let res = patt.test(email);
            if (res == false) {
                return false;
            }
        }
        return true;
    }

    function checkRegisterReturn(data) {
        // console.log(data);
        if (data.result == "successful") {
           registerSuccess();
        } else {
            registerFail(data.reason);
        }
    }

    function registerSuccess() {
        $("#id02").hide();
        $("#popupContent ").text("New account is created. Please login");
        $("#id03").show();
    }

    function registerFail(reason) {
        $("#id02").hide();
        $("#popupContent ").text("Error: " + reason);
        $("#id03").show();
    }

    if (checkRegsterFields() == false) {
        $("#id02").hide();
        $("#popupContent ").text("Please check your inputs. Something is wrong");
        $("#id03").show();
        evt.stopPropagation();
        return;
    }

    let uname = $("#id02 input[name='uname']").val();
    let upassword = $("#id02 input[name='upassword']").val();
    let uemail = $("#id02 input[name='uemail']").val();
    let upasswordCheck = $("#id02 input[name='upasswordCheck']").val();
    $.post("/register", {"uname": uname, "upassword": upassword, "uemail": uemail, "upasswordCheck": upasswordCheck})
        .done(checkRegisterReturn)
        .fail();
}

// check Input number not working
function checkNumberOnly() {
    return function(evt) {
        let top= evt.target.offsetTop;
        let patt = new RegExp("[0-9]+");
        let res = patt.test($(this).val());
        if (res == true) {
            let v = parseInt($(this).val());
            if (v > 0 && v <= 100) {
                $("#click-continue").css("top", top).show();
                return true;
            }
        }
        $(this).val("");
    }
}

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

function clickContinueEvent(evt) {

    function checkTicketAvailable(data) {
        console.log(data);
        let totalAvailable = parseInt(data);
        let pickedSeat = parseInt($("#noticket_id"));
        if ( pickedSeat > totalAvailable ) {
            $("#popupContent ").text("Please choose lower than " + totalAvailable);
            $("#id03").show();
            evt.preventDefault();
        }
    }

    let uid = getCookie("login_id");
    if (uid == "") {
        // warn user login
        $("#loginlistener").click();
        evt.preventDefault();
    } else {
        // check number of seats available
        $.ajax("/emptyseat",{ "type": "get" , "async" : false, "data" : {
            "cinema_id": $("#movie_id").val(),
             "time_id" : $("#time_id").val()
            }})
            .done(checkTicketAvailable)
            .fail();
        evt.preventDefault();

        $("#noticket_id").val($("#col-m-3 .showtime-row input:visible").val());
    }
}

function rememberMeCheck() {
    let name = getCookie("name");
    if (name != "") {
        $("#id01 .login-form-container input[name=uname]").val(name);
    }
}

// bind event on startup
$(getMovieList);
$(checkNumberOnly);
$(rememberMeCheck);
$(function(){
    $("#click-continue").hide();
    $("#loginlistener").click(enableLogin);
    $("#registerlistener").click(enableRegister);
    $("#login_submit").click(loginEvent);
    $("#register_submit").click(registerEvent);
    $("#closePopup").click(disablePopup);
    $(window).click(disableLogin);
    $(window).click(disableRegister);
    $(window).click(disablePopup);
    $("#click-continue").click(clickContinueEvent);
});