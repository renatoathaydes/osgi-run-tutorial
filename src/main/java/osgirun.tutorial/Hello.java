
package osgirun.tutorial;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component( immediate = true )
public class Hello {

    @Activate
    public void start() {
        try {
            YahooWeatherService service = new YahooWeatherService();
            Channel channel = service.getForecastForLocation( "Stockholm, Sweden", DegreeUnit.CELSIUS )
                    .first( 1 ).get( 0 );

            int temperature = channel.getItem().getCondition().getTemp();
            String conditions = channel.getItem().getCondition().getText();

            System.out.println( "Weather in Stockholm now: " +
                    temperature + "C, " + conditions );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}

