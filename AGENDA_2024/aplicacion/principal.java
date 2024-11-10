package aplicacion;

import Interfaz.Interfaz;

public class principal {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();

        if (args.length == 0) {
            interfaz.procesarComando("help");
        } else {
            StringBuilder comando = new StringBuilder();
            for (String arg : args) {
                comando.append(arg).append(" ");
            }
            interfaz.procesarComando(comando.toString().trim());
        }
    }
}
