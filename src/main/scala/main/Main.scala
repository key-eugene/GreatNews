package main

import com.typesafe.scalalogging.Logger
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException

object Main extends App {

  //to call tdlib Api
  // -Djava.library.path=<absolute path to these sources>/src/main/java/org/drinkless/tdlib/example
  // needs to be added to VM options
  //class Example - is the example of usage
  val logger = Logger("Main")
  ApiContextInitializer.init()

  val bot = new Bot()
  val botsApi = new TelegramBotsApi()
  try botsApi.registerBot(bot)
  catch {
    case ex: TelegramApiRequestException =>
      logger.error(s"Error $ex")
      ex.printStackTrace()
  }
  logger.info("Bot Started")

}
