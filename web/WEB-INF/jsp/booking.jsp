<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/font.css">
    <link rel="stylesheet" href="/resources/css/font-awesome.css">
    <link rel="stylesheet" href="/resources/css/booking.css">
    <script src="/resources/js/jquery-3.3.1.min.js"></script>
    <script src="/resources/js/booking.js"></script>
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
            <c:if test="${username}">
                <div class="welcome">
                    <p>Welcome: ${username} <a href="/logout">[Logout]</a></p>
                </div>
            </c:if>
            <%--<div class="entry">--%>
                <%--<div id="loginlistener" class="header-login">--%>
                    <%--<a>Login</a>--%>
                <%--</div> /--%>
                <%--<div id="registerlistener" class="header-login">--%>
                    <%--<a>Register</a>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
    </div>
</div>
<div id="ci-navbar">
    <nav>
        <ul class="primary-nav">
            <li class="sub-nav"><a href="/">MUA VE</a></li>
            <li class="sub-nav"><a href="/">THONG TIN</a></li>
        </ul>
    </nav>
</div>
<div id="ci-movies">
    <div class="tab-container">
        <div class="tab-content">
            <!-- class: selected
                class: active
             -->
            <div class="left-pane">
                <div class="seat-border">
                    <div class="seat-map-wrapper">
                    <ul class="seat-row">
                        <li class="index">J</li>
                        <li class="seat-col-wrapper">
                            <ul class="seat-col">
                                <li style="transform: translate(110%,0)">10</li>
                                <li style="transform: translate(220%,0)">9</li>
                                <li style="transform: translate(330%,0)">8</li>
                                <li style="transform: translate(440%,0)">7</li>
                                <li style="transform: translate(550%,0)">6</li>
                                <li style="transform: translate(660%,0)">5</li>
                                <li style="transform: translate(770%,0)">4</li>
                                <li class="selected" style="transform: translate(880%,0)">3</li>
                                <li style="transform: translate(990%,0)">2</li>
                                <li style="transform: translate(1100%,0)">1</li>
                            </ul>
                        </li>
                        <li class="index">J</li>
                    </ul>
                    <ul class="seat-row">
                        <li class="index">H</li>
                        <li class="seat-col-wrapper">
                            <ul class="seat-col">
                                <li style="transform: translate(110%,0)">10</li>
                                <li style="transform: translate(220%,0)">9</li>
                                <li style="transform: translate(330%,0)">8</li>
                                <li style="transform: translate(440%,0)">7</li>
                                <li style="transform: translate(550%,0)">6</li>
                                <li style="transform: translate(660%,0)">5</li>
                                <li style="transform: translate(770%,0)">4</li>
                                <li style="transform: translate(880%,0)">3</li>
                                <li style="transform: translate(990%,0)">2</li>
                                <li style="transform: translate(1100%,0)">1</li>
                            </ul>
                        </li>
                        <li class="index">H</li>
                    </ul>
                    <ul class="seat-row">
                        <li class="index">G</li>
                        <li class="seat-col-wrapper">
                            <ul class="seat-col">
                                <li style="transform: translate(110%,0)">10</li>
                                <li style="transform: translate(220%,0)">9</li>
                                <li style="transform: translate(330%,0)">8</li>
                                <li style="transform: translate(440%,0)">7</li>
                                <li style="transform: translate(550%,0)">6</li>
                                <li style="transform: translate(660%,0)">5</li>
                                <li style="transform: translate(770%,0)">4</li>
                                <li style="transform: translate(880%,0)">3</li>
                                <li style="transform: translate(990%,0)">2</li>
                                <li style="transform: translate(1100%,0)">1</li>
                            </ul>
                        </li>
                        <li class="index">G</li>
                    </ul>
                    <ul class="seat-row">
                        <li class="index">F</li>
                        <li class="seat-col-wrapper">
                            <ul class="seat-col">
                                <li style="transform: translate(110%,0)">10</li>
                                <li style="transform: translate(220%,0)">9</li>
                                <li style="transform: translate(330%,0)">8</li>
                                <li style="transform: translate(440%,0)">7</li>
                                <li style="transform: translate(550%,0)">6</li>
                                <li style="transform: translate(660%,0)">5</li>
                                <li style="transform: translate(770%,0)">4</li>
                                <li style="transform: translate(880%,0)">3</li>
                                <li style="transform: translate(990%,0)">2</li>
                                <li style="transform: translate(1100%,0)">1</li>
                            </ul>
                        </li>
                        <li class="index">F</li>
                    </ul>
                    <ul class="seat-row">
                        <li class="index">E</li>
                        <li class="seat-col-wrapper">
                            <ul class="seat-col">
                                <li style="transform: translate(110%,0)">10</li>
                                <li style="transform: translate(220%,0)">9</li>
                                <li style="transform: translate(330%,0)">8</li>
                                <li style="transform: translate(440%,0)">7</li>
                                <li style="transform: translate(550%,0)">6</li>
                                <li style="transform: translate(660%,0)">5</li>
                                <li style="transform: translate(770%,0)">4</li>
                                <li style="transform: translate(880%,0)">3</li>
                                <li style="transform: translate(990%,0)">2</li>
                                <li style="transform: translate(1100%,0)">1</li>
                            </ul>
                        </li>
                        <li class="index">E</li>
                    </ul>
                    <ul class="seat-row">
                        <li class="index">D</li>
                        <li class="seat-col-wrapper">
                            <ul class="seat-col">
                                <li style="transform: translate(110%,0)">10</li>
                                <li style="transform: translate(220%,0)">9</li>
                                <li style="transform: translate(330%,0)">8</li>
                                <li style="transform: translate(440%,0)">7</li>
                                <li style="transform: translate(550%,0)">6</li>
                                <li style="transform: translate(660%,0)">5</li>
                                <li style="transform: translate(770%,0)">4</li>
                                <li style="transform: translate(880%,0)">3</li>
                                <li style="transform: translate(990%,0)">2</li>
                                <li style="transform: translate(1100%,0)">1</li>
                            </ul>
                        </li>
                        <li class="index">D</li>
                    </ul>
                    <ul class="seat-row">
                        <li class="index">C</li>
                        <li class="seat-col-wrapper">
                            <ul class="seat-col">
                                <li style="transform: translate(110%,0)">10</li>
                                <li style="transform: translate(220%,0)">9</li>
                                <li style="transform: translate(330%,0)">8</li>
                                <li style="transform: translate(440%,0)">7</li>
                                <li style="transform: translate(550%,0)">6</li>
                                <li style="transform: translate(660%,0)">5</li>
                                <li style="transform: translate(770%,0)">4</li>
                                <li style="transform: translate(880%,0)">3</li>
                                <li style="transform: translate(990%,0)">2</li>
                                <li style="transform: translate(1100%,0)">1</li>
                            </ul>
                        </li>
                        <li class="index">C</li>
                    </ul>
                    <ul class="seat-row">
                        <li class="index">B</li>
                        <li class="seat-col-wrapper">
                            <ul class="seat-col">
                                <li style="transform: translate(110%,0)">10</li>
                                <li style="transform: translate(220%,0)">9</li>
                                <li style="transform: translate(330%,0)">8</li>
                                <li style="transform: translate(440%,0)">7</li>
                                <li style="transform: translate(550%,0)">6</li>
                                <li style="transform: translate(660%,0)">5</li>
                                <li style="transform: translate(770%,0)">4</li>
                                <li style="transform: translate(880%,0)">3</li>
                                <li style="transform: translate(990%,0)">2</li>
                                <li style="transform: translate(1100%,0)">1</li>
                            </ul>
                        </li>
                        <li class="index">B</li>
                    </ul>
                    <ul class="seat-row">
                        <li class="index">A</li>
                        <li class="seat-col-wrapper">
                            <ul class="seat-col">
                                <li style="transform: translate(110%,0)">10</li>
                                <li style="transform: translate(220%,0)">9</li>
                                <li style="transform: translate(330%,0)">8</li>
                                <li style="transform: translate(440%,0)">7</li>
                                <li style="transform: translate(550%,0)">6</li>
                                <li style="transform: translate(660%,0)">5</li>
                                <li style="transform: translate(770%,0)">4</li>
                                <li style="transform: translate(880%,0)">3</li>
                                <li style="transform: translate(990%,0)">2</li>
                                <li style="transform: translate(1100%,0)">1</li>
                            </ul>
                        </li>
                        <li class="index">A</li>
                    </ul>
                    <div class="screen">Screen</div>
                    <div class="seat-cinema">
                        <div class="seat-cinema-selected"></div><span>Booking</span>
                        <div class="seat-cinema-unavailable"></div><span>Booked</span>
                        <div class="seat-cinema-normal"></div><span>Available</span>
                    </div>
                </div>
                </div>
            </div>
            <div class="right-pane">
                <div class="movie-info">
                    <div class="img-containter">
                        <img src="/resources/media/movies/guardians-of-the-tombs/thumbnail.jpg">
                    </div>
                    <!-- This information from JSP-->
                    <input type="hidden" id="seatNo" name="seatNo" value="3">
                    <div class="ticket-container">
                        <h2 class="movie-name">GUARDIANS OF THE TOMBS</h2>
                        <div class="ticket-info">
                            <p>Cinema: <span id="cinema">Galaxy Quang Trung  | Rạp 7</span></p>
                            <p>Time: <span id="timeslot">09:25  | Wed, 07/02/2018</span></p>
                            <p>Seat: <span id="seat"></span></p>
                        </div>
                        <div class="ticket-total-price">
                            <p>Total: <span id="total-price">100</span>$</p>
                        </div>
                        <div class="select-ticket">
                            <a>Confirm</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<input type="hidden" id="movie_id" name="movie_id">
<input type="hidden" id="cinema_id" name="cinema_id">
<input type="hidden" id="time_id" name="time_id">
</body>
</html>