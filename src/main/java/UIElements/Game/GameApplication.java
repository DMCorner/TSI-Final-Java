package UIElements.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin

public class GameApplication {

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private Film_ActorRepository film_actorRepository;

	@Autowired
	public GameApplication(ActorRepository ar, CategoryRepository cr, FilmRepository fr, Film_ActorRepository far) {
		actorRepository = ar;
		categoryRepository = cr;
		filmRepository = fr;
		film_actorRepository = far;
	}

		public static void main(String[] args) {
			SpringApplication.run(GameApplication.class, args);
		}

		// -----ACTORS-ACTORS-ACTORS-ACTORS-ACTORS-ACTORS-ACTORS-ACTORS-ACTORS----------------
		// -----ACTORS-ACTORS-ACTORS-ACTORS-ACTORS-ACTORS-ACTORS-ACTORS-ACTORS----------------

		@GetMapping("/getallactors")
		public @ResponseBody Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
		}

		@GetMapping("/getallactors/{id}")
		public Optional<Actor> getActorFromID(@PathVariable Integer id) {
		return actorRepository.findById(id);
		}
		//set a put mapping in allactors then dependent on ID
		@PutMapping("/putallactors/{id}")
		// make a public object that deals with the actor list
		public Optional<Actor> replaceActor(@RequestBody Actor newActor, @PathVariable Integer id) {

			return Optional.of(actorRepository.findById(id)
					.map(Actor -> {
						Actor.setFirstname(newActor.getFirstname());
						Actor.setLastname(newActor.getLastname());
						return actorRepository.save(Actor);
					})
					.orElseGet(() -> {
						newActor.setActor_ID(id);
						return actorRepository.save(newActor);
					}));
		}
		@DeleteMapping("/delallactors/{id}")
		public void  deleteActor(@PathVariable Integer id) {
			actorRepository.deleteById(id);
		}

		//----------CATEGORIES-CATEGORIES-CATEGORIES-CATEGORIES-CATEGORIES-CATEGORIES-------------
		//----------CATEGORIES-CATEGORIES-CATEGORIES-CATEGORIES-CATEGORIES-CATEGORIES-------------

		@GetMapping("/getallcategories")
		public @ResponseBody Iterable<Category> getAllCategories() {
			return categoryRepository.findAll();
		}

		@GetMapping("/getallcategories/{id}")
		public Optional<Category> getCategoryFromID(@PathVariable Integer id) {
			return categoryRepository.findById(id);
		}
		//set a put mapping in allactors then dependent on ID
		@PutMapping("/putallcategories/{id}")
		// make a public object that deals with the actor list
		public Optional<Category> replaceCategory(@RequestBody Category newCategory, @PathVariable Integer id) {

			return Optional.of(categoryRepository.findById(id)
					.map(Category -> {
						Category.setCategory_name(newCategory.getCategory_name());
						return categoryRepository.save(Category);
					})
					.orElseGet(() -> {
						newCategory.setCategory_ID(id);
						return categoryRepository.save(newCategory);
					}));
		}
		@DeleteMapping("/delallcategories/{id}")
		public void  deleteCategories(@PathVariable Integer id) {
			categoryRepository.deleteById(id);
		}

		// -------------FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS--------------------
		// -------------FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS-FILMS--------------------

		@GetMapping("/getallfilms")
		public @ResponseBody Iterable<Film> getAllFilms() {
			return filmRepository.findAll();
		}

		@GetMapping("/getallfilms/{id}")
		public Optional<Film> getFilmFromID(@PathVariable Integer id) {
			return filmRepository.findById(id);
		}
		//set a put mapping in allactors then dependent on ID
		@PutMapping("/putallfilms/{id}")
		// make a public object that deals with the actor list
		public Optional<Film> replaceActor(@RequestBody Film newFilm, @PathVariable Integer id) {

			return Optional.of(filmRepository.findById(id)
					.map(Film -> {
						Film.setTitle(newFilm.getTitle());
						Film.setDescription(newFilm.getDescription());
						return filmRepository.save(Film);
					})
					.orElseGet(() -> {
						newFilm.setFilm_ID(id);
						return filmRepository.save(newFilm);
					}));
		}
		@DeleteMapping("/delallfilms/{id}")
		public void  deleteFilm(@PathVariable Integer id) {
		filmRepository.deleteById(id);
		}


	// -------------FILMS-ACTORS-FILMS-ACTORS-FILMS-ACTORS-FILMS-ACTORS-FILMS-ACTORS-FILMS---------------
	// -------------------ACTORS-FILMS-ACTORS-FILMS-ACTORS-FILMS-ACTORS-FILMS-ACTORS----------------
//
	@GetMapping("/getallfilms&actors")
	public @ResponseBody Iterable<Film_ActorIntf> getAllFilms_Actors() {
		return filmRepository.getAllFilmsActors();
	}


	@GetMapping("/getallfilms_actors/{id}")
	public @ResponseBody Iterable<Film_ActorIntf> getFilm_ActorFromID(@PathVariable Integer id) {
			return (Iterable<Film_ActorIntf>) filmRepository.getFilm_ActorById(id);
		}

	@GetMapping("/getallactors_films/{id}")
	public @ResponseBody Iterable<Film_ActorIntf> getActor_FilmFromID(@PathVariable Integer id) {
		return (Iterable<Film_ActorIntf>) filmRepository.getActor_FilmById(id);
	}

	// --------------FILMS-CATEGORIES-FILMS-CATEGORIES-FILMS-CATEGORIES-FILMS-CATEGORIES-----------------
	// --------------FILMS-CATEGORIES-FILMS-CATEGORIES-FILMS-CATEGORIES-FILMS-CATEGORIES-----------------

	@GetMapping("/getallfilms&categories")
	public @ResponseBody Iterable<Film_CategoryIntf> getAllFilm_Category() {
		return filmRepository.getAllFilmsCategories();
	}

	@GetMapping("/getallfilmsofcategory/{id}")
	public @ResponseBody Iterable<Film_CategoryIntf> getFilm_CategoryFromID(@PathVariable Integer id) {
		return (Iterable<Film_CategoryIntf>) filmRepository.getFilm_CategoryById(id);
	}

	@GetMapping("/getallcategoriesoffilm/{id}")
	public @ResponseBody Iterable<Film_CategoryIntf> getCategory_FilmFromID(@PathVariable Integer id) {
		return (Iterable<Film_CategoryIntf>) filmRepository.getCategory_FilmById(id);
	}

//		return (Iterable<Film_ActorIntf>) filmRepository.findById(id)
//				.orElseThrow(() -> new ResourceAccessException(("Film not compatible"+ id)));



//	@GetMapping("/allfilms_actors/{id}")
//	public @ResponseBody Optional<Film> getFilm_ActorFromID(@PathVariable Integer id) {
//		for(Film film: getAllFilms()) {
//			matchingIDFilms<String> = new matching<>(
//					filmRepository.findById(id).addfirst()
//			)
//			return filmRepository.findById(id);
//		}
//		return null;
//	}
//		if (id == Film_ActorIntf.getactor_id()) {
//		return filmRepository.getAll();
//		} else { return null;}
//	}
//		if (Film.Film_ID == id) {
//			return filmRepository.findById(id);
//		}
//		else return null;

	//set a put mapping in allactors then dependent on ID
//	@PutMapping("/allfilms_actors/{id}")
//	// make a public object that deals with the actor list
//	public Optional<Film_Actor> replaceActor(@RequestBody Film_Actor newFilm_Actor, @PathVariable Integer id) {
//
//		return Optional.of(film_actorRepository.findById(id)
//				.map(Film_Actor -> {
//					Film_Actor.setFilm_ID(newFilm_Actor.getFilm_ID());
//					Film_Actor.setActor_ID(newFilm_Actor.getActor_ID());
//					return film_actorRepository.save(Film_Actor);
//				})
//				.orElseGet(() -> {
//					newFilm_Actor.setFilm_ID(id);
//					return film_actorRepository.save(newFilm_Actor);
//				}));
//	}
//	@DeleteMapping("/allfilms_actors/{id}")
//	public void  deleteFilm_Actor(@PathVariable Integer id) {
//		film_actorRepository.deleteById(id);
//	}


//		@GetMapping("/allactors/{id}")
//		Actor newActor(@RequestBody Actor newActor) {
//		return actorRepository.save(newActor);
//		}


//		public @ResponseBody Iterable<Actor> getOneActor() {
//
//		return actorRepository.findById(id);



	}
