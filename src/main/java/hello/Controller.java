package hello;

import static spark.Spark.get;
import static spark.Spark.post;

import java.time.LocalDate;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class Controller {
	
	private Model model;
	
	public Controller(Model model){
		this.model = model;
	}
	
	//Buscar
	public void buscarSala() { //Busca uma sala por numero da sala
		get("/sala/:numeroSala", (req,res) ->{ //ta funfando
			int numerosala = Integer.parseInt(req.params(":numeroSala"));
			Sala salaEncontrada = model.buscarSala(numerosala);
			return new Gson().toJson(salaEncontrada);
		});
	}
	
	public void buscarSalaPorFilme() {
		get("/salaFilme/:nomeFilme", (req, res) -> {
			String nomeFilme = req.params(":nomeFilme");
			List<Sala> salasEncontradas2 = model.buscarSalaPorFilme(nomeFilme);
			return new Gson().toJson(salasEncontradas2);
		});
	}
	
	//Busca tod
	public void listarSalas() { //Retorna todas as salas
		get("/salas", (req, res) -> { //ta funfando
			List<Sala> salasEncontradas = model.listarTodasSalas();
			return new Gson().toJson(salasEncontradas);
		});
	}
	
	/*public void adicionarSala() {
		
	}*/
	
	//Adicionar
	/*public void adicionarSala() { //funfo
		get("/sala/addSala/:numeroSala/:nomeFilme/:ano/:descr/:horario", (req, res) -> {
			Sala sala = new Sala(Integer.parseInt(req.params(":numeroSala")), new Filme(req.params(":nomeFilme"),Integer.parseInt(req.params(":ano")), req.params(":descr"),Integer.parseInt(req.params(":horario"))));
			model.addSala(sala);
			return "";
		});
	}*/

	//CRUD usuario
	//Inserir
	/*public void adicionarUsuarioPeloAdmin() {
		get("/admin/addUsuario/:nome/:sobrenome/:cpf/:username/:password/:email/:numSala/:letra/:numero", (req, res)->{
			Usuario usuario = new Usuario(req.params(":nome"), req.params(":sobrenome"), req.params(":cpf"), req.params(":username"), req.params(":password"), req.params(":email"), 0);
			int numSala = Integer.parseInt(req.params(":numSala"));
			int numero = Integer.parseInt(req.params(":numero"));
			String letra = req.params(":letra");
			
			model.escolherSala(numSala, letra, numero);
			model.addUsuario(usuario);
			return "";
		});
	}*/
	
	//Insert de usuario
	public void adicionarUsuario() {
		post("/usuario/addUsuario", new Route() {

			@Override
			public Object handle(Request request, Response response) throws Exception {
				response.header("Access-Control-Allow-Origin", "*");
				
				JSONObject json = new JSONObject(request.body());
				
				String firstName = json.getString("firstName");
				String lastName = json.getString("lastName");
				String cpf = json.getString("cpf");
				String username = json.getString("username");
				String password = json.getString("password");
				String email = json.getString("email");
				
				String nomePessoaCartao = json.getString("nomePessoaCartao");
				String numeroCartao = json.getString("numeroCartao");
				String numeroSeguranca = json.getString("numeroSeguranca");
				String bandeiraCartao = json.getString("bandeiraCartao");
				int ano = json.getInt("ano");
				int mes = json.getInt("mes");
				int dia = json.getInt("dia");
				LocalDate dataVencimento = LocalDate.of(ano, mes, dia);
				
				Usuario userAdd = new Usuario(firstName, lastName, cpf, password, email, 0, new Cartao(nomePessoaCartao, numeroCartao, numeroSeguranca, bandeiraCartao, dataVencimento));
				
				if(model.addUsuario(userAdd)) {
					return true;
				}
				return false;
			}
			
		});
	}
	
	//Busca um usuario por cpf
	public void buscarUsuario() {
		get("/usuario/buscarUsuario/:cpf", (req, res) -> {
			String numeroCpf = req.params(":cpf").toString();
			Usuario usuarioEncontrado = model.buscarUsuario(numeroCpf);
			return new Gson().toJson(usuarioEncontrado);
		});
	}
	
	public void listarUsuarios() {
		get("/usuarios", (req, res) -> {
			List<Usuario> usuarios = model.buscarTodosUsuarios();
			return new Gson().toJson(usuarios);
		});
	}
	
	//Login
	public void getLogin() {
		post("/login/usuario", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				response.header("Access-Control-Allow-Origin", "*");
				
				JSONObject json = new JSONObject(request.body());
				
				String username = json.getString("username");
				String password = json.getString("password");
				
				Usuario usuarioEncontrado = model.compararUsuario(username, password);
				if(usuarioEncontrado != null) {
					
					return new Gson().toJson(usuarioEncontrado);
				}
				return null;
			}
		});
	}
}
