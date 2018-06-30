package hello;

public class Horario {
	private String horaInicio;
	private String horaFinal;
	
	public Horario(String horaInicio, String horaFinal) {
		this.setHoraInicio(horaInicio);
		this.setHoraFinal(horaFinal);
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
}
