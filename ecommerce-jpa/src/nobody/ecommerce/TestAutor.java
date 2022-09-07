package nobody.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import nobody.ecommerce.entity.Autor;
import nobody.ecommerce.entity.Libro;

public class TestAutor {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		/*em.getTransaction().begin();
		Autor autor1 = new Autor();
		autor1.setNombre("Fer");
		autor1.setNacionalidad("Mexicana");
		Autor autor2 = new Autor();
		autor2.setNombre("Emmanuel");
		autor2.setNacionalidad("Mexicana");
		Autor autor3 = new Autor();
		autor3.setNombre("Daniela");
		autor3.setNacionalidad("mexicana");
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);
		
		Libro libro1 = new Libro();
		Libro libro2 = new Libro();
		Libro libro3 = new Libro();
		libro1.setAutor(autor1);
		libro1.setTitulo("programar en java es facil");
		libro2.setAutor(autor1);
		libro2.setTitulo("programar en java no es tan facil");
		libro3.setAutor(autor2);
		libro3.setTitulo("c es facil");
		
		em.persist(libro1);
		em.persist(libro2);
		em.persist(libro3);
		em.getTransaction().commit();*/
		em.getTransaction().begin();
		Autor autor = em.find(Autor.class, 2L);
		Libro lib = new Libro();
		lib.setTitulo("nuevo libro escrito 5");
		lib.setAutor(autor);
		//autor.getLibros().add(lib);
		//autor.addLibro(lib);
		em.persist(lib);
		em.getTransaction().commit();
		List<Libro> libros = autor.getLibros();
		System.out.println("Autor -> "+autor.getNombre());
		
		for(Libro libro:libros) {
			System.out.println("* "+libro);
			
		}
		
		
		
		
		
	}
}
