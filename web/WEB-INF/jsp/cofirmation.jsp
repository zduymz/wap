<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Cinema</title>
  <link rel="stylesheet" href="/resources/css/font.css">
  <link rel="stylesheet" href="/resources/css/confirmation.css">
  <script src="/resources/js/jquery-3.3.1.min.js"></script>
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
      <div class="main-pane">
        <h1>Thank you!</h1>
        <p>Your booking is successful. This is ticket information:</p>
        <div class="movie-info">
          <!-- This information from JSP-->
          <div class="ticket-container">
            <div class="ticket-info">
              <table>
                <tbody>
                  <tr>
                    <td class="table-col-1">Ticket ID</td>
                    <td class="table-col-2"><span id="ticket-id">${ticket_id}</span></td>
                  </tr>
                  <tr>
                    <td class="table-col-1">Cinema</td>
                    <td class="table-col-2"><span id="cinema">${cinema_obj.name}</span></td>
                  </tr>
                  <tr>
                    <td class="table-col-1">Movie</td>
                    <td class="table-col-2"><span id="movie">${movie_obj.name}</span></td>
                  </tr>
                  <tr>
                    <td class="table-col-1">Duration</td>
                    <td class="table-col-2"><span id="movie-duration">${movie_obj.duration}</span></td>
                  </tr>
                  <tr>
                    <td class="table-col-1">Time</td>
                    <td class="table-col-2"><span id="timeslot">${time_id}</span></td>
                  </tr>
                  <tr>
                    <td class="table-col-1">Seat</td>
                    <td class="table-col-2"><span id="seat">${seat}</span></td>
                  </tr>
                  <tr>
                  <td id="total">Total</td>
                  <td id="total-price"><span id="price">${price}</span>$</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
      </div>
    </div>
  </div>
  </div></div>
</body>
</html>
