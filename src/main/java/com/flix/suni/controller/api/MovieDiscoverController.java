package com.flix.suni.controller.api;

import com.flix.suni.model.Discover;
import com.flix.suni.service.TmdbFeignClient;
import com.flix.suni.utils.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MovieDiscoverController {

		@Autowired
		private TmdbFeignClient client;

		@GetMapping("discover/movie")
		public ResponseEntity<Optional<Discover>> discoverData(HttpServletRequest request){

				try{
						Optional<Object> discover = Optional.ofNullable(client.getDiscover());
						System.out.println(request);
						return new ResponseEntity(discover.get(), HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}


}
