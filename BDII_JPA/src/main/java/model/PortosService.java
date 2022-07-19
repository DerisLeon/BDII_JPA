package model;

import util.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class PortosService {
    
        public List<Portos> listarPortosPara(String municipio){
        List<Portos> result = null;
        EntityManager em = JPAUtil.createEntityManager();   
        em.getTransaction().begin();       

        Query query = em.createQuery("select mb from Portos mb where mb.nome_uf = :nome_uf");//, Alert.class);
        query.setParameter("nome_uf", municipio);
        result = query.getResultList();
        em.getTransaction().commit();
        em.close();
        
        return result;
        
        }
        
        public List<Portos> PortosMunicipios(String municipio){
        List<Portos> result = null;
        EntityManager em = JPAUtil.createEntityManager();   
        em.getTransaction().begin();       

        Query query = em.createQuery("select nm from Portos nm where nm.municipio = :municipio");//, Alert.class);
        query.setParameter("municipio", municipio);
        result = query.getResultList();
        em.getTransaction().commit();
        em.close();
        
        return result;
        
        }
        
        public List<Portos> PortosNordeste(String nome_regia){
        List<Portos> result = null;
        EntityManager em = JPAUtil.createEntityManager();   
        em.getTransaction().begin();       

        Query query = em.createQuery("select mb from Portos ma, Portos mb where contains(ma.geometria, mb.geometria) = true and ma.nome_regia = :nome_regia");
        query.setParameter("nome_regia", nome_regia);
        result = query.getResultList();
        em.getTransaction().commit();
        em.close();      
        
        return result;
    }
        
        public List<Portos> municipiosPortos(){
        List<Portos> result = null;
        EntityManager em = JPAUtil.createEntityManager();   
        em.getTransaction().begin();       

        Query query = em.createQuery("select a from Portos a");
        result = query.getResultList();
        em.getTransaction().commit();
        em.close();      
        
        return result;
       }
}
