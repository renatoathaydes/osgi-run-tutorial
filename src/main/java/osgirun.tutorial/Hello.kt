package osgirun.tutorial

import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component

@Component(immediate = true)
class Hello {

    @Activate
    fun start() {
        println("Hello osgi-run ${listOf('k', 'o', 't', 'l', 'i', 'n')}")
    }

}

