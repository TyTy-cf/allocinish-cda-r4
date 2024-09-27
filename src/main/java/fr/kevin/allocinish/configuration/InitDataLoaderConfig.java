package fr.kevin.allocinish.configuration;

import fr.kevin.allocinish.entity.Director;
import fr.kevin.allocinish.entity.Film;
import fr.kevin.allocinish.repository.DirectorRepository;
import fr.kevin.allocinish.repository.FilmRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class InitDataLoaderConfig implements CommandLineRunner {

    private final DirectorRepository directorRepository;
    private final FilmRepository filmRepository;

    private final Faker faker;

    @Autowired
    public InitDataLoaderConfig(
        DirectorRepository directorRepository,
        FilmRepository filmRepository
    ) {
        this.directorRepository = directorRepository;
        this.filmRepository = filmRepository;
        this.faker = new Faker(Locale.of("fr"));
    }


    @Override
    public void run(String... args) {
        createDirectors();
        createFilms();
    }

    private void createFilms() {
        List<Director> directors = directorRepository.findAll();
        if (filmRepository.count() == 0) {
            for (int i = 0; i < 150; i++) {
                Film film = new Film();
                film.setBo(faker.music().chord());
                film.setDescription(faker.lorem().sentence(20));
                film.setTitle(faker.oscarMovie().movieName());

                try {
                    String dateString = faker.oscarMovie().releaseDate().replaceAll("(\\d+)(st|nd|rd|th)", "$1");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
                    film.setReleasedAt(LocalDate.parse(dateString, formatter).atStartOfDay());
                } catch (DateTimeParseException e) {
                    film.setReleasedAt(LocalDateTime.now());
                }

                film.setDuration(faker.random().nextInt(80, 210));
                film.setPoster(faker.image().base64PNG().substring(0, 255));
                Random rand = new Random();
                film.setDirector(directors.get(rand.nextInt(0, 50)));
                filmRepository.save(film);
            }
            filmRepository.flush();
        }
    }

    private void createDirectors() {
        if (directorRepository.count() == 0) {
            for (int i = 0; i < 50; i++) {
                Director director = new Director();
                director.setName(faker.name().fullName());
                directorRepository.save(director);
            }
            directorRepository.flush();
        }
    }

//    private void createAddresses() {
//        List<String> duplicates = new ArrayList<>();
//        if (addressRepository.count() == 0) {
//            List<User> users = userRepository.findAll();
//            for (long i = 1L; i <= 500L; i++) {
//                Address address = new Address();
//                address.setCity(faker.address().cityName());
//                address.setLatitude(faker.address().latitude());
//                address.setLongitude(faker.address().longitude());
//                address.setStreetName(faker.address().streetName());
//                address.setStreetNumber(faker.address().streetAddressNumber());
//                address.setZipCode(faker.address().zipCode());
//                Random random = new Random();
//                if (random.nextBoolean()) {
//                    User user;
//                    do {
//                        user = users.get(random.nextInt(1, 500));
//                    } while (duplicates.contains(user.getUuid()));
//                    duplicates.add(user.getUuid());
//                    address.setUser(user);
//                }
//                addressRepository.save(address);
//            }
//            addressRepository.flush();
//        }
//    }
//
//    private void createUsers() {
//        if (userRepository.count() != 500) {
//            for (long i = 1L; i <= 500L; i++) {
//                User user = new User();
//                user.setCreatedAt(LocalDateTime.now());
//                user.setFirstName(faker.name().firstName());
//                user.setLastName(faker.name().lastName());
//                user.setEmail(faker.internet().emailAddress(
//                    user.getFirstName() + "." + user.getLastName()
//                ).toLowerCase());
//                user.setPhone(faker.phoneNumber().cellPhone());
//                user.setBirthAt(generateRandomDate(
//                        Instant.now().minusSeconds(999999999)
//                                .minusSeconds(999999999)
//                                .minusSeconds(999999999)).toLocalDate());
//                user.setPassword(faker.internet().password(8, 12, true, true));
//                user.setSiret(faker.number().digits(14));
//                user.setRoles("[\"ROLE_USER\"]");
//                userRepository.save(user);
//            }
//            userRepository.flush();
//        }
//    }
//
//    private void createBrands() {
//        List<String> duplicates = new ArrayList<>();
//        if (brandRepository.count() == 0) {
//            for (long i = 1L; i <= 29L; i++) {
//                Brand brand = new Brand();
//                String name;
//                do {
//                    name = faker.vehicle().make();
//                } while (duplicates.contains(name));
//                duplicates.add(name);
//                brand.setName(name);
//                brandRepository.save(brand);
//            }
//            brandRepository.flush();
//        }
//    }
//
//    private void createModels() {
//        List<String> duplicates = new ArrayList<>();
//        if (modelRepository.count() == 0) {
//            for (int i = 0; i <= 160; i++) {
//                Model model = new Model();
//                Random random = new Random();
//                Brand brand;
//                String name;
//                do {
//                    brand = brandRepository.findById(random.nextLong(1L, 29L)).get();
//                    name = faker.vehicle().model(brand.getName());
//                } while (duplicates.contains(name));
//                duplicates.add(name);
//                model.setName(name);
//                model.setBrand(brand);
//                modelRepository.save(model);
//            }
//            modelRepository.flush();
//        }
//    }
//
//    private void createFuels() {
//        List<String> duplicates = new ArrayList<>();
//        if (fuelRepository.count() < 7) {
//            for (long i = 1L; i <= 7L; i++) {
//                Fuel fuel = new Fuel();
//                String name;
//                do {
//                    name = faker.vehicle().fuelType();
//                } while (duplicates.contains(name));
//                duplicates.add(name);
//                fuel.setType(name);
//                fuel.setLogo(faker.image().base64SVG().substring(0, 255));
//                fuelRepository.save(fuel);
//            }
//            fuelRepository.flush();
//        }
//    }
//
//    private void createListings() {
//        List<User> users = userRepository.findAll();
//        if (listingRepository.count() < 1000) {
//            for (int i = 1; i <= 1000; i++) {
//                Random random = new Random();
//                Listing listing = new Listing();
//                listing.setCreatedAt(LocalDateTime.now());
//                Fuel fuel = fuelRepository.findById(random.nextLong(1L, 7L)).get();
//                listing.setFuel(fuel);
//                listing.setMileage(faker.number().numberBetween(5000L, 250000L));
//                listing.setPrice(faker.number().numberBetween(250000L, 7000000L));
//                listing.setProducedAt(generateRandomDate(
//                        Instant.now().minusSeconds(999999999)));
//
//                Model model = modelRepository.findById(random.nextLong(1L, 148L)).get();
//                listing.setModel(model);
//
//                Address address = addressRepository.findById(random.nextLong(1L, 500L)).get();
//                listing.setAddress(address);
//
//                listing.setDescription(faker.lorem().sentence(45, 9));
//
//                User user = users.get(random.nextInt(1, 500));;
//                listing.setOwner(user);
//
//                listing.setTitle("Vente de " +
//                        listing.getModel().getBrand().getName() +
//                        " " + listing.getModel().getName() +
//                        " à " + (listing.getPrice() / 100) + "€");
//
//                listingRepository.save(listing);
//            }
//            listingRepository.flush();
//        }
//    }
//
//    private void createImages() {
//        List<Listing> listings = listingRepository.findAll();
//        Random random = new Random();
//        for (Listing listing : listings) {
//            for (int i = 0; i < random.nextInt(1, 5); i++) {
//                Image image = new Image();
//                image.setPath(faker.image().base64PNG());
//                image.setListing(listing);
//                imageRepository.save(image);
//            }
//        }
//        imageRepository.flush();
//    }
//
//    private void createFavorites() {
//        List<User> users = userRepository.findAll();
//        List<Listing> listings = listingRepository.findAll();
//        Random random = new Random();
//        for (User user : users) {
//            for (int i = 0; i < random.nextInt(2, 8); i++) {
//                Listing listing = listings.get(
//                        random.nextInt(1, 1000));
//                Favorite favorite = new Favorite();
//                favorite.setCreatedAt(generateRandomDate(
//                        Instant.now().minusSeconds(999999999)));
//                favorite.setUser(user);
//                favorite.setListing(listing);
////                favorite.setUserListingID(new UserListingId(user.getUuid(), listing.getUuid()));
//                favoriteRepository.save(favorite);
//            }
//        }
//        favoriteRepository.flush();
//    }

    private LocalDateTime generateRandomDate(Instant start) {
        Faker faker = new Faker();
        Instant randomDate = faker.timeAndDate().between(
                start,
                Instant.now());
        return randomDate.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
