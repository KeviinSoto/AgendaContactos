package modelo;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Operaciones {

    EntityManagerFactory emf;
    EntityManager em;

    public Operaciones() {
        emf = Persistence.createEntityManagerFactory("EJEMPLOPU");
        em = emf.createEntityManager();
    }

    public void guardar(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception w) {
            System.out.println(w);
        }
    }

    public void borrar(Contacto contacto, int posicion) {
        try {
            contacto = em.find(Contacto.class, posicion);
            em.getTransaction().begin();
            em.remove(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String buscar(String requerido) {
        String nombre, apellido, telefono, celular, email, resultado = "", linea;
        int id;
        try {
            List<Contacto> lista1 = em.createQuery("SELECT c FROM Contacto c where c.nombre = :nombre1 OR c.apellido = :apellido1 OR c.telefono = :telefono1 OR c.celular = :celular1 OR c.email = :email1", Contacto.class).setParameter("nombre1", requerido).setParameter("apellido1", requerido).setParameter("telefono1", requerido).setParameter("celular1", requerido).setParameter("email1", requerido).getResultList();
            for (Contacto contacto : lista1) {
                id = contacto.getId();
                nombre = "Nombre: " + contacto.getNombre();
                apellido = "Apellido: " + contacto.getApellido();
                telefono = "Telefono: " + contacto.getTelefono();
                celular = "Celular: " + contacto.getCelular();
                email = "Email: " + contacto.getEmail();
                linea = String.valueOf(id) + ": " + nombre + " | " + apellido + " | " + telefono + " | " + celular + " | " + email;
                resultado = resultado + "" + linea + "\n";

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;

    }

    public String listar() {
        String nombre, apellido, telefono, celular, email, resultado = "", linea;
        int id;
        try {

            List<Contacto> list = em.createQuery(
                    "SELECT c FROM Contacto c", Contacto.class).getResultList();
            for (Contacto contacto : list) {
                id = contacto.getId();
                nombre = "Nombre: " + contacto.getNombre();
                apellido = "Apellido: " + contacto.getApellido();
                telefono = "Telefono: " + contacto.getTelefono();
                celular = "Celular: " + contacto.getCelular();
                email = "Email: " + contacto.getEmail();
                linea = String.valueOf(id) + ": " + nombre + " | " + apellido + " | " + telefono + " | " + celular + " | " + email;
                resultado = resultado + "" + linea + "\n";

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;

    }
    
    public String[] editar(int posicion)
    {
        String[] d = new String[5];
         try {
            List<Contacto> lista1 = em.createQuery("SELECT c FROM Contacto c where c.id = :id1", Contacto.class).setParameter("id1", posicion).getResultList();
           for (Contacto contacto : lista1)
           {
           d[0] = contacto.getNombre();
           d[1] = contacto.getApellido();
           d[2] = contacto.getTelefono();
           d[3] = contacto.getCelular();
           d[4] = contacto.getEmail();
           }

        } catch (Exception e) {
            System.out.println(e);
        }
        return d;
        
    }
    public void actualizar(int posicion, String nombre, String apellido, String telefono, String celular, String email)
    {
         try {
             em.getTransaction().begin();
             Contacto d = em.find(Contacto.class, posicion);
             d.setNombre(nombre);
             d.setApellido(apellido);
             d.setTelefono(telefono);
             d.setCelular(celular);
             d.setEmail(email);
             em.getTransaction().commit();
        } catch (Exception w) {
            System.out.println(w);
        }
    }

}
