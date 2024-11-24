package domain;

public class MovieVO {
	private String movieId;
	private String title;
	private String genre;
	private int runtime;
	private String posterUrl;

	public MovieVO(String movieId, String title, String genre, int runtime, String posterUrl) {
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.runtime = runtime;
		this.posterUrl = posterUrl;
	}

	public MovieVO() {
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
}
