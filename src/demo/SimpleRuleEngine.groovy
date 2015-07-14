/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo
import groovy.util.*
/**
 *
 * @author jminiko
 */
class SimpleRuleEngine extends RuleEngine{
   
    
    public SimpleRuleEngine() {
        super.initialize()        
    }
    public RuleEngine initialize()
    {
        super.addRule(rule1())
        super.metaInfos.hasHair = true
        return this
    }
    public Rule rule1(){
        def r = new TerminalRule()
        r.firedCount= 0
        r.name      = "simple just for fun"
        r.condition = {it.hasHair == true}
        r.action    = {it.isJim = true}
        return r
    }
}

