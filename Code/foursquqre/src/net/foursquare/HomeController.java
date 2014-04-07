package net.foursquare;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.foursquare.api.Foursquare;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueSearchParams;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private final Foursquare foursquare;
	
	@Inject
	public HomeController(Foursquare foursquare) {
		this.foursquare = foursquare;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	    List<Venue> venues = foursquare.venueOperations().search(new VenueSearchParams().location(40.73, -74.0));
		model.addAttribute("venues", venues);
		return "home";
	}

}