package ui;
import fachada.DistribuidoraFachada;
import fachada.DistribuidoraFachada;
import negocio.*;
import negocio.exceptions.ClienteNaoExisteException;
import negocio.exceptions.PontoException;
import negocio.Patio;
import negocio.exceptions.VagaInsuficienteException;

import java.util.ArrayList;


public class TelaPrincipal {
    public static void main(String[] args) throws VagaInsuficienteException {
        System.out.println("=== Sistema da Distribuidora ===");

        DistribuidoraFachada fachada = new DistribuidoraFachada();
        AuxiliarAdm adm = new AuxiliarAdm("adm2025", "568794");
        Caminhao caminhao = new Caminhao("1233");
        Cliente c1 = new Cliente("Lucas", 25, "123456", "9999-0000", "Rua A", "lucas@email.com", "Pessoa Física");
        fachada.cadastrarCliente(c1);
        Produto p1 = new Produto("001", "Arroz", "Pacote 5kg", (double) 25.0F, 10);
        Estoque estoque = new Estoque();
        Motorista motorista = new Motorista("12599", caminhao, "motorista", 4000.00, "Joao", 30, "1234879", "8788987", "rua f", "@joao", "7989898");


        fachada.cadastrarProduto(p1, estoque);
        System.out.println(p1.getPreco());
        fachada.atualizarPreco(p1, 10.0F);
        System.out.println(p1.getPreco());
        fachada.listarProdutos();
        fachada.cadastrarMotorista(motorista);
        Patio patio2 = new Patio(5);
        fachada.cadastrarCaminhao(caminhao, patio2);
        fachada.listarCaminhoesPatio();
        fachada.permitirEntrada(caminhao, patio2);
        System.out.println(patio2.getVagasDisponiveis());
        fachada.adicionarFilaSaida(caminhao, patio2);
        fachada.permirSaida(caminhao, patio2);
        System.out.println(patio2.getVagasDisponiveis());


        fachada.listarClientes();
        fachada.listarProdutos();

        fachada.baterPonto(motorista);
        fachada.baterPonto(motorista);
        fachada.baterPonto(adm);

        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(p1);
        System.out.println("criando pedido.....");
        Pedido pedido = fachada.criarPedido(c1, listaProdutos, estoque);
        fachada.pagarPedido(c1, pedido, 250.00, estoque);
        fachada.listarProdutos();
    }
}