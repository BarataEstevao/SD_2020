
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {
    private static final int PORTO = 8080;
    public static void main(String[] args) {
        try {
            ResourceConfig config = new ResourceConfig();
//regista recurso servidor
            config.register(new RecursosServidor());
//regista recurso quarto
            config.register(new RecursosQuartos());
//constroi a base do URI -- basicamente IP e Porto do servidor
            URI uriBase = UriBuilder.fromUri("http://0.0.0.0/").port(PORTO).build();
//informa a base do URI do servidor e os recursos a serem servidos registados na variável config
//desde este ponto o URI base e os recursos, são disponibilizados para soicitação
//já torna-se possível usarhttp://IPdoServidor:PORTO/caminhoDorecurso no cliente para solicitar orecurso pretendido
            JdkHttpServerFactory.createHttpServer(uriBase, config);
//obtem ip do servidor para impressão naconsola do computador
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.printf("Servidor REST aguarda  pedidos em: http://%s:%d\n", ip, PORTO);
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}
