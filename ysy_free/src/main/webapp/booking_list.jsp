<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예매 목록</title>
    <link rel="stylesheet" href="resources/movie.css" type="text/css">
</head>
<body>
    <header>
        <div class="logo">
            <a href="#">Movie Booking</a>
        </div>
    </header>

    <main>
        <h1>예매 목록</h1>

        <table>
            <thead>
                <tr>
                    <th>영화명</th>
                    <th>예매일</th>
                    <th>아이디</th>
                    <th>상영관</th>
                    <th>좌석</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="booking" items="${bookingList}">
                    <tr>
                        <td>${booking.movieName}</td>
                        <td>${booking.date}</td>
                        <td>${booking.userId}</td>
                        <td>${booking.theater}</td>
                        <td>${booking.seats}</td>
                        <td><a href="BookingServlet?cmd=delete&bookingId=${booking.bookingId}">삭제</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="BookingServlet?cmd=new">새 예매</a>
    </main>
</body>
</html>
