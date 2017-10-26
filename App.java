/*<applet code="App" width =300 height=300>
</applet>*/
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class App extends Applet implements ActionListener
{
   Button b1;TextField t1;
   public void init()
  {
    b1 =new Button("Generate");
    t1=new TextField(10);
    add(b1);
   add(t1);
    b1.addActionListener(this);
    b1.addActionListener(this);

 }
 private static final int charactersSize = 100;
    private static char [] characters = new char [charactersSize];
    private static int charactersCount = 0;
   private int passwordSize=10;  
    char [] password = new char [passwordSize];

    
private static void  initCharacters() {
   int i = 0;
  for ( int j = 33; j < 123; ++i, ++j, ++charactersCount ) {
        characters[i] = (char) j;
      }
}
public char [] get() {
    
        initCharacters();
       Random rnd = new Random();
      for ( int i = 0; i < passwordSize; ++i ) {
        password[i] = characters[ rnd.nextInt(charactersCount) ];
      }
     return password;
    }
  public void actionPerformed(ActionEvent e){
         char []str= get();
         if(e.getSource()==b1){
          t1.setText(new String(str));
       }
}


















}

