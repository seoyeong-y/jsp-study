<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>영화 예매</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .form-container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            border-radius: 5px;
        }
        .form-container input,
        .form-container select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 4px;
            border: 1px solid #ddd;
        }
        .form-container button {
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">영화 예매</h2>
    
    <div class="form-container">
        <form action="BookingServlet" method="POST">
            <input type="hidden" name="cmd" value="book" />
            <input type="hidden" name="movieId" value="${param.id}" />
            
            <!-- 영화 제목 (예매할 영화 정보) -->
            <label for="movieName">영화 제목:</label>
            <input type="text" id="movieName" name="movieName" value="${param.movieName}" readonly />
            
            <!-- 사용자 ID 입력 -->
            <label for="memberId">사용자 ID:</label>
            <input type="text" id="memberId" name="memberId" required />
            
            <!-- 영화관 선택 -->
            <label for="theaterId">영화관 선택:</label>
            <select id="theaterId" name="theaterId" required>
                <option value="1">CGV 서울</option>
                <option value="2">CGV 부산</option>
                <option value="3">CGV 대구</option>
                <option value="4">CGV 인천</option>
            </select>

            <!-- 예약 좌석 입력 -->
            <label for="seats">좌석 (예: A1, A2, B1):</label>
            <input type="text" id="seats" name="seats" required />

            <!-- 예매 버튼 -->
            <button type="submit">예매하기</button>
        </form>
    </div>
</body>
</html>
