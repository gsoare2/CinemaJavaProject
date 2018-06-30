package hello;

import java.util.List;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model {
	ObjectContainer users = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/users.db4o");
	ObjectContainer rooms = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/rooms.db4o");
	
	
	public boolean addUsuario(Usuario usuario) {
		//if(isUserAvailable(usuario.getEmail())) {
			users.store(usuario);
			users.commit();
			return true;
		//}
		//return false;
	}
	
	/*public boolean isUserAvailable(String email) {
		Query query = users.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> allUsers = query.execute(); //user.getEmail().equals(email)
		
		for(Usuario user: allUsers){
	    	if(user.getEmail().equals(email)) {
	    		return false;
	    	}
	    }
		return true;
	}*/
	
	public Usuario compararUsuario(String email, String password) {
		
		Query query = users.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> allUsers = query.execute();
		
		for(Usuario usuario: allUsers) {
			if((usuario.getEmail().equals(email)) && (usuario.getPassword().equals(password))) {
				return usuario;
			}
		}
		return null;
	}
	
	public void addSala(Sala sala) {
		rooms.store(sala);
		rooms.commit();
	}
	
	public Usuario buscarUsuario(String cpf) {
		Query query = users.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> allUsers = query.execute();
	    
		for(Usuario usuario: allUsers) {
			if(usuario.getCpf().equals(cpf)) return usuario;
		}
		return null;
	}
	
	public Sala buscarSala(int numeroSala) {
		Query query = rooms.query();
		query.constrain(Sala.class);
	    ObjectSet<Sala> allRooms = query.execute();
	    
		for(Sala sala: allRooms) {
			if(sala.getNumeroSala() == numeroSala) return sala;
		}
		return null;
	}
	
	public List<Sala> buscarSalaPorFilme(String nomeFilme) {
		List<Sala> salasEncontradas = new LinkedList<Sala>();
		Query query = rooms.query();
		query.constrain(Sala.class);
	    ObjectSet<Sala> allRooms = query.execute();
		
		for(Sala sala: allRooms) {
			if(sala.getFilme().getNomeFilme().equals(nomeFilme)) {
				salasEncontradas.add(sala);
			}
		}
		return salasEncontradas;
	}
	
	public List<Sala> listarTodasSalas(){
		List<Sala> salasEncontradas = new LinkedList<Sala>();
		Query query = rooms.query();
		query.constrain(Sala.class);
	    ObjectSet<Sala> allRooms = query.execute();
		
		for(Sala sala: allRooms) {
			salasEncontradas.add(sala);
		}
		return salasEncontradas;
	}
	
	public List<Usuario> buscarTodosUsuarios(){ //Sem sentido
		List<Usuario> usuariosEncontrados = new LinkedList<Usuario>();
		Query query = users.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> allUsers = query.execute();
	    
		for(Usuario usuario: allUsers) {
			usuariosEncontrados.add(usuario);	
		}
		return usuariosEncontrados;
	}
	
	public void escolherSala(int numSala, String letra, int numero) {
		Query query = rooms.query();
		query.constrain(Sala.class);
	    ObjectSet<Sala> allRooms = query.execute();
	    
		for(Sala sala: allRooms) {
			if(sala.getNumeroSala() == numSala) {
				for(Cadeira cadeira: sala.getCadeiras()) {
					if(cadeira.getLetra().equals(letra) && cadeira.getNumero() == numero) {
						cadeira.setReservada(true);
					}
				}
			}
		}
	}
	


}
