package AV;
import java.util.Vector;

public class Clause {
    Vector ruleRefs ;
    RuleVariable lhs ;//left  hand side
    String rhs ;//right // //
    RuleVariable rhs1;//when the right hand side is a variable
    Condition  cond ;
    Boolean consequent ;  // true or false
    Boolean truth ;   // states = null(unknown), true or false
    Clause(RuleVariable Lhs, Condition Cond, String Rhs)
    {
     lhs = Lhs ; cond = Cond ; rhs = Rhs ;
     lhs.addClauseRef(this) ;
     ruleRefs = new Vector() ;
     truth = null ;
     consequent = new Boolean(false) ;
    }
    
    Clause(RuleVariable Lhs, Condition Cond, RuleVariable Rhs)
    {
     lhs = Lhs ; cond = Cond ; rhs1 = Rhs ;
     lhs.addClauseRef(this) ;
     ruleRefs = new Vector() ;
     truth = null ;
     consequent = new Boolean(false) ;
    }
    
    void addRuleRef(Rule ref) { ruleRefs.addElement(ref) ; }

    Boolean check() {
        if (consequent.booleanValue() == true) return null ;
        if (lhs.value == null) {
            return truth = null ;  // var value is undefined
        } 
        else {
        	/*if(rhs1.value != null){
        		switch(cond.index) {
 		       case 1: truth = new Boolean(lhs.value.equals(rhs1.value)) ;
 		         break ;
 		       case 2: truth = new Boolean(lhs.value.compareTo(rhs1.value) > 0) ;
 		         break ;
 		       case 3: truth = new Boolean(lhs.value.compareTo(rhs1.value) < 0) ;
 		         break ;
 		       case 4: truth = new Boolean(lhs.value.compareTo(rhs1.value) != 0) ;
 		         break ;
        		}
        		
        	}
        	else{*/

		        switch(cond.index) {
		       case 1: truth = new Boolean(lhs.value.equals(rhs)) ;
		         break ;
		       case 2: truth = new Boolean(lhs.value.compareTo(rhs) > 0) ;
		         break ;
		       case 3: truth = new Boolean(lhs.value.compareTo(rhs) < 0) ;
		         break ;
		       case 4: truth = new Boolean(lhs.value.compareTo(rhs) != 0) ;
		         break ;
        	}
	       //}
	
	       return truth ;
        }
    }

    void isConsequent() { consequent = new Boolean(true); }

    Rule getRule() { if (consequent.booleanValue() == true)
        return (Rule)ruleRefs.firstElement() ;
        else return null ;}
};
