public class DescargaPropiedades {

    public static void main(String[] args) {
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
