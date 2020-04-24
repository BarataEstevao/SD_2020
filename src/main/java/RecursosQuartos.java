import java.lang.reflect.Array;
import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;


public class RecursosQuartos {
    boolean verdade=false;
    List<Quarto> listaQuartos=new ArrayList(10);
    //mapeia um hotel e seus respectivos quartos
    private final Map<String, List<Quarto>> hoteis;

    void inserirHoteis(String hotel, List lista) {
        hoteis.put(hotel, lista);
    }
    RecursosQuartos() {
        hoteis = new HashMap<>();
    }
    //retorna todos os quartos de todos hoteis
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Quarto> todos_Quartos() {
        ArrayList<Quarto> Lista_aux = new ArrayList<>();
        Set<String> chaves = hoteis.keySet();

        for (String chave : chaves) {
            if (chave != null) {
                Lista_aux.addAll(hoteis.get(chave));
            }
        }
        return Lista_aux;
    }
    //retorna todos os quartos vazios de todos os hoteisdescriminado por hotel
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, List<Quarto>> quartos_vazios() {
        Map<String, List<Quarto>> listaQuartosVazios = new HashMap<>();
        ArrayList<Quarto> lista_aux = new ArrayList<>();

        Set<String> chaves = hoteis.keySet();

        for (String chave : chaves) {
            if (chave != null) {
                lista_aux.addAll(hoteis.get(chave));
                ArrayList<Quarto> lista = new ArrayList<>();
                for (Quarto quarto : lista_aux) {

                    if (!quarto.ocupacao) {
                        lista.add(quarto);
                    }
                }
                listaQuartosVazios.put(chave, lista);

            }
        }

        return listaQuartosVazios;
    }
    //retorna os quartos de um determinado hotel
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Quarto> quartos_Do_Hotel(String hotel){
        return hoteis.get(hotel);
    }
    //retorna os quartos vazios de um determinado hotel
    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public List<Quarto> quartos_Vazios_Do_Hotel(String hotel) {
        ArrayList<Quarto> lista_aux = new ArrayList<>();
        ArrayList<Quarto> lista_aux2 = new ArrayList<>();

        lista_aux.addAll(hoteis.get(hotel));

        for (Quarto quarto : lista_aux) {
            if (!quarto.ocupacao) {
                lista_aux2.add(quarto);
            }
        }

        return lista_aux2;

    }
    //insere um novo quarto num determinado hotel
    @POST
    public void novo_Quarto(Quarto quarto, String hotel ) {
        hoteis.get(hotel).add(quarto);
    }
}
