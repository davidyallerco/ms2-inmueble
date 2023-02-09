package pe.partnerdigital.inmueble.service;

import pe.partnerdigital.inmueble.model.Inmueble;

import java.util.List;

public interface InmuebleService {
    List<Inmueble> buscarTodos();

    Inmueble guardarInmueble(Inmueble inmueble);

    void eliminarInmueble(Long id);
}
