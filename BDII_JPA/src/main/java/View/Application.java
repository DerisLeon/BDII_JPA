package View;

import util.JPAUtil;
import java.util.List;

import model.Estados;
import model.EstadosService;

import model.Fronteiras;
import model.FronteirasService;

import model.Portos;
import model.PortosService;

import model.Ferrovia;
import model.FerroviaService;

import model.MunicipioService;
import model.Municipio;


public class Application {
    public static void main(String[] args) {
       
       //1
       EstadosService estadosService = new EstadosService();
       List<Estados> estados = estadosService.RegiaoNordeste("Nordeste");
       System.out.println("Estados do Nordeste: ");
       for (Estados e: estados){
            System.out.println(e);
       }
       
        //2
       double distancia = estadosService.distanciaEntreEstados("São Paulo", "Ceará");
       System.out.printf("Distância entre os estados da São Paulo e Ceará: %.2f km \n", distancia / 1000);
       
       //3
       List<Estados> estadoss = estadosService.EstadosRegiao("Sul", "Santa Catarina");
       System.out.println("Estados que sobrepõem o sul do Brasil: ");
       for (Estados e: estadoss){
            System.out.println(e);
       }
      
       //4
       MunicipioService municipioService = new MunicipioService();
       List<Municipio> municipios = municipioService.listarMunicipiosVizinhos("Guarabira");
       System.out.println("Municipios vizinhos de Guarabira: ");
       for (Municipio m: municipios){
            System.out.println(m);
       }
       
       //5
       PortosService portosService = new PortosService();
       List<Portos> portos = portosService.listarPortosPara("Paraíba");
       System.out.println("Portos no Estado do Paraíba: ");
       for (Portos p: portos){
            System.out.println(p);
       } 
       
       List<Portos> portosss = portosService.PortosMunicipios("Pelotas");
       System.out.println("Estado onde se encontra o porto de Pelotas: ");
       for (Portos p: portosss){
            System.out.println(p);
       }
       
       //6
       List<Portos> portoss = portosService.PortosNordeste("Nordeste");
       System.out.println("Portos na região Nordeste: ");
       for (Portos p: portoss){
            System.out.println(p);
       }
       
       //7
       List<Portos> porto = portosService.municipiosPortos();
       System.out.println("Todos os Portos do Brasil: ");
       for (Portos p: porto){
            System.out.println(p);
       }
       
       //8
       FronteirasService fronteirasService = new FronteirasService();
       List<Fronteiras> fronteiras = fronteirasService.FronteirasList("SRF - Secretaria da Receita Federal");
       System.out.println("Fronteiras administradas por SRF - Secretaria da Receita Federal: ");
       for (Fronteiras p: fronteiras){
            System.out.println(p);
       }
       
       //9
       double fronteira = fronteirasService.distanciaFronteiras("Chuí", "Jaguarão");
       System.out.printf("Distância entre as fronteiras de Chuí e Jaguarão: %.2f km \n", fronteira / 1000);
      
       //10
       FerroviaService ferroviaService = new FerroviaService();
       List<Ferrovia> ferrovias = ferroviaService.listarFerrovias("Santos");
       System.out.println("Ferrovias em Santos: ");
       for (Ferrovia f: ferrovias){
           System.out.println(f);
       }  
       JPAUtil.close();
    }
}
