package pe.partnerdigital.inmueble.service;

import org.springframework.stereotype.Service;
import pe.partnerdigital.inmueble.model.Inmueble;
import pe.partnerdigital.inmueble.repository.InmuebleRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InmuebleServiceImpl implements InmuebleService{

    //@Autowired
    private final InmuebleRepository inmuebleRepository;


    public InmuebleServiceImpl(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    @Override
    public List<Inmueble> buscarTodos(){
        return inmuebleRepository.findAll();
    }

    @Override
    public Inmueble guardarInmueble(Inmueble inmueble){
        inmueble.setFechaCreacion(LocalDateTime.now());
        return inmuebleRepository.save(inmueble);
    }

    @Override
    public void eliminarInmueble(Long id){
        inmuebleRepository.deleteById(id);
    }
}
