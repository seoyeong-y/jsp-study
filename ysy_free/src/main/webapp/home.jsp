<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="domain.*, java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영화 예매 시스템</title>
    <link rel="stylesheet" href="resources/movie.css" type="text/css">
</head>
<body>
   <header>
        <nav>
            <div class="logo">
                <a href="MovieServlet?cmd=list">Movie Booking</a>
            </div>
            <ul class="nav-links">
                <li><a href="MovieServlet?cmd=list">영화 목록</a></li>
                <li><a href="BookingServlet?cmd=list">예매 목록</a></li>
                <c:choose>
                    <c:when test="${not empty member}">
                        <li><a href="MemberServlet?cmd=mypage" class="btn">마이 페이지</a></li>
                        <li><a href="MemberServlet?cmd=logout" class="btn">로그아웃</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="MemberServlet?cmd=login">로그인</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </header>

    <h1 class="movie-list-title">현재 상영 중인 영화</h1>

    <section class="movie-list">
        <!-- movieList가 있을 경우 출력 -->
        <c:choose>
            <c:when test="${not empty movieList}">
                <c:forEach var="movie" items="${movieList}">
                    <div class="movie-card">
                        <img src="${movie.posterUrl}" alt="영화 포스터">
                        <div class="movie-info">
                            <h2>${movie.title}</h2>
                            <a href="MovieServlet?cmd=info&id=${movie.movieId}" class="btn">예매하기</a>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>영화 목록이 없습니다.</p>
            </c:otherwise>
        </c:choose>
    </section>
</body>
</html>
