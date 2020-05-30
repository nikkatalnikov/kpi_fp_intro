// Symmetric difference of two Seqs or Sets
object Task3 {
  def main(args: Array[String]): Unit = {
    println(task3(List("A", "C", "K", "G", "L", "M"), List("B", "M", "G", "V")))
    println(task3((1 to 100).toSet, (1 to 101).toSet))
  }

  def task3[T](s1: Seq[T], s2: Seq[T]): Seq[T] = {
    val seed: Seq[T] = Seq()
    s1.foldLeft(seed)((acc, x) => if (s2 contains x ) acc else acc :+ x)
  }

  def task3[T](s1: Set[T], s2: Set[T]): Set[T] = {
    val seed: Set[T] = Set()
    if (s1.size > s2.size)
      s1.foldLeft(seed)((acc, x) => if (s2 contains x) acc else acc + x)
    else
      s2.foldLeft(seed)((acc, x) => if (s1 contains x) acc else acc + x)
  }
}
