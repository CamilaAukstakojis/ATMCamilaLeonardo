package br.umc.iod.rmi;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * rmic -classpath `pwd` br.umc.iod.ChatMessengerImpl
*/


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Message;

import br.umc.iod.jpa.MinhaEntidade;


/**
 *
 * @author marcio
 */
public class JPAMessengerImpl implements JPAMessenger, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String texto;
	private int numero;
	public EntityManagerFactory emf;
	public EntityManager em; 
	
	public JPAMessengerImpl() throws RemoteException {
		
		UnicastRemoteObject.exportObject(this, 1099);
	} 
	
	
    public void abrirConexao(){
    	emf = Persistence.createEntityManagerFactory("persistence");
    	em = emf.createEntityManager();
    } 
    
    public void fecharConexao(){
		em.close();
		emf.close();
    }
    
    public void remover(Object obj) throws RemoteException {
    	// TODO Auto-generated method stub
    	if (emf == null || em == null || !emf.isOpen()|| !em.isOpen())
    		this.abrirConexao();
    	em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
		//this.fecharConexao();
    	
	}   
    
    public void consultar(String campo) throws RemoteException {
    	// TODO Auto-generated method stub
    	if (emf == null || em == null || !emf.isOpen()|| !em.isOpen())
    		this.abrirConexao();
    	em.getTransaction().begin();
    	List<JPAMessengerImpl> lista = em.createQuery("FROM JPAMessenger",JPAMessengerImpl.class).getResultList();
		for (JPAMessengerImpl selected : lista) {
			System.out.println("Objeto no banco: " + selected.numero+ ", " + selected.texto);
		}
		em.getTransaction().commit();
	//	this.fecharConexao();
    }

    public void salvar(Object obj) throws RemoteException {
		// TODO Auto-generated method stub
    	if (emf == null || em == null || !emf.isOpen()|| !em.isOpen())
    		this.abrirConexao();
    	em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	//	this.fecharConexao();
		
	}

	public void atualizar(Object obj) throws RemoteException {
		if (emf == null || em == null || !emf.isOpen()|| !em.isOpen())
			this.abrirConexao();
    	em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		//this.fecharConexao();
	}




	
 

    
}
