/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InMemory;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
/**
 *
 * @author Q0HECWPL
 */
public class Client {

    private Client() {}

    public static void main(String[] args) {

        if(args!=null || args.length!=0){
            int numIters = Integer.parseInt(args[0]);
            try {
                Registry registry = LocateRegistry.getRegistry();
                String[] names = registry.list();
                ArrayList<IRemoteCompute> plugins = new ArrayList<>();
                for(String name : names){
                    System.out.println("Found: " + name);
                    Remote stub = registry.lookup(name);
                    if(stub instanceof InMemory.IRemoteCompute){
                        plugins.add((IRemoteCompute)stub);
                    }                    
                }
                double[] outputs = new double[numIters];
                double val = .5;
                outputs[0] = val;
                System.out.println(0 + "th Value: " + val);
                if(plugins.size()>1){
                    
                    for(int i =1;i<numIters;i++){
                        for(IRemoteCompute p : plugins){
                            val = p.compute(val);
                            System.out.println(p.name() + " result: " + val);
                        }
                        outputs[i] = val;
                        System.out.println(i + "th Value: " + val);
                    }
                    System.out.println("Final Value: " + outputs[numIters-1]);
                }else{
                    System.err.println("Client exception: only one plugin found");
                }
            } catch (Exception e) {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }            
        }

    }
}
