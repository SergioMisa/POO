package ejercicio_herencia;

import java.time.LocalDate;
import java.time.Period;

public class Operario extends Empleado {
	private int nivel;

	public Operario(String nombre, int edad, LocalDate fechaIngreso, double salario, int nivel) {
		super(nombre, edad, fechaIngreso, salario);
		this.nivel = nivel;
	}

	public int getNivel() {return nivel;}
	public void setNivel(int nivel) {this.nivel = nivel;}

	@Override
	public void incentivar(String incentivo) {
		super.incentivar(incentivo);	
		if(this.getEdad()>30 && this.getNivel()>2) {
			this.setSalario(this.getSalario()+2*Empleado.bono);
		}else if(this.getEdad()>30||this.getNivel()>2) {
			this.setSalario(this.getSalario()+Empleado.bono);
		}
		
		System.out.println("El incentivo del operario es " + this.getSalario());
	}
	
	public void actualizarNivel() {
		Period period=Period.between(this.getFechaIngreso(), LocalDate.now());
		if(period.toTotalMonths()>24 && this.getNivel()<5) {	
			this.setNivel(this.getNivel()+1);
		}
	}
	
}
