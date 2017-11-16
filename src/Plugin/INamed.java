/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plugin;
import java.rmi.RemoteException;
/**
 *
 * @author Q0HECWPL
 */
public interface INamed {
    public String name() throws RemoteException;
}
