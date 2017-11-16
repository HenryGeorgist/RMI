/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plugin;

import java.io.Serializable;

/**
 *
 * @author Q0HECWPL
 */
public interface IComputeOptions<TIn> extends Serializable {
    public int iteration();
    public int seed();
    public TIn payload();
}
