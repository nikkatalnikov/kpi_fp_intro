import java.io.{BufferedWriter, FileWriter}
import au.com.bytecode.opencsv.CSVWriter
import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try}

// Lazy and runtime-safe read/write CSVs of integers with filter (passes odds only)

object Task2 {
  def main(args: Array[String]): Unit = {
    task2("ints.csv","odds.csv")
  }

  def task2(sourceURL: String, sinkUrl: String): Unit = {
    val source = readCSVStream(sourceURL)
    val sink = writeCSV(sinkUrl)
    source
      .getLines()
      .map(n => Try(n.toInt))
      .filter(isOdd)
      .foreach(n => sink.writeNext(n.get.toString))

    source.close()
    sink.close()
  }

  def isOdd(maybeInt: Try[Int]): Boolean = maybeInt match {
    case Failure(exception) =>
      println("can't parse String to Int, skipping", exception)
      false
    case Success(n) => n % 2 == 1
  }

  def writeCSV(url: String): CSVWriter = {
    val outputFile = new BufferedWriter(new FileWriter(url))
    new CSVWriter(outputFile)
  }

  def readCSVStream(url: String): BufferedSource = {
    Source.fromResource(url)
  }
}
