/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InMemory;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Q0HECWPL
 */
public interface IRemoteCompute extends Remote {
    public String name() throws RemoteException;
    public double compute(double input) throws RemoteException;
}
