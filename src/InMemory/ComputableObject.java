/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InMemory;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Q0HECWPL
 */
public class ComputableObject implements IRemoteCompute {
    private String _name;
    private double _multiplier;
    
    public static void main(String args[]){
        if(args !=null || args.length!=2){
            try {
                ComputableObject obj = new ComputableObject((String)args[0],Double.parseDouble(args[1]));
                IRemoteCompute stub = (IRemoteCompute) UnicastRemoteObject.exportObject(obj, 0);

                // Bind the remote object's stub in the registry
                Registry registry = LocateRegistry.getRegistry();
                registry.bind(stub.name(), stub);

            System.err.println(stub.name() + " ready");
            } catch (Exception e) {
                System.err.println("Server exception: " + e.toString());
                e.printStackTrace();
            }
        }else{
            System.err.println("Server exception: arguments were null or were not 2 in length");
        }

    }
    public ComputableObject(String name, double multiplier){_name = name; _multiplier = multiplier; }

    @Override
    public String name() throws RemoteException {
        return _name;
    }

    @Override
    public double compute(double input) throws RemoteException {
        return _multiplier*input;
    }
}
