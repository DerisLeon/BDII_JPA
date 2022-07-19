package model;


import util.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;


public class EstadosService {
     
    public List<Estados> EstadosRegiao(String nm_regiao, String nm_uf){
        List<Estados> result = null;
        EntityManager em = JPAUtil.createEntityManager();   
        em.getTransaction().begin();  
        
        Query query = em.createQuery("select e from Estados e, Estados r where overlaps(r.geometria, e.geometria) = true and r.nm_regiao = :nm_regiao and e.nm_uf = :nm_uf");//, Alert.class);
        query.setParameter("nm_uf", nm_uf);
        query.setParameter("nm_regiao", nm_regiao);
        result = query.getResultList();
        em.getTransaction().commit();
        em.close();
        
        return result;
    }
    
    
    public List<Estados> RegiaoNordeste(String nm_regiao){
        List<Estados> result = null;
        EntityManager em = JPAUtil.createEntityManager();   
        em.getTransaction().begin();       

        Query query = em.createQuery("select m from Estados m where m.nm_regiao = :nm_regiao");
        query.setParameter("nm_regiao", nm_regiao);
        result = query.getResultList();
        em.getTransaction().commit();
        em.close();
        
        return result;
    }
    
        public double distanciaEntreEstados(String estadoA, String estadoB){
        double result = 0;
        EntityManager em = JPAUtil.createEntityManager();   
        em.getTransaction().begin();       

        Query query = em.createQuery("select distance(geography(ma.geometria), geography(mb.geometria)) from Estados ma, Estados mb where ma.nm_uf = :estadoA  and   mb.nm_uf = :estadoB");
        query.setParameter("estadoA", estadoA);
        query.setParameter("estadoB", estadoB);

        result = (double)query.getSingleResult();
        
        em.getTransaction().commit();
        em.close();
        
        return result;
    }  
    
    private Geometry wktToGeometry(String wktPoint) {
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        try {
            geom = fromText.read(wktPoint);
        } catch (ParseException e) {
            throw new RuntimeException("Not a WKT string:" + wktPoint);
        }
        return geom;
    }
}
