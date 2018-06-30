package hello;

public class Usuario {
	private String nome;
	private String sobrenome;
	private String cpf;
	private String password;
	private String email;
	private int admin;
	private Cartao cartao;
	
	public Usuario(String nome, String sobrenome, String cpf, String password, String email, int admin, Cartao cartao){
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setCpf(cpf);
		this.setPassword(password);
		this.setEmail(email);
		this.setAdmin(admin);
		this.setCartao(cartao);
	}
	
	public Usuario(String nome, String email, String password, int admin) {
		this.setNome(nome);
		this.setEmail(email);
		this.setPassword(password);
		this.setAdmin(admin);
	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public boolean compararUsuario(Usuario usuario) {
		if(this.getNome().equals(usuario.getNome())) {
			return true;
		}
		else {
			return false;
		}
	}
}
