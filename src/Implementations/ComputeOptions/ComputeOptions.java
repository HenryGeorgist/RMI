/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementations.ComputeOptions;

import Plugin.IComputeOptions;

/**
 *
 * @author Q0HECWPL
 */
public class ComputeOptions<TIn> implements IComputeOptions {
    private TIn _payload;
    private int _iteration;
    private int _seed;
    private static final long serialVersionUID = 1L;
    public ComputeOptions(){};
    public ComputeOptions(TIn payload, int iteration, int seed){
        _payload = payload;
        _iteration = iteration;
        _seed = seed;
    }
    @Override
    public int iteration() {
        return _iteration;
    }
    @Override
    public int seed() {
        return _seed;
    }
    @Override
    public TIn payload() {
        return _payload;
    }
    
}
