package negocio;
import java.util.ArrayList;

public class Patio {
    protected ArrayList<Caminhao> caminhoesPatioLista;
    private ArrayList<Caminhao> filaEntrada;
    private ArrayList<Caminhao> filaSaida;
    private int vagasDisponiveis;
    private int qtdVagas = 20;

    public Patio(int vagasDisponiveis, int qtdVagas) {
        this.filaEntrada = new ArrayList<>();
        this.filaSaida = new ArrayList<>();
        this.vagasDisponiveis = vagasDisponiveis;
        this.caminhoesPatioLista = new ArrayList<>();
        this.qtdVagas = qtdVagas;
    }

    public Patio() {
        this.filaEntrada = new ArrayList<>();
        this.filaSaida = new ArrayList<>();
        this.caminhoesPatioLista = new ArrayList<>();
    }

    public Patio(int qtdVagas) {
        this.qtdVagas = qtdVagas;
        this.vagasDisponiveis = qtdVagas;
        this.filaEntrada = new ArrayList<>();
        this.filaSaida = new ArrayList<>();
        this.caminhoesPatioLista = new ArrayList<>();
    }

    public ArrayList<Caminhao> getFilaEntrada() {
        return filaEntrada;
    }

    public void setFilaEntrada(ArrayList<Caminhao> filaEntrada) {
        this.filaEntrada = filaEntrada;
    }

    //
    public ArrayList<Caminhao> getFilaSaida() {
        return filaSaida;
    }

    public void setFilaSaida(ArrayList<Caminhao> filaSaida) {
        this.filaSaida = filaSaida;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Patio{" +
                "filaEntrada=" + filaEntrada +
                ", filaSaida=" + filaSaida +
                ", vagasDisponiveis=" + vagasDisponiveis +
                '}';
    }

    public boolean adicionarCaminhao(Caminhao caminhao) {
        if (caminhao == null) {
            throw new IllegalArgumentException("O caminhao informado eh nulo");
        }

        if (caminhoesPatioLista.size() < vagasDisponiveis) {
            boolean add = caminhoesPatioLista.add(caminhao);
            if (add) {
                vagasDisponiveis--;
            }
            return add; // garante retorno mesmo que add seja false
        } else {
            filaEntrada.add(caminhao);
            return false;
        }
    }



    protected boolean adicionarFilaSaida(Caminhao caminhao){
        if (caminhao == null){
            throw new IllegalArgumentException("caminhao nulo");
        }
        boolean estavaNoPatio = caminhoesPatioLista.remove(caminhao);
        if(!estavaNoPatio){
            return false;
        }
        filaSaida.add(caminhao);
        return true;
    }

    protected boolean liberarSaida(Caminhao caminhao) {
        if (caminhao == null) {
            throw new IllegalArgumentException("Caminhao informado eh nulo");
        }
        boolean removido = filaSaida.remove(caminhao);
        if (!removido) {
            throw new IllegalArgumentException("O caminhão placa: " + caminhao.getPlaca() + " não está na fila");
        }
        if(removido){
            vagasDisponiveis++;
        }
        if(!filaEntrada.isEmpty()){
            Caminhao proximo = filaEntrada.remove(0);
            caminhoesPatioLista.add(proximo);
            vagasDisponiveis--;
        }
        return true;
    }
    public void listarCaminhoes(){
        System.out.println("caminhoes no patio: ");
        for(Caminhao caminhao : caminhoesPatioLista){
            System.out.println("-" + caminhao);
        }
    }

    /*metodo para listar os caminhoes do patio
    public ArrayList<Caminhao> listarCaminhoesPatio(){
        return new ArrayList<>(caminhoesPatioLista);
    }

    // ajeitar isso

    public void listarCaminhoes(){
        System.out.println("caminhoes no patio: ");
        for(Caminhao caminhao : caminhoesPatioLista){
            System.out.println("-" + caminhao);
        }

    }
    //pra ver se a lista ta vazia eh na ui e essa eh p/ mostrar a lista de netrada
    public ArrayList<Caminhao> listarFilaEntrada() {
        return new ArrayList<>(filaEntrada); // retorna uma cópia da lista
    }

    public ArrayList<Caminhao> listarFilaSaida() {
    return new ArrayList<>(filaSaida); // retorna uma cópia da lista
    }


    public void listarFilas(){
        if (filaEntrada == null || filaEntrada.isEmpty()){
            System.out.println("A fila de entrada do patio esta vazia.");
        }else{
            System.out.println("FILA DE ENTRADA DE CAMINHOES: ");
            for(Caminhao caminhao : filaEntrada){
                System.out.println("-" + caminhao);
            }
        }
        if(filaSaida == null || filaSaida.isEmpty()){
            System.out.println("A fila de saida do patio esta vazia.");
        }else{
            System.out.println("FILA DE SAIDA DE CAMINHOES");
            for(Caminhao caminhao : filaSaida){
                System.out.println("-" + caminhao);

            }
        }
    }
*/
    public ArrayList<Caminhao> getCaminhoesPatioLista() {
        return caminhoesPatioLista;
    }


}