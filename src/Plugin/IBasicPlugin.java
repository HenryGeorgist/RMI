/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plugin;

/**
 *
 * @author Q0HECWPL
 */
public interface IBasicPlugin<TIn> extends IPlugin{
    public boolean compute(IComputeOptions<TIn> options);
}
