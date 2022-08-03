package palindromes

object Program {
  def main(args: Array[String]) {
    val data1 = "A man, a plan, a canal, Panama"
    val data2 = "Gold is where you find it"
    val data3 = "If I had a hi-fi"
    val data4 = "Fortune favors the prepared mind"
    val data5 = "Rats live on no evil star"
    val data6 = "There is no abstract living"
    val data7 = "Some men interpret nine memos"

    test(data1)
    test(data2)
    test(data3)
    test(data4)
    test(data5)
    test(data6)
    test(data7)
  }
  def test(data : String) {
    val clean = data.replaceAll("\\s" , "").replaceAll("[,-]", "")
    val as = clean.map(a => {a.toLower })
   if(as == as.reverse) {
    println(" might be a palindrome...",data)
   }
   else  printf("No dice")
  }
}
