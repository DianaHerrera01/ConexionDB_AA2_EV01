
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConexionDB {
   private String url= "jdbc:mysql://localhost:3303/";
   private String bd="proyecto_db";
   private String user="root";
   private String password="";
   private String driver ="com.mysql.cj.jdbc.Driver";
   private Connection con;
   private Statement st;
   private ResultSet rs;
    
   public ConexionDB(){
       try{
           Class.forName(driver);
           con = DriverManager.getConnection(url+bd,user,password);
           st = con.createStatement();
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }

   public void consultar(){
       try{
           String query = "SELECT * FROM producto";
           rs = st.executeQuery(query);
           while(rs.next()){
               int idProducto = rs.getInt("IdProducto");
               int cantidad = rs.getInt("Cantidad");
               int categoriaID = rs.getInt("CategoriaID");
               String nombreProducto = rs.getString("NombreProducto");
               String descripcion = rs.getString("Descripcion");
               String nombreProveedor = rs.getString("NombreProveedor");
               double precioCompra = rs.getDouble("PrecioUnidadCompra");
               double precioVenta = rs.getDouble("PrecioUnidadVenta");

               System.out.println("Id Producto: " + idProducto + 
                                  "\nCantidad: " + cantidad + 
                                  "\nCategoriaID: " + categoriaID +  
                                  "\nNombre del Producto: " + nombreProducto + 
                                  "\nDescripción: " + descripcion +
                                  "\nNombre del Proveedor: " + nombreProveedor + 
                                  "\nPrecio de Compra: " + precioCompra + 
                                  "\nPrecio de Venta: " + precioVenta + "\n");
           }
           rs.close();
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
    
    public void insertar(){
     try{
         String query = "INSERT INTO producto (IdProducto, Cantidad, CategoriaID, NombreProducto, Descripcion,"
                 + " NombreProveedor, PrecioUnidadCompra, PrecioUnidadVenta) VALUES (2, 10, 3, 'Teclado KeyMaster MX', "
                 + "'Teclado mecanico retroiluminado con switch azul', 'Jorge Vargas', 320000, 400000)";
         st.executeUpdate(query);
         System.out.println("El producto se ingresó satisfactoriamente\n");
      }catch(Exception ex){
         ex.printStackTrace();
     }
    }

   public void actualizar(){
       try{
           String query = "UPDATE producto SET Cantidad = 20, PrecioUnidadVenta = 20.000 WHERE IdProducto = 2";
           st.executeUpdate(query);
           System.out.println("El producto se actualizó satisfactoriamente\n");
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
    
   public void eliminar(){
       try{
           String query = "DELETE FROM producto WHERE IdProducto = 2";
           st.executeUpdate(query);
           System.out.println("El producto se eliminó satisfactoriamente\n");
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
}

