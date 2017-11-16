/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementations.ComputeOutput;

import Plugin.IComputeOutput;

/**
 *
 * @author Q0HECWPL
 */
public class ComputeOutput<TOut> implements IComputeOutput{
    private TOut _payload;
    private boolean _success;
    private static final long serialVersionUID = 1L;
    public ComputeOutput(){
        _success = false;
    }
    public ComputeOutput(TOut result, boolean success){
        _success = success;
        _payload = result;
    }
    @Override
    public Boolean wasSuccessful() {
        return _success;
    }
    @Override
    public TOut payload() {
        return _payload;
    }
    
}
