package tcd

enum Opt[+T] derives Eq:
  case Sm(t: T)
  case Nn

object Main:
  import Opt.*

  def main(args: Array[String]): Unit =
    // NOTE: Get the following error on this line
    //    cannot reduce summonFrom with
    //      patterns :  case given t @ _:tcd.Eq[tcd.Opt.Sm[Int]]
    val eqoi = summon[Eq[Opt[Int]]]
    assert(eqoi.eqv(Sm(23), Sm(23)))
    assert(!eqoi.eqv(Sm(23), Sm(13)))
    assert(!eqoi.eqv(Sm(23), Nn))
