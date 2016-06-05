
package osgirun.tutorial;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.Scanner;

@Component( immediate = true )
public class Hello {

    @Activate
    public void start() {
        System.out.println( "Enter a location:" );
        String location = new Scanner( System.in ).nextLine();

        try {
            YahooWeatherService service = new YahooWeatherService();
            Channel channel = service.getForecastForLocation( location, DegreeUnit.CELSIUS )
                    .first( 1 ).get( 0 );

            int temperature = channel.getItem().getCondition().getTemp();
            String conditions = channel.getItem().getCondition().getText();

            System.out.println( "Weather in " + location + " now: " +
                    temperature + "C, " + conditions );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}

