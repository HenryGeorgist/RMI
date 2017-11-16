/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementations.Client;

import InMemory.IRemoteCompute;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Q0HECWPL
 */
public class Manager {
    public static void main(String[] args) {

        if(args!=null || args.length!=0){
            int numIters = Integer.parseInt(args[0]);
            try {
                Registry registry = LocateRegistry.getRegistry();
                String[] names = registry.list();
                ArrayList<Plugin.IMemoryPlugin> plugins = new ArrayList<>();
                for(String name : names){
                    System.out.println("Found: " + name);
                    Remote stub = registry.lookup(name);
                    if(stub instanceof Plugin.IMemoryPlugin){
                            plugins.add((Plugin.IMemoryPlugin)stub);
                    }                    
                }
                Object[] outputs = new Object[numIters];
                Random r = new Random();
                if(plugins.size()>1){
                    System.out.println("Initalizing Compute");
                    for(int i =0;i<numIters;i++){
                        System.out.println("Iteration " + i);
                        Plugin.IComputeOptions opts = new Implementations.ComputeOptions.ComputeOptions("abcd",i,r.nextInt());
                        Plugin.IComputeOutput out = null;
                        for(Plugin.IMemoryPlugin p : plugins){
                            System.out.println("Computing " + p.name());
                            out = p.compute(opts);
                            opts = new Implementations.ComputeOptions.ComputeOptions(out.payload(),i,r.nextInt());
                            System.out.println("Compute Success: " + out.wasSuccessful());
                            if(!out.wasSuccessful()) return;
                            System.out.println(p.name() + " result: " + out.payload());
                        }
                        outputs[i] = out.payload();
                        System.out.println(i + "th Value: " + outputs[i]);
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
