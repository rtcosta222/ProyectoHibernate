/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.HibernateUtil;
import models.Resumen;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lscar
 */
public class RepositoryConsultasEspeciales {
    Session session;
    Transaction transaction;
    
    public RepositoryConsultasEspeciales(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    private void initTransaccion(){
        if(this.session.isOpen() == false){
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();        
    }
    
    public Resumen getResumen(int deptno){
        this.initTransaccion();
        String hql = "select count(emp.empNo), max(emp.salario), min(emp.salario) from Emp as emp "
                + "where emp.deptNo=?";
        Query query = this.session.createQuery(hql);
        query.setParameter(0, deptno);
        List lista = query.list();
        this.session.close();
        
        Resumen resumen = null;
        for (Object obj : lista) {
            //DENTRO DE LA LISTA, EXISTE UN ARRAY DE Object[]
            Object[] array = (Object[]) obj;
            Long personas = (Long) array[0];
            if (array[1] == null){
                //NO HAY DATOS
                return null;
            }
            int maximo = (int) array[1];
            int minimo = (int) array[2];
            resumen = new Resumen();
            resumen.setNumpersonas(personas.intValue());
            resumen.setMaxsalario(maximo);
            resumen.setMinsalario(minimo);
        }
        return resumen;
    }
}
