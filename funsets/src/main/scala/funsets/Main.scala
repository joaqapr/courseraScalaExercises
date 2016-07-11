package funsets

object Main extends App {
  import FunSets._
  println("Contains + singletonSet 1: " + contains(singletonSet(1), 1))
  val unionVal = union(singletonSet(1), singletonSet(2))
  println("Union: " + contains(unionVal, 3))
  println("Intersec: " + contains(intersect(unionVal, singletonSet(2)), 2))
  val set = Set(6,5,4,3,2,1)
  println("Forall x > -1: " + forall(set, x => x > -1))
  println("Forall x > 1: " + forall(set, x => x > 1))
  println("Exists x > 1: " + exists(set, x => x > 1))
  println("Map x + 1: ")
  printSet(map(set, x => x + 1))

}
