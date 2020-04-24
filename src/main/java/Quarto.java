public class Quarto {
    public String nome_hotel;
    public int numero_holtel;
    public  boolean ocupacao;


    public Quarto(String nome_hotel, int numero_holtel, boolean ocupacao) {
        this.nome_hotel = nome_hotel;
        this.numero_holtel = numero_holtel;
        this.ocupacao = ocupacao;
    }

    public String getNome_hotel() {
        return nome_hotel;
    }

    public void setNome_hotel(String nome_hotel) {
        this.nome_hotel = nome_hotel;
    }

    public int getNumero_holtel() {
        return numero_holtel;
    }

    public void setNumero_holtel(int numero_holtel) {
        this.numero_holtel = numero_holtel;
    }

    public boolean getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(boolean ocupacao) {
        this.ocupacao = ocupacao;
    }
}
