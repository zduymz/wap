<%--
  Created by IntelliJ IDEA.
  User: gonnix
  Date: 2/8/18
  Time: 6:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Info</title>
    <link rel="stylesheet" href="/resources/css/font.css">
    <link rel="stylesheet" href="/resources/css/info.css">
    <script src="/resources/js/jquery-3.3.1.min.js"></script>
    <script src="/resources/js/info.js"></script>
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
                <p>Your booking is successful. This is ticket information:</p>
                <div class="movie-info">
                    <!-- This information from JSP-->
                    <div class="ticket-container">
                        <div class="ticket-info">
                            <table id="table-user">
                                <tbody>
                                <tr>
                                    <th>User Name</th>
                                    <td class="table-col-2"><span id="username">${username}</span></td>
                                </tr>
                                <tr>
                                    <th>Email</th>
                                    <td class="table-col-2"><span id="useremail">${uemail}</span></td>
                                </tr>
                                </tbody>
                            </table>
                            <br/>
                            <table id="table-ticket">
                                <tbody id="tickettable">
                                <tr>
                                    <th>Ticket ID</th>
                                    <th>Movie Name</th>
                                    <th>Cinema Name</th>
                                    <th>Time Show</th>
                                    <th>Seat</th>
                                    <th>Price</th>
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
