/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo

/**
 *
 * @author jminiko
 */
class Demo1 {
	public static void main(String[] args){
            def engine = new ZooRuleEngine()
            engine.initialize()
            engine.mainLoop()
        }
}

