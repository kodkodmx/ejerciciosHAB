package persistencia;

import logica.Oficina;
import logica.Director;

public class ControladoraPersistencia {
    
    OficinaJpaController oficinaJpa = new OficinaJpaController();
    DirectorJpaController dirJpa = new DirectorJpaController();
    
    
    public void crearOficina(Oficina ofi) {
        oficinaJpa.create(ofi);
    }
    
    public void crearDirector(Director dir) {
        dirJpa.create(dir);
    }

    
}
