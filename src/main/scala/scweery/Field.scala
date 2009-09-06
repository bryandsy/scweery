package scweery
abstract class Field(val name: String) {
  type T
  def value: T
  override def toString = String valueOf value
  def s = value.asInstanceOf[String]
  def i = try {
    value.asInstanceOf[Int]
  } catch {
    case e => throw new RuntimeException("Field name is " + name, e) 
  }
  def d = value.asInstanceOf[Double]
}

class StringField(name: String, f: String) extends Field(name) {
  type T = String
  override def value: T = f
}

class IntField(name: String, f: Int) extends Field(name) {
  type T = Int
  override def value: T = f
}

class DoubleField(name: String, f: Double) extends Field(name) {
  type T = Double
  override def value: T = f
}
