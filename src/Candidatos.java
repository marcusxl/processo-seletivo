import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.ArrayList;

public class Candidatos {
    public static void main(String[] args) throws Exception {
        
        ArrayList<String> candidatosEscolhidos = escrevaCandidatos();

            for(String candidato : candidatosEscolhidos)
                selecaoCandidato(candidato);

    }

    static void selecaoCandidato(String candidato){
        boolean candidatoAtenddeu = false;
        boolean continuarTentando = true;
        int tentativasRealizadas = 1;

        do{

        candidatoAtenddeu = ligarCandidato();
        continuarTentando = !candidatoAtenddeu;
        if(continuarTentando)
            tentativasRealizadas++;
        else
            System.out.println("CONTATO REALIZADO COM SUCESSO!!");

        }while(continuarTentando && tentativasRealizadas < 3);

        if(candidatoAtenddeu)
            System.out.println("Conseguimos contato com " + candidato + ", tentativas realizadas " + tentativasRealizadas);
        else
            System.out.println("PENA!! Nao conseguimos contato com " + candidato + ", depois de " + tentativasRealizadas);

    }

    static ArrayList<String> escrevaCandidatos() throws NenhumCandidatoException{
        
        ArrayList<String> candidatos = new ArrayList<String>();
        candidatos.add("Joao");
        candidatos.add("Maicon");
        candidatos.add("Lucas");
        candidatos.add("Bianca");
        candidatos.add("Augusto");

        int canditatoAtual = 0;
        int candidatoSelecionado = 0;
        double salarioBase = 2000.0;
         
        while(candidatoSelecionado < 3 && canditatoAtual < candidatos.size()){
            
            String candidato = candidatos.get(canditatoAtual);
            double valorSolicitado = salarioPretendido();
            
            if(salarioBase < valorSolicitado){
                candidatos.remove(candidato);
                }
            else if(salarioBase >= valorSolicitado){
                System.out.println("LEGAL!!! O Candidato " + candidato + " passou");
            }
            canditatoAtual++;
        }
        return candidatos;

    }

    static boolean ligarCandidato(){
        return new Random().nextInt(3) ==  1;
    }

    static double salarioPretendido(){
        return ThreadLocalRandom.current().nextDouble(1750.0, 2300.0);
    }

}
