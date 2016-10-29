/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.iod.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author marciomendes
 */	
public class Emissor {//1 passo
JPAMessenger jpa;
 
 JPAMessenger dado;

 public Emissor() throws NotBoundException, MalformedURLException, RemoteException {
        jpa = (JPAMessenger)Naming.lookup("rmi://127.1.1.1/jpa");//2 passo
    }

  
    
    public void setMe(JPAMessenger dado){
      this.dado = dado;
    }




    
    
}
