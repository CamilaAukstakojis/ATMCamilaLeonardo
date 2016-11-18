package br.umc.iod.rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author marcio
 */
public class ChatServer {
 public static void main(String args[]) throws RemoteException, MalformedURLException{  
 
     LocateRegistry.createRegistry(1099);
     JPAMessengerImpl jpa = new JPAMessengerImpl();
     Naming.rebind("jpa", jpa);
     System.err.println("Servidor RUNNING "); 
 }   
}
