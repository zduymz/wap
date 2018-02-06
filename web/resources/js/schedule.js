
function enableLogin(evt) {
    $("#id01").css("display", "block");
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

function checkPassword() {
    var password = $("#id02 input[name='upassword']").val();
    var confirm_password = $("#id02 input[name='upasswordCheck']").val();

    function validatePassword(){
        if(password.value != confirm_password.value) {
            confirm_password.setCustomValidity("Passwords Don't Match");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
}


function getMovieList() {
    function getCinema(self) {
        function getTime(self) {

            const cinema_id = self.children("input[name=cinemaId]").val();
            $.post("/" + cinema_id)
                .done(
                    function(){
                        console.log(cinema_id);
                    }
                )
                .fail()
        }

        function decorateCinema(data) {
            $("#col-m-2 li[class=fake]").hide();
            $("#col-m-2 li").not("[class=fake]").remove();
            for(let item of data) {
                // console.log(item);
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
        $.get("/movie/" + movie_id)
            .done(decorateCinema)
            .fail();
    }

    function decorateMovie(data){
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
                getCinema(self);
            })

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
        let p = $("<p>").text("Welcome: " + $("#id01 input[name='uname']").val());
        $(".col-2").append(div.append(p));
    };

    function loginFail() {
        $("#id01").hide();
        $("#popupContent ").text("Username or Password is incorrect!");
        $("#id03").show();
    };

    let uname = $("#id01 input[name='uname']").val();
    let upassword = $("#id01 input[name='upassword']").val();

    $.post("/login", {"uname": uname, "upassword": upassword}).done(checkLoginReturn).fail();
}

function registerEvent() {
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

    let uname = $("#id02 input[name='uname']").val();
    let upassword = $("#id02 input[name='upassword']").val();
    let uemail = $("#id02 input[name='uemail']").val();
    let upasswordCheck = $("#id02 input[name='upasswordCheck']").val();
    $.post("/register", {"uname": uname, "upassword": upassword, "uemail": uemail, "upasswordCheck": upasswordCheck})
        .done(checkRegisterReturn)
        .fail();
}
// bind event on startup
$(getMovieList);
$(function(){
    $("#loginlistener").click(enableLogin);
    $("#registerlistener").click(enableRegister);
    $("#login_submit").click(loginEvent);
    $("#register_submit").click(registerEvent);
    $("#closePopup").click(disablePopup);
    $(window).click(disableLogin);
    $(window).click(disableRegister);
    $(window).click(disablePopup);
});