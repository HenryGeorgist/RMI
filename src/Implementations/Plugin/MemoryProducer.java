/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementations.Plugin;

import Implementations.ComputeOutput.ComputeOutput;
import Plugin.IComputeOptions;
import Plugin.IComputeOutput;
import Plugin.IMemoryPlugin;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 *
 * @author Q0HECWPL
 */
public class MemoryProducer implements IMemoryPlugin<String,Double>{
    private String _name;
    private Random _r;
    public static void main(String args[]){
        if(args !=null || args.length!=1){
            try {
                MemoryProducer obj = new MemoryProducer((String)args[0]);
                IMemoryPlugin stub = (IMemoryPlugin) UnicastRemoteObject.exportObject(obj, 0);
                
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
    public MemoryProducer(String name){
        _name = name;
    }
    @Override
    public IComputeOutput<Double> compute(IComputeOptions<String> options) {
        _r = new java.util.Random(options.seed());
        ComputeOutput out;
        double d = _r.nextDouble();
        System.err.println("Server computing");
        if(d>.5){
            System.err.println("Server computing option 1");
            out = new ComputeOutput(.5,true);
        }else if(d>.499){
            System.err.println("Server computing option 2");
            out = new ComputeOutput(0.0d,false);
        }else{
            System.err.println("Server computing option 3");
            out = new ComputeOutput(2.0d,true);
        }
        return out;
    }

    @Override
    public void shutDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String name() {
        return _name;
    }
    
}
