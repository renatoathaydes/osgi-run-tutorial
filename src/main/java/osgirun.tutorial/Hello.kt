package osgirun.tutorial

import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component
import java.util.*
import javax.script.ScriptEngineManager

@Component(immediate = true)
class Hello {

    @Activate
    fun start() {
        val prompt = "Frege > "
        val engine = ScriptEngineManager().getEngineByName("frege") ?:
                throw RuntimeException("Frege ScriptEngine was not found")

        // never block the Component's @Activate method
        Thread().run {
            val scanner = Scanner(System.`in`)

            val hasInput = {
                print(prompt)
                scanner.hasNextLine()
            }

            while (hasInput()) {
                val line = scanner.nextLine()
                if (line == "exit") {
                    break
                } else {
                    println(engine.eval(line) ?: "")
                }
            }
        }
    }

}

