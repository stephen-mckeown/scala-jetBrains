package comprehensions

class Employee(val name : String, val dept : String, val age : Int, val salary : Double)

class Department(val name : String,  val location : String)

object Program {
  /*  This is the expected output:

        Dave works in London
        Jane works in Dublin
        Fred works in London
        Mary works in Dublin
        Peter works in London
        Lucy works in Dublin
        Simon works in London
        Hazel works in Dublin
   */
  def main(args: Array[String]): Unit = {
   val results =  for {

      staff <- buildStaff
      debt <- buildDepartments if debt.name == staff.dept
      val asdf = 9
    } yield(staff.name, debt.location)

    for {
      (name, dept) <- results
    } println(s"${name} works in  ${dept}")

  }

  def buildStaff(): Array[Employee] = {
    Array(
      new Employee("Dave", "IT", 21, 30500.0),
      new Employee("Jane", "HR", 22, 31000.0),
      new Employee("Fred", "IT", 23, 31500.0),
      new Employee("Mary", "HR", 24, 32000.0),
      new Employee("Peter", "IT", 25, 32500.0),
      new Employee("Lucy", "HR", 26, 33000.0),
      new Employee("Simon", "IT", 27, 33500.0),
      new Employee("Hazel", "HR", 28, 34000.0)
    )
  }

  def buildDepartments(): Array[Department] = {
    Array(
      new Department("IT", "London"),
      new Department("HR", "Dublin"),
      new Department("Sales", "Belfast")
    )
  }
}
