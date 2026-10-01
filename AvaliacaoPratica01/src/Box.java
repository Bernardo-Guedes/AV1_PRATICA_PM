import java.util.ArrayList;

public class Box {
    private int num;
    private String tipoServico;
    private int capacidadeMax;
    private String localizacao;
    private Mecanico mecanico;
    private ArrayList<Ordem> ordens;

    

    public Box(int num, String tipoServico, int capacidadeMax, String localizacao) {
        this.num = num;
        this.tipoServico = tipoServico;
        this.capacidadeMax = capacidadeMax;
        this.localizacao = localizacao;
        mecanico = null;
        ordens = new ArrayList<>();
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getTipoServico() {
        return tipoServico;
    }
    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }
    public int getCapacidadeMax() {
        return capacidadeMax;
    }
    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public Mecanico getMecanico() {
        return mecanico;
    }
    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }
    public ArrayList<Ordem> getOrdens() {
        return ordens;
    }
    public void setOrdens(ArrayList<Ordem> ordens) {
        this.ordens = ordens;
    }

    public void atribuirOrdem(Ordem ordem){
        if (ordem.getServico().getCategoria().equalsIgnoreCase(tipoServico)){
            ordens.add(ordem);
            ordem.setStatus("Em execucao");
            System.out.println("Ordem atribuida ao box");
        } else {
            System.out.println("Tipo de serviço incompatível com o box.");
        }
    }

    public void removerOrdem(Ordem ordem){
        for(Ordem o : ordens){
            if(o.getCodigo().equals(ordem.getCodigo())){
                ordens.remove(ordem);
            }
        }
    }

    public int exibirOrdens(){
        int quantidade = 0;
        for (Ordem o : ordens){
            quantidade += 1;
            System.out.println(o);
        }
        return quantidade;
    }

    public int qtdOrdensFinalizadas(){
        int quantidade = 0;
        for (Ordem o : ordens){
            if(o.getStatus().equals("Finalizada")){
                quantidade+=1;
            }
        }
        return quantidade;
    }

    @Override
    public String toString(){
        return "Box: " + num + " | Localização: " + localizacao + " | Tipo de serviço: " + tipoServico;
    }
}
