package domain

/**
  * @author Romesh Selvan
  */
case class RomCharmEmail(email : String,
                         firstName : String,
                         lastName : String,
                         areAttending : Boolean,
                         numberAttending : Int)
  extends Email
