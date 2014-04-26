package AV;
import java.util.Enumeration;
import java.util.Vector;

public class RuleVariable extends Variable {

public RuleVariable(String Name) {
        super(Name);
        clauseRefs = new Vector();
        }

void setValue(String val) { value = val;
                            updateClauses(); }

// prompt a user to provide a value for a variable during inferencing
String askUser() {
  String answer = RuleApplet.waitForAnswer(name, getLabels()) ;
  RuleBase.appendText("\n  !!! Recherche " + name + ". L'utilisateur a entré: " + answer) ;
  setValue(answer) ; // need to set value from textField here
  return value ;
}

Vector clauseRefs ;   // clauses which refer to this var
void addClauseRef(Clause ref) { clauseRefs.addElement(ref) ; }

void updateClauses() {
   Enumeration enume = clauseRefs.elements() ;
   while(enume.hasMoreElements()) {
     ((Clause)enume.nextElement()).check() ; // retest the clause
   }
}
void setPromptText(String text) {
	promptText = text;
}
String promptText;
String promptString ;  // used to prompt user for value
String ruleName ;      // if value is inferred, null = user provided
void   setRuleName(String rname) { ruleName = rname; }

};
