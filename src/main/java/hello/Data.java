package hello;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Data {
	private LocalDate data;
	private List<Horario> horario = new LinkedList<Horario>();

	public Data(LocalDate data, List<Horario> horario) {
		this.setData(data);
		this.setHorario(horario);
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}
}
