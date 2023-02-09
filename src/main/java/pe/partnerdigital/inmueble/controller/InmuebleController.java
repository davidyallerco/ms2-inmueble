package pe.partnerdigital.inmueble.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.partnerdigital.inmueble.model.Inmueble;
import pe.partnerdigital.inmueble.service.InmuebleService;


@RestController
@RequestMapping("api/inmueble")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    //http://localhost:3333/api/inmueble
    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(inmuebleService.buscarTodos());
    }

    //http://localhost:3333/api/inmueble
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Inmueble inmueble){
        return new ResponseEntity<>( inmuebleService.guardarInmueble(inmueble) , HttpStatus.CREATED);
    }

    //http://localhost:3333/api/inmueble/10
    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        inmuebleService.eliminarInmueble(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
