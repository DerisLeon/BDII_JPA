package model;


import util.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class FronteirasService {
    
        public List<Fronteiras> FronteirasList(String administra){
        List<Fronteiras> result = null;
        EntityManager em = JPAUtil.createEntityManager();   
        em.getTransaction().begin();       

        Query query = em.createQuery("select f from Fronteiras f where f.administra = :administra");
        query.setParameter("administra", administra);
        result = query.getResultList();
        em.getTransaction().commit();
        em.close();
        
        return result;
        
        }
        
        public double distanciaFronteiras(String fronteiraA, String fronteiraB){
        double result = 0;
        EntityManager em = JPAUtil.createEntityManager();   
        em.getTransaction().begin();       

        Query query = em.createQuery("select distance(geography(ma.geometria), geography(mb.geometria)) from Fronteiras ma, Fronteiras mb where ma.municipio = :fronteiraA  and   mb.municipio = :fronteiraB");
        query.setParameter("fronteiraA", fronteiraA);
        query.setParameter("fronteiraB", fronteiraB);

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
