import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import processors.QueueRunner

@SpringBootApplication
@ComponentScan
class MainConfig


object Application extends App {
  val applicationContext = SpringApplication.run(classOf[MainConfig])
  val runner = applicationContext.getBean(classOf[QueueRunner])
  runner.runQueue()
}