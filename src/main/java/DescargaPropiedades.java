import java.io.File;

public class DescargaPropiedades {

    public static void main(String[] args) {

        String PATH = "out\\";
        File directory = new File(PATH);
        if (!directory.exists()) {
            directory.mkdir();
        }

        ArriendoCasas arriendoCasas = new ArriendoCasas();
        ArriendoDepartamentos arriendoDepartamentos = new ArriendoDepartamentos();
        CompraCasasNuevas compraCasasNuevas = new CompraCasasNuevas();
        CompraCasasUsadas compraCasasUsadas = new CompraCasasUsadas();
        CompraDepartamentosNuevos compraDepartamentosNuevos = new CompraDepartamentosNuevos();
        CompraDepartamentosUsados compraDepartamentosUsados = new CompraDepartamentosUsados();

        arriendoCasas.start();
        arriendoDepartamentos.start();
        compraCasasNuevas.start();
        compraCasasUsadas.start();
        compraDepartamentosNuevos.start();
        compraDepartamentosUsados.start();
    }
}
