import datos.ClienteDAO;
import datos.IClienteDAO;
import dominio.Cliente;
import java.util.Scanner;
public class FrondEnd {

    public static void main(String[] args) {
        System.out.println("Bienvenido a Vital Gym");
        Scanner tec = new Scanner(System.in);
        IClienteDAO Iclientedao = new ClienteDAO();
        Cliente cliente = new Cliente();
        System.out.println("Elige una opción \n [1] Listar Clientes \n [2] Buscar Cliente por ID \n [3] Agregar Cliente \n [4] Editar cliente \n [5] Elimar Cliente");
        String op = tec.nextLine();
        if(op.equals("6")){
            System.out.println("Hasta luego");
            return;
        }
        switch (op) {
            case "1": System.out.println("Clientes \n ==================");
                           var clientes = Iclientedao.ListarClientes() ;
                           for(Cliente cliente1 : clientes){
                            System.out.println(cliente1);
                           }
                            break;
            case "2":System.out.println("Buscar Clientes\n=====================");
                          System.out.print("Ingresa el ID del cliente : ");
                          int id = tec.nextInt();
                          tec.nextLine();
                          cliente.setId(id);
                          var cliente2 = Iclientedao.BuscarClientesPorId(cliente);
                          if(cliente2){                          
                              System.out.println("El cliente es : " + cliente);
                          }
                          else{
                              System.out.println("No existe el : "+ cliente.getId());
                          } break;
             case "3":System.out.println("Agregar cliente : ");
                          System.out.print("Nombre : ");
                          String nombre = tec.nextLine();
                          System.out.print("Apellido : ");
                          String apellido = tec.nextLine();
                          System.out.print("Membresia : ");
                          Double membresia = tec.nextDouble();
                          tec.nextLine();
                          cliente.setNombres(nombre);
                          cliente.setApellidos(apellido);
                          cliente.setMembresia(membresia);
                          var agregado =  Iclientedao.AgregarCliente(cliente);
                          if(agregado){
                              System.out.println("Agregado correctamente");
                          }
                          else{
                              System.out.println("Error al agregar cliente");
                          }
                          break;
               case "4":System.out.println("Modificar cliente : ");
                          System.out.print("Identificador : ");
                          id = tec.nextInt();
                          tec.nextLine();
                          System.out.print("Nombre : ");
                          nombre = tec.nextLine();
                          System.out.print("Apellido : ");
                          apellido = tec.nextLine();
                          System.out.print("Membresia : ");
                          membresia = tec.nextDouble();
                          tec.nextLine();
                          cliente.setId(id);
                          cliente.setNombres(nombre);
                          cliente.setApellidos(apellido);
                          cliente.setMembresia(membresia);
                          var Modificado =  Iclientedao.ModificarCliente(cliente);
                          if(Modificado){
                              System.out.println("Modificado correctamente");
                          }
                          else{
                              System.out.println("Error al modificar cliente");
                          }
                          break;
               case "5":System.out.println("Eliminar cliente\n=====================");
                          System.out.print("Ingresa el ID del cliente : ");
                          id = tec.nextInt();
                          tec.nextLine();
                          cliente.setId(id);
                          var eliminado = Iclientedao.EliminarCliente(cliente);
                          if(eliminado){                          
                              System.out.println("El cliente fue eliminado");
                          }
                          else{
                              System.out.println("El cliente no existe");
                          } break;
            }
        }
}
