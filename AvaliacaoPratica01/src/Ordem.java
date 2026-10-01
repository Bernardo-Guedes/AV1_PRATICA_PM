import java.time.LocalDate;

public class Ordem {
    private String codigo;
    private String nomeCliente;
    private String modeloVeiculo;
    private String placaVeiculo;
    private LocalDate data;
    private String status;
    private double valorEstimado;
    private Servico servico;
    private Box box;

    

    public Ordem(String codigo, String nomeCliente, String modeloVeiculo, String placaVeiculo, Servico servico) {
        this.codigo = codigo;
        this.nomeCliente = nomeCliente;
        this.modeloVeiculo = modeloVeiculo;
        this.placaVeiculo = placaVeiculo;
        data = LocalDate.now();
        status = "Aberta";
        valorEstimado = 0.00;
        this.servico = servico;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getModeloVeiculo() {
        return modeloVeiculo;
    }
    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getValorEstimado() {
        return valorEstimado;
    }
    public void setValorEstimado(double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }
    public Servico getServico() {
        return servico;
    }
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Box getBox(){
        return box;
    }

    public void setBox(Box box){
        this.box = box;
    }

    @Override
    public String toString() {
        if(status.equals("Aberta")){
            return "Ordem: " + codigo + " | Cliente: " + nomeCliente + " | veículo: " + modeloVeiculo + " | Placa: " + placaVeiculo + " | Data: " + data + " | Status: " + status + " | Serviço: " + servico.getNome() + " | Valor estimado: R$" + valorEstimado + " | Box: Indefinido | Mecânico: Indefinido";
        }
        return "Ordem: " + codigo + " | Cliente: " + nomeCliente + " | veículo: " + modeloVeiculo + " | Placa: " + placaVeiculo + " | Data: " + data + " | Status: " + status + " | Serviço: " + servico.getNome() + " | Valor estimado: R$" + valorEstimado + " | Box: " + box + " | Mecânico: " + box.getMecanico().getNome();
    }

    public void finalizarOrdem(){
        if((!this.status.equals("Finalizada"))){
            this.status = "Finalizada";
            box.removerOrdem(this);
        }
    }

    
}
