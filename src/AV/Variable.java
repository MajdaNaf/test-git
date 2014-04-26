package AV;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

public abstract class Variable {


String name ;
String value ;
int column ;

public Variable() {} ;
public Variable(String Name) {name = Name; value = null; }
void   setValue(String val) { value = val ; }
String getValue() { return value; }

// used by categorical only
Vector labels ;
void setLabels(String Labels) {
    labels = new Vector() ;
    StringTokenizer tok = new StringTokenizer(Labels," ") ;
    while (tok.hasMoreTokens()) {
         labels.addElement(new String(tok.nextToken())) ;
    }
}
// return the label with the specified index
String getLabel(int index) {
    return (String)labels.elementAt(index);
}

// return a string containing all labels
String getLabels() {
    String labelList = new String();
    Enumeration enume = labels.elements() ;
    while(enume.hasMoreElements()) {
         labelList += enume.nextElement() + " " ;
    }
    return labelList ;
}

// given a label, return its index
int getIndex(String label) {
    int i = 0, index = 0  ;
    Enumeration enume = labels.elements() ;
    while(enume.hasMoreElements()) {
        if (label.equals(enume.nextElement()))
        { index = i ; break ; }
        i++;
     }
     return i;
}

}