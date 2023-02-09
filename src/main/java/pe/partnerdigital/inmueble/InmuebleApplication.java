package pe.partnerdigital.inmueble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InmuebleApplication {

	public static void main(String[] args) {
		SpringApplication.run(InmuebleApplication.class, args);
	}

	/**
	 * http://localhost:3333/api/inmueble
	 * configurar en authoriazation el user y clave
	 * {
	 *     "nombre": "Casa de playa",
	 *     "direccion": "Av las gardenias 335",
	 *     "precio": 8000
	 * }
	 *
	 */
}
