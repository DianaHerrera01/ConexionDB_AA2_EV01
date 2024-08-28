
package conexion;

public class Main {

 
     public static void main(String[] args) {
        ConexionDB objcli = new ConexionDB();
        objcli.insertar();
        objcli.consultar();
        objcli.actualizar();
        objcli.eliminar();
    }
    
}
