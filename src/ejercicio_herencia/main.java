package ejercicio_herencia;
import java.time.LocalDate;
public class main {

	public static void main(String[] args) {
	 Empleado empleado = new Empleado ("Sergio", 30, LocalDate.of(2007,03,03), 1200);
	 System.out.println("Empleado " + empleado.getNombre() + " edad " + empleado.getEdad() + " fecha de ingreso " + empleado.getFechaIngreso() + " salario " + empleado.getSalario());
	
	 Director director = new Director ("Augusto", 30, LocalDate.of(2001,02,03), 1200 , "Ventas", 40);
	 System.out.println("Director " + director.getNombre() + " edad " + director.getEdad() + " fecha de ingreso " + director.getFechaIngreso() + " salario " + director.getSalario() + " departamento " + director.getDepartamento() + " personas a su cargo " + director.getPersonal());
	 
	 Operario operario = new Operario ("Sergio", 31, LocalDate.of(2008,05,06), 1200 , 3);
	 System.out.println("Operario " + operario.getNombre() + " edad " + operario.getEdad() + " fecha de ingreso " + operario.getFechaIngreso() + " salario " + operario.getSalario() + " nivel " + operario.getNivel());
	
	 empleado.incentivar("1000");
	 director.incentivar("incentivo");
	 operario.incentivar("incentivo");
	
	}
	

	
	
	
}
