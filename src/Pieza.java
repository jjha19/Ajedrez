public abstract class Pieza {
 protected boolean color;
 protected String nombre;

 public Pieza(boolean color) {
  this.color = color;
 }

 public boolean getColor(){
  return color;
 }

 public String getNombre(){
  return nombre;
 }

 public void setColor(boolean color){
  this.color = color;
 }

 public void setNombre(String nombre){
  this.nombre = nombre;
 }

 abstract boolean validoMovimiento(Movimiento mov);

 @Override
 public String toString() {
 return nombre;
 }
}
    