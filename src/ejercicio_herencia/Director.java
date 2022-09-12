package ejercicio_herencia;

import java.time.LocalDate;
import java.time.Period;

public class Director extends Empleado {
	
	private String departamento;
	private int personal;
	

	public Director(String nombre, int edad, LocalDate fechaIngreso, double salario, String departamento,int personal) {
		super(nombre, edad, fechaIngreso, salario);
		this.departamento = departamento;
		this.personal = personal;
	}
	public String getDepartamento() {return departamento;}
	public void setDepartamento(String departamento) {this.departamento = departamento;}


	public int getPersonal() {return personal;}
	public void setPersonal(int personal) {this.personal = personal;}
	
	
	
	@Override
	public void incentivar(String incentivo) {
		super.incentivar(incentivo);
		Period period=Period.between(this.getFechaIngreso(), LocalDate.now());
		
		if(period.toTotalMonths()>30 && this.getPersonal()>20) {
			this.setSalario(this.getSalario()+2*Empleado.bono);
		}else if(period.toTotalMonths()>30||this.getPersonal()>20) {
			this.setSalario(this.getSalario()+Empleado.bono);
		}
		double nuevosalario = this.getSalario();
		this.setSalario(nuevosalario);
		System.out.println("El salario del director es " + this.getSalario() );
	}




	
	
}
