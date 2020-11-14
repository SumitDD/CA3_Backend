package fetcher;

import com.google.gson.Gson;
import dto.CombinedDTO;
import dto.PeopleDTO;
import dto.PersonDTO;
import dto.PlanetDTO;
import dto.SpeciesDTO;
import dto.StarshipDTO;
import dto.VehicleDTO;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import utils.HttpUtils;

public class PersonFetcher {
    private static final String PERSON_URL = "https://api.namefake.com/";
  
    
    public static String responseFromExternalServersParrallel(ExecutorService threadPool, Gson gson) throws InterruptedException, ExecutionException, TimeoutException {

        Callable<PersonDTO> personTask = new Callable<PersonDTO>() {
            @Override
            public PersonDTO call() throws Exception {
                String person = HttpUtils.fetchData(PERSON_URL);
                PersonDTO personDTO = gson.fromJson(person, PersonDTO.class);
                return personDTO;
            }
        };

        Future<PersonDTO> futurePerson = threadPool.submit(personTask);
        PersonDTO person = futurePerson.get(2, TimeUnit.SECONDS);

        String combinedJSON = gson.toJson(person);
        return combinedJSON;
        
    }

}
