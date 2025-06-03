package Vista;
import Modelo.Cliente;
import Controlador.ClienteController;
public class GestionClientes {
    public static void main(String[] args) {
        //Prueba si funciona agregar cliente
        ClienteController cerebro = new ClienteController();
        //2 Guardad un objeto
        Cliente cliente = new Cliente(7);
        //3 Ahora ya puedo guardarlo
        cerebro.BuscarCliente(cliente);
    }    
}
