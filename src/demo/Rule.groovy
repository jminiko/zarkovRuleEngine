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

class Rule{
    String name
    long firedCount 
    Closure condition
    Closure action
    boolean disabled 
    boolean isTerminal = false
    public void initialize(){
        firedCount = 0
        condition = { aRuleEngine -> false}
        action = {aRuleEngine -> null}
        disabled = false
    }

    static public void main(String[] args){
        def term1 = new TerminalRule()
        println term1.isTerminal
        def term2 = new Rule()
        println term2.isTerminal
        def m = new MapEntry(1,'23')
        ([:]<<m).each{println "class  "+it.getClass()}
    }
}