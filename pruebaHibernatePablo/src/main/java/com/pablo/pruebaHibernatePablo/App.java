package com.pablo.pruebaHibernatePablo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pablo.pruebaHibernatePablo.HibernateUtil;;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// SessionFactory es una instancia que creará objetos de tipo Sessiono(fabrica de sesiones)
    	SessionFactory factory = HibernateUtil.getSessionFactory();

    	// Ahora que ya tenemos el objeto SessionFactory podemos obtener la Session
    	// Una sesión se utiliza para obtener una conexión física con una base de datos.
    	
    	// Los objetos persistentes se guardan y recuperan a través de un objeto de sesión
    	
    	Session session = HibernateUtil.getSession();
    	
    	//El constructor de la clase padre no esta la lista, es decir NO se usa para insertar, solo es para mapear internamenta
    			
    	Departamento d1 = new Departamento(4, "logistica");
    	
    	session.beginTransaction();
		session.save(d1); //Para añadir a la tabla
		
		session.getTransaction().commit();
		
		// el resto de operaciones CRUD se haria como en el ejemplo anterior con una sola clase y tabla
		
		
		//podriamos seleccionar un objeto de la clase padre de otra forma sin crearlo, es decir uno  que ya exista como por ejemplo el que tiene id=1
		Departamento arma2=session.get(Departamento.class, 1);
		
		//ahora insertamos un empleado, tener en cuenta que aqui si es necesario insertar un objeto del padre.
		
		
		Empleado e1 = new Empleado();
		e1.setNombre("Mortadelo");	
		e1.setDep(d1); //Le indicamos a que departamento pertenece
		session.beginTransaction();
		session.save(e1);

		session.getTransaction().commit();
		
		// modificar
		// 1 buscamos el empleado a modificar, suponemos que hemos introducido el 2
		
		Empleado emp_aux = (Empleado) session.createQuery("FROM empleado  WHERE id_empleado = 2").uniqueResult();
		
		if (emp_aux != null) {
			System.out.println(emp_aux.toString());
			// modifico el campo nombre por poner un ejemplo
			emp_aux.setNombre("Rodolfo");
			session.beginTransaction();
			session.update(emp_aux);
			session.getTransaction().commit();
		} else
			System.out.println("EMPLEADO NO ENCONTRADO");
		
    }
  
}
