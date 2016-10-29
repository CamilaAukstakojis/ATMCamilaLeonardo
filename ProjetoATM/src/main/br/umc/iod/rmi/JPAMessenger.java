package br.umc.iod.rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author marcio
 */
public interface JPAMessenger extends Remote {
    public void abrirConexao()throws RemoteException;
    public void fecharConexao() throws RemoteException;
	public void remover(Object obj) throws RemoteException;
    public void salvar(Object obj) throws RemoteException;
    public void consultar(String campo) throws RemoteException;
    public void atualizar(Object obj) throws RemoteException;
    
}
