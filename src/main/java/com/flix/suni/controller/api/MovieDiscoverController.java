package com.flix.suni.controller.api;

import com.flix.suni.model.Discover;
import com.flix.suni.service.TmdbFeignClient;
import com.flix.suni.utils.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/discover/movie")
public class MovieDiscoverController {

		private static final String apiKey = "f885f7563a2d463bb18ed5f450c6c3d9";

		@Autowired
		private TmdbFeignClient client;

		@GetMapping
		public ResponseEntity<Discover> discoverData(HttpServletRequest request){
				System.out.println(request);
				Discover discover = client.getDiscover(apiKey);

				try{
						return new ResponseEntity(discover, HttpStatus.OK);
				}catch (Exception e){
						return new ResponseEntity(StatusCodes.error500, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
}
