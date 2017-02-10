package domain

/**
  * @author Romesh Selvan
  */
class RomCharmEmail(ec : String, fc : String, lc : String, aAc : Boolean, nAc : Int) extends Email{
  val firstName : String = fc
  val lastName : String = lc
  val areAttending : Boolean = aAc
  val numberAttending : Int = nAc
  val email: String = ec
}
