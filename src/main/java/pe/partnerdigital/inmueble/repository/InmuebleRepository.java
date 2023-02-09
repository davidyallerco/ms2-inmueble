package pe.partnerdigital.inmueble.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.partnerdigital.inmueble.model.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
}
