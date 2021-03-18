import org.junit.jupiter.api.Test
import ru.stepanov.java_awesome.Sender
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class RestTemplateConf {
    companion object Log {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Test
    fun test() {
        val sender = Sender()

        log.error("\n\nSTART PROCESSING\n")
        kotlin.runCatching {
            sender.sendRequest()
                    .doOnError { error ->
                        log.warn("\n\nERROR OCCURED", error)
                        kotlin.runCatching {
                            throw RuntimeException("THROW inside reactive stream")
                        }.onFailure {
                            System.err.println("\n\nCATCH INSIDE\n" + it.message + "\n")
                        }
                    }
                    .doOnSuccess { res ->
                        log.warn("\n\nSUCCESSFUL: " + res.statusCodeValue)
                        val body = res.body
                        println(body)
                    }
                    .subscribe()
        }.onFailure {
            System.err.println("\n\nCATCH OUTSIDE\n" + it.message + "\n")
        }
        log.error("\n\nFINISH PROCESSING")

        while (true) {
            println(1)
            Thread.sleep(1_000)
        }
    }


}