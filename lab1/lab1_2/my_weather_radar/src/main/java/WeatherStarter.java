

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;

import com.ies.weather.IpmaCityForecast;
import com.ies.weather.IpmaService;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    private static int city_code = 1010500;
    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    private static final Logger logger = Logger.getLogger(WeatherStarter.class.getName());

    public static void  main(String[] args ) {
        
        if (args.length>0)
            city_code=Integer.parseInt(args[0]);
        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(city_code);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info("Latitude: " + forecast.getData().listIterator().next().getLatitude()+ "\nLongitude" + forecast.getData().listIterator().next().getLongitude()  
                + "\nmax temp for today: " + forecast.getData().listIterator().next().getTMax() + "Cº ," + "\nprobabilidade de precipitação: " +forecast.getData().listIterator().next().getPrecipitaProb() +"\n" +city_code);
            } else {
                logger.info( "No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
