<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="domain.MovieVO"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>영화 상세 정보</title>
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
	</header>

	<div class="movie-info-container">
		<div class="movie-info">
			<div class="movie-image">
				<img src="${movie.posterUrl}" alt="영화 포스터">
			</div>
			<div class="movie-details">
				<h1>${movie.title}</h1>
				<p>
					<strong>장르:</strong> ${movie.genre}
				</p>
				<p>
					<strong>상영 시간:</strong> ${movie.runtime}분
				</p>
				<a href="BookingServlet?cmd=book&id=${movie.movieId}" class="btn">예매하기</a>
			</div>
		</div>
	</div>
</body>
</html>
