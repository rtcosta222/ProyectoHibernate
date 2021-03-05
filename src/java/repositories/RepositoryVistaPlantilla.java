/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import models.HibernateUtil;
import models.Plantilla;
import models.Vistaplantilla;
import models.VistaplantillaId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lscar
 */
public class RepositoryVistaPlantilla {
    Session session;
    Transaction transaction;
    
    public RepositoryVistaPlantilla() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private void initTransaccion() {
        if (this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }
    
    public List<VistaplantillaId> getVistaPlantillaHospitales() {
        this.initTransaccion();
        String z_hql = "from Vistaplantilla as vista";
        Query query = this.session.createQuery(z_hql);
        List<Vistaplantilla> listaplantilla = query.list();
        ArrayList<VistaplantillaId> plantilla = new ArrayList<>();
        for(Vistaplantilla v: listaplantilla) {
            VistaplantillaId plan = v.getId();
            plantilla.add(plan);
        }
        return plantilla;
    }
    
    public List<VistaplantillaId> getVistaPlantillaHospital(String hnom) {
        this.initTransaccion();
        String z_hql = "from Vistaplantilla as vista where lower(vista.id.nombre)='" + hnom.toLowerCase() + "'";
        Query query = this.session.createQuery(z_hql);
        List<Vistaplantilla> listaplantilla = query.list();
        ArrayList<VistaplantillaId> plantilla = new ArrayList<>();
        for(Vistaplantilla v: listaplantilla) {
            VistaplantillaId plan = v.getId();
            plantilla.add(plan);
        }
        return plantilla;
    }
}






























