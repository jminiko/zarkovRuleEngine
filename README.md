# zarkovRuleEngine (don't ask me why)
- a simple forward chain rule engine derived from work on Dolphin Smalltalk (hey kiddies do not what smalltalk is? :) )
- 2 classes for back (TerminalRule->Rule)
- 2 classes for front (TerminalException,RuleEngine)
- 2 classes for testing (SimpleRuleEngine , ZooRuleEngine)
- to run you should register all rules in a subclass of RuleEngine (much to do the automatically way)
instead of meta programming I use Expando from groovy (u can attach any property at runtime)


credits to Burning River
