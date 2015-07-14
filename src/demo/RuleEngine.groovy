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
class RuleEngine implements GroovyInterceptable{
       
    Expando  metaInfos = new Expando()
    Expando results    = new Expando()
    protected boolean isSpecialSelector(String prop){
        return (prop.startsWith("has")||
            prop.startsWith("is"))
    }
   
  
    long iterationLimit =  2
    public List activeRules
    
    public List firedRules

    public RuleEngine initialize(){
        
       
        //addBasicDefaultSlotValues()
        activeRules = []
	firedRules = []
	iterationLimit= 30
        return this
    }
    public void mainLoop(){
        def ruleSet , selectedRule
        for(long i = 1;i<iterationLimit;i++){
            try{
                ruleSet = matchRules()
                
                selectedRule = selectRuleToFire(ruleSet)
                if(selectedRule!=null){
                    fireRule(selectedRule)
                }else{
                    throw new TerminalException("TE, end of agenda")
                }
            }catch(TerminalException te){
                println this.results
                
                return
            }
        }
    }
    public fireRule(Rule aRule){
        
        aRule.action.call(this.results)
        aRule.firedCount++
        activeRules.remove(aRule)
        firedRules.add(aRule)
        if(aRule.isTerminal)
            throw new TerminalException("End of agenda by last rule")
    }
    protected Rule selectRuleToFire(aSet){
        if(aSet.size()==0)
            return null
        def selectedRule = aSet.sort{it.firedCount}
        
        if(selectedRule.size()!=0){
            
            return selectedRule[0]
        }else
            return null
    }
    
    protected matchRules(){
        def aSet = []
	activeRules.each{aRule ->   
			def  selected 
			if(!aRule.disabled){
				selected = aRule.condition.call(this.metaInfos)
                                if(selected){
                                   aSet<<aRule
                                }
                        }
        }
        return aSet                           
    }

    public addRule(aRule){
        activeRules.add(aRule)
    }
}
