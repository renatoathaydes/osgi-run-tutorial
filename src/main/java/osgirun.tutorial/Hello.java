
package osgirun.tutorial;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component( immediate = true )
public class Hello {

    @Activate
    public void start() {
        System.out.println( "Hello osgi-run" );
    }

}

