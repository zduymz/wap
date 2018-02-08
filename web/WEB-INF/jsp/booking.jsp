<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinema</title>
    <link rel="stylesheet" href="/resources/css/font.css">
    <link rel="stylesheet" href="/resources/css/booking.css">
    <script src="/resources/js/jquery-3.3.1.min.js"></script>
    <script src="/resources/js/booking.js"></script>
</head>
<body>
<div id="ci-header">
    <div class="container">
        <div class="col-1">
            <div class="header-logo">
                <a href="/index">
                    <img src="/resources/media/cinema-logo.png" alt="Cinema Logo">
                </a>
            </div>
        </div>
        <div class="col-2">
            <!-- Check cookie, session on jsp to decide show welcome or login -->
            <c:if test="${username != null}">
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
            <li class="sub-nav"><a href="/index">SCHEDULE</a></li>
            <li class="sub-nav"><a href="/info">ACCOUNT</a></li>
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
                    <% String[] arrays = {"J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
                        request.setAttribute("arrays", arrays);
                    %>
                    <c:forEach items="${arrays}" var="key">
                        <ul class="seat-row">
                            <li class="index">${key}</li>
                            <li class="seat-col-wrapper">
                                <ul class="seat-col">
                                    <c:forEach items="${seat_map.seats.get(key)}" var="seat" varStatus="vs">
                                        <li<c:if test="${seat == 1}">
                                            class="selected"
                                            </c:if>
                                        style="transform: translate(${(vs.index+1)*110}%,0)">${vs.index+1}</li>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li class="index">${key}</li>
                        </ul>
                    </c:forEach>
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
                        <img src="${movie_obj.imageLandscape}">
                    </div>
                    <!-- This information from JSP-->
                    <input type="hidden" id="seatNo" name="seatNo" value="${noticket_id}">
                    <div class="ticket-container">
                        <h2 class="movie-name">${movie_obj.name}</h2>
                        <div class="ticket-info">
                            <p>Cinema: <span id="cinema">${cinema_obj.name}</span></p>
                            <p>Time: <span id="timeslot">${time_id}</span></p>
                            <p>Seat: <span id="seat"></span></p>
                        </div>
                        <div class="ticket-total-price">
                            <p>Total: <span id="total-price">0</span>$</p>
                        </div>
                        <div class="select-ticket">
                            <a>Confirm</a>
                        </div>
                        <input type="hidden" id="tprice" value="${price}">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<form action="/confirmation" method="post">
    <input type="hidden" id="movie_id" name="movie_id" value="${movie_obj.id}">
    <input type="hidden" id="cinema_id" name="cinema_id" value="${cinema_obj.id}">
    <input type="hidden" id="time_id" name="time_id" value="${time_id}">
    <input type="hidden" id="noTicket_id" name="noTicket_id">
    <input type="hidden" id="ticketPrice_id" name="ticketPrice_id">
    <input type="submit" id="confirm_submit">
</form>
</body>
</html>