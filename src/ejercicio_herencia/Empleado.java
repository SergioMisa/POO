package ejercicio_herencia;

import java.time.LocalDate;

public class Empleado {
	private String nombre;
	private int edad;
	private LocalDate fechaIngreso;
	public static final double bono=200;
	private double salario;
	
	
	public Empleado(String nombre, int edad, LocalDate fechaIngreso, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaIngreso = fechaIngreso;
		this.salario = salario;
	}


	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}

	public int getEdad() {return edad;}
	public void setEdad(int edad) {this.edad = edad;}

	public LocalDate getFechaIngreso() {return fechaIngreso;}
	public void setFechaIngreso(LocalDate fechaIngreso) {this.fechaIngreso = fechaIngreso;}

	public double getSalario() {return salario;}
	public void setSalario(double d) {this.salario = d;}
	
	
	public void incentivar (String incentivo) {
		System.out.println("este es el incentivo: " +incentivo);
	}
	
}
