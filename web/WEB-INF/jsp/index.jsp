<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinema</title>
    <link rel="stylesheet" href="/resources/css/font.css">
    <link rel="stylesheet" href="/resources/css/schedule.css">
    <script src="/resources/js/jquery-3.3.1.min.js"></script>
    <script src="/resources/js/schedule.js"></script>
</head>
<body>
<div id="ci-header">
    <div class="container">
        <div class="col-1">
            <div class="header-logo">
                <a href="/">
                    <img src="/resources/media/cinema-logo.png" alt="Cinema Logo">
                </a>
            </div>
        </div>
        <div class="col-2">
            <!-- Check cookie, session on jsp to decide show welcome or login -->
            <c:choose>
                <c:when test="${username}">
                    <%-- user already logged in--%>
                    <div class="welcome">
                        <p>Welcome: ${username} <a href="/logout">[Logout]</a></p>

                    </div>
                </c:when>
                <c:otherwise>
                    <div class="entry">
                        <div id="loginlistener" class="header-login">
                            <a>Login</a>
                        </div> /
                        <div id="registerlistener" class="header-login">
                            <a>Register</a>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<div id="ci-navbar">
    <nav>
        <ul class="primary-nav">
            <li class="sub-nav"><a href="/index">SCHEDULE</a></li>
            <li class="sub-nav"><a href="/info">ACCOUNT</a></li>
        </ul>
    </nav>
</div>
<div id="ci-movies">
    <div class="tab-container">
        <div class="tab-content">
            <div id="col-m-1">
                <div class="panel-heading">
                    <h4 class="panel-title">Movies</h4>
                </div>
                <ul class="list-group">
                    <!-- Sample
                    <li>
                        <div class="showtime-row">
                            <img src="/resources/media/movies/guardians-of-the-tombs/thumbnail.jpg" alt="thumbnail">
                            <div class="title-movie">
                                <p>GUARDIAN OF THE TOMB</p>
                                <p class="title-sub">IMDB: 5.8</p>
                            </div>
                        </div>
                    </li> -->

                </ul>
            </div>
            <div id="col-m-2">
                <div class="panel-heading">
                    <h4 class="panel-title">Cinemas</h4>
                </div>
                <ul class="list-group">
                    <li class="fake">Please choose movie</li>
                </ul>
            </div>
            <div id="col-m-3">
                <div class="panel-heading">
                    <h4 class="panel-title">Times</h4>
                </div>
                <ul class="list-group">
                    <li class="fake">Please choose time</li>
                    <!--<li>-->
                        <!--<div class="showtime-row">-->
                            <!--<p>Wed, 07/02/2018</p>-->
                            <!--<a class="showtimes-list">14:30</a>-->
                            <!--<a class="showtimes-list">15:30</a>-->
                            <!--<a class="showtimes-list">16:30</a>-->
                            <!--<input class="showtimes-tickets" placeholder="Ticket" type="text">-->
                        <!--</div>-->
                    <!--</li>-->
                </ul>
            </div>
        </div>
    </div>
</div>
<form action="/booking" method="post">
    <input type="submit" id="click-continue" value="Continue >>" class="show-button">
    <input type="hidden" id="movie_id" name="movie_id">
    <input type="hidden" id="cinema_id" name="cinema_id">
    <input type="hidden" id="time_id" name="time_id">
    <input type="hidden" id="noticket_id" name="noticket_id">
</form>
<div id="id01" class="login-form">
    <div class="modal-content">
        <div class="login-form-type">
            <a>LOGIN </a>
        </div>
        <div class="login-form-container">
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname" required>
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="upassword" required>
            <label><input type="checkbox" name="remember"> Remember me</label>
            <button id="login_submit">Login</button>
        </div>
    </div>
</div>
<div id="id02" class="login-form">
    <div class="modal-content">
        <div class="login-form-type">
            <a>REGISTER</a>
        </div>
        <div class="login-form-container">
            <label><b>Username</b></label>
            <input type="text" placeholder="Your Name" name="uname" required>
            <label><b>Email</b></label>
            <input type="email" placeholder="Your Email" name="uemail" required>
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="upassword" required>
            <label><b>Re-enter password</b></label>
            <input type="password" placeholder="Confirm Password" name="upasswordCheck" required>
            <button id="register_submit">Register</button>
        </div>
    </div>
</div>
<div id="id03" class="login-form">
    <div class="modal-content">
        <div> </div>
        <div class="login-form-container">
            <p id="popupContent"></p>
            <button id="closePopup">Close</button>
        </div>
    </div>
</div>
</body>
</html>