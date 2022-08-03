package hof

object Program {
  def main(args: Array[String]): Unit = {
    def wrapInH1(text: String) = s"<h1>$text</h1>"
    def wrapInH2(text: String) = s"<h2>$text</h2>"
    def wrapInTag(tagName: String, text: String) = s"<$tagName>$text</$tagName>"

    def buildWrapper(tagName: String): String => String = {
      val openingTag = s"<$tagName>"
      val closingTag = s"</$tagName>"

      (text: String) => s"$openingTag$text$closingTag"
    }

    def buildTagWrapper(tagName: String)(text: String): String = {
      val openingTag = s"<$tagName>"
      val closingTag = s"</$tagName>"

      s"$openingTag$text$closingTag"
    }

    println(wrapInH1("Homer"))
    println(wrapInH2("Marge"))
    println(wrapInTag("h3","Bart"))
    println(wrapInTag("h4","Liza"))

    val wrapInEm = buildWrapper("em")
    val wrapInMark = buildWrapper("mark")

    println(wrapInEm("Maggie"))
    println(wrapInMark("Snowball"))

    val wrapInPara = buildTagWrapper("p")_
    val wrapInDiv = buildTagWrapper("div")_

    println(wrapInPara("Flanders"))
    println(wrapInDiv("Smithers"))
  }
}
