package dates

object DateUtils {
  implicit def oldToNewDate(input: LegacyDate): ModernDate = new ModernDate(input.theDate)
}
