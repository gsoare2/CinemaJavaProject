package hello;

public class Filme {
	private String nomeFilme;
	private int ano;
	private String descr;
	private String sinopseUrl;
	private String imagemFilmeUrl;
	private String trailerUrl;
	
	public Filme(String nomeFilme, int ano, String descr, String sinopseUrl, String imagemFilmeUrl, String trailerUrl){
		this.setNomeFilme(nomeFilme);
		this.setAno(ano);
		this.setDescr(descr);
		this.setSinopseUrl(sinopseUrl);
		this.setImagemFilmeUrl(imagemFilmeUrl);
		this.setTrailerUrl(trailerUrl);
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getSinopseUrl() {
		return sinopseUrl;
	}

	public void setSinopseUrl(String sinopseUrl) {
		this.sinopseUrl = sinopseUrl;
	}

	public String getImagemFilmeUrl() {
		return imagemFilmeUrl;
	}

	public void setImagemFilmeUrl(String imagemFilmeUrl) {
		this.imagemFilmeUrl = imagemFilmeUrl;
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}
}
