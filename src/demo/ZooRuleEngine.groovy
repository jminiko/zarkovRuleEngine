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
class ZooRuleEngine extends RuleEngine{
   
    
    public ZooRuleEngine() {
        super.initialize()        
    }
    public ZooRuleEngine initialize()
    {
        super.addRule(albatrossRule())
        super.addRule(bird1())
        super.addRule(bird2())
        
        super.metaInfos.isAGoodFlyer = true
        super.metaInfos.hasFeathers = true
        
        return this
    }
    public Rule albatrossRule(){
        def r = new TerminalRule()
        r.firedCount= 0
        r.name      = "albatross test"
        r.condition = {it.isBird &&  it.isAGoodFlyer}
        r.action    = {it.albatross = true}
        return r
    }
    
    public Rule bird1(){
        def r = new TerminalRule()
        r.firedCount= 0
        r.name      = "bird test 1"
        r.condition = {it.hasFeathers == true}
        r.action    = {it.isBird = true}
        return r
    }
    public Rule bird2(){
        def r = new TerminalRule()
        r.firedCount= 0
        r.name      = "bird test 2"
        r.condition = {it.flies == true && it.laysEggs}
        r.action    = {it.isBird = true}
        return r
    }
}

