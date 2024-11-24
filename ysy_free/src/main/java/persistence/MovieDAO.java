package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.MovieVO;

public class MovieDAO {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	private static final String DB_USER = "jspbook";
	private static final String DB_PASSWORD = "passwd";

	// DB 연결
	private Connection getConnection() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new SQLException("Database connection error", e);
		}
	}

	// 영화 추가
	public boolean add(MovieVO vo) {
		String sql = "INSERT INTO movie (movieId, title, genre, runtime, posterUrl) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getMovieId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getGenre());
			pstmt.setInt(4, vo.getRuntime());
			pstmt.setString(5, vo.getPosterUrl());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 영화 수정
	public boolean update(MovieVO vo) {
		String sql = "UPDATE movie SET title = ?, genre = ?, runtime = ?, posterUrl = ? WHERE movieId = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getGenre());
			pstmt.setInt(3, vo.getRuntime());
			pstmt.setString(4, vo.getPosterUrl());
			pstmt.setString(5, vo.getMovieId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 영화 조회
	public MovieVO read(String string) {
		String sql = "SELECT * FROM movie WHERE movieId = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, string);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					MovieVO movie = new MovieVO();
					movie.setMovieId(rs.getString("movieId"));
					movie.setTitle(rs.getString("title"));
					movie.setGenre(rs.getString("genre"));
					movie.setRuntime(rs.getInt("runtime"));
					movie.setPosterUrl(rs.getString("posterUrl"));
					return movie;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 영화 삭제
	public boolean delete(String movieId) {
		String sql = "DELETE FROM movie WHERE movieId = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, movieId);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 영화 목록 조회
	public ArrayList<MovieVO> getMovieList() {
		String sql = "SELECT * FROM movie";
		ArrayList<MovieVO> movieList = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				MovieVO movie = new MovieVO();
				movie.setMovieId(rs.getString("movieId"));
				movie.setTitle(rs.getString("title"));
				movie.setGenre(rs.getString("genre"));
				movie.setRuntime(rs.getInt("runtime"));
				movie.setPosterUrl(rs.getString("posterUrl"));
				movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieList;
	}
}
