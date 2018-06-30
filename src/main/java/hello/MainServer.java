package hello;

import static spark.Spark.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

	
public class MainServer {
	
	final static Model model = new Model();
	
    public static void main(String[] args) {

		// Get port config of 	heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 1234;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");
 
		//initAdminUser();
		//initFilmesOnPoster();

		Controller controller = new Controller(model);
		
		//controller.adicionarSala();
		//controller.adicionarUsuarioPeloAdmin();
		controller.listarUsuarios();
		controller.adicionarUsuario();
		controller.getLogin();
		
		controller.buscarSala();
		controller.listarSalas();
		controller.buscarSalaPorFilme();
		
		controller.buscarUsuario();
    }
    
    public static void initAdminUser() {
    	//model.addUsuario(new Usuario("Administrador", "admin", "0000", 1));
    	//model.addUsuario(new Usuario("jonathan", "jonathan", "1", "123", "jonathan", 0, new Cartao("jonathan", "123", "1", "mastercard", LocalDate.of(2019, 01, 12))));
    	//model.addUsuario(new Usuario("paulo", "paulo", "2", "paulo", "123", "r", 3, new Cartao("paulo", "123", "2", "mastercard", LocalDate.of(2012, 02, 23))));
    	//model.addUsuario(new Usuario("gustavo", "gustavo", "0", "gustavo", "0000", "g", 0, new Cartao("gustavo", "123", "1", "mastercard", LocalDate.of(2022, 05, 16))));
    }
    
    public static void initFilmesOnPoster() {
    	List<Data> data = new ArrayList<Data>();
    	List<Horario> horario = new ArrayList<Horario>();
    	
    	horario.add(new Horario("09h", "11h"));
    	horario.add(new Horario("13h", "15h"));
    	horario.add(new Horario("17h", "19h"));
    	horario.add(new Horario("20h", "22h"));
    	
    	data.add(new Data(LocalDate.of(2018, 05, 21), horario));
    	data.add(new Data(LocalDate.of(2018, 05, 23), horario));
    	data.add(new Data(LocalDate.of(2018, 05, 25), horario));
    	data.add(new Data(LocalDate.of(2018, 05, 27), horario));
    	
    	Sala sala1 = new Sala(1, new Filme("Os incriveis", 2018, "Top", "t", "http://t3.gstatic.com/images?q=tbn:ANd9GcSlYTsyW6MWZfDO2CAIby62vX8tCgRo3ynh3hT3YWNSaa93t3I4", "t"), data);
    	Sala sala2 = new Sala(2, new Filme("O processo", 2018, "nice", "v", "http://t3.gstatic.com/images?q=tbn:ANd9GcSX4eDTFxu0ZEwv6u5JS73MY3cchc61eYHRPAGZVouDYKtwKyF3", "v"), data);
    	Sala sala3 = new Sala(3, new Filme("Deadpool 2", 2018, "very cool", "g", "http://t0.gstatic.com/images?q=tbn:ANd9GcQk4VujIOVqKQGdAk-MUHoGKTSyRHg8lzTnZsCpTuxOTle7BWP7", "g"), data);
    	
    	model.addSala(sala1);
    	model.addSala(sala2);
    	model.addSala(sala3);
    }
}
