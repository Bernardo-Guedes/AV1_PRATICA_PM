import java.util.ArrayList;

public class Utilitario {
    public ArrayList<Box> criarBoxes(){
        ArrayList<Box> boxes = new ArrayList<>();
        Box s1 = new Box(1, "Reparo", 2, "BH");
        Box s2 = new Box(2, "Troca", 3, "Betim");
        Box s3 = new Box(3, "Instalacao", 4, "Contagem");
        boxes.add(s1);
        boxes.add(s2);
        boxes.add(s3);
        return boxes;
    }

    public ArrayList<Mecanico> criarMecanicos(){
        ArrayList<Mecanico> mecanicos = new ArrayList<>();
        Mecanico m1 = new Mecanico("Joao", "12345678900", "Embreagem", "31912345600");
        Mecanico m2 = new Mecanico("Pedro", "12345678901", "Motor", "31912345601");
        Mecanico m3 = new Mecanico("Carlos", "12345678902", "Suspensao", "31912345602");
        mecanicos.add(m1);
        mecanicos.add(m2);
        mecanicos.add(m3);
        return mecanicos;
    }

    public ArrayList<Servico> criarServicos(){
        ArrayList<Servico> servicos = new ArrayList<>();
        Servico m1 = new Servico("Consertar motor", 2, 100.00, "Reparo");
        Servico m2 = new Servico("Trocar pneu", 4, 350.00, "Troca");
        Servico m3 = new Servico("Instalar suspensao", 3, 200.00, "Instalacao");
        servicos.add(m1);
        servicos.add(m2);
        servicos.add(m3);
        return servicos;
    }

    public Ordem existeOrdem(ArrayList<Ordem> ordens, String codigo){
        for (Ordem o : ordens){
            if(o.getCodigo().equals(codigo)){
                return o;
            }

        }
        return null;
    }

    public Servico existeServico(ArrayList<Servico> servicos, String nome){
        for (Servico s : servicos){
            if(s.getNome().equalsIgnoreCase(nome)){
                return s;
            }

        }
        return null;
    }

    public Mecanico existeMecanico(ArrayList<Mecanico> mecanicos, String nome){
        for (Mecanico m : mecanicos){
            if(m.getNome().equalsIgnoreCase(nome)){
                return m;
            }
        }
        return null;
    }

    public Box existeBox(ArrayList<Box> boxes, int numero){
        for (Box b : boxes){
            if(b.getNum() == numero){
                return b;
            }
        }
        return null;
    }
}
