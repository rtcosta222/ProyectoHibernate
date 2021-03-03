/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.Doctor;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lscar
 */
public class RepositoryDoctores {
    Session session;
    Transaction transaction;
    
    public RepositoryDoctores() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private void iniciarTransaccion() {
        if(this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();        
        }
        this.transaction = this.session.beginTransaction();
    }
    
    public List<Doctor> getTablaDoctor() {
        this.iniciarTransaccion();
        String z_hql = "from Doctor as doctor";
        Query query = this.session.createQuery(z_hql);    
        if(query.list().isEmpty()) {
            return null;
        } else {
            return query.list();
        }
    }

    public List<Doctor> getDoctores(int idHosp) {
        this.iniciarTransaccion();
        String z_hql = "from Doctor as doctor where hospitalCod=" + idHosp;
        Query query = this.session.createQuery(z_hql);    
        if(query.list().isEmpty()) {
            return null;
        } else {
            return query.list();
        }
    }
    
    public void insertarDoctor(int hospcod, int docno, String ape, String espe, int sal) {
        this.iniciarTransaccion();
        Doctor doctor = new Doctor(hospcod, docno, ape, espe, sal);
        this.session.save(doctor);
        this.transaction.commit();
    }
    
    public void modificarDoctor(int hospcod, int docno, String ape, String espe, int sal) {
        this.iniciarTransaccion();
        Doctor doctor = (Doctor) this.session.load(Doctor.class, docno);
        doctor.setHospitalCod(hospcod);
        doctor.setApellido(ape);
        doctor.setEspecialidad(espe);
        doctor.setSalario(sal);
        this.session.update(doctor);
        this.transaction.commit();
    }
    
    public void eliminarDoctor(int docno) {
        System.out.println(docno);
        this.iniciarTransaccion();
        Doctor doctor = (Doctor) this.session.load(Doctor.class, docno);
        this.session.delete(doctor);
        this.transaction.commit();
    }
}
