import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Stage;
public class user extends Application  {
	public static void main (String [] args)  {
		launch(args);
	}
	
	TextField text = new TextField();
	
	Label l = new Label("");
	
	DataOutputStream toClient = null;
	DataInputStream fromClient = null;
	
	public int count = 0;
	public int buttonPress = 0;
	public int rightButton = 0;
	
	int wordLength;
	String getWord;
	String oldText;
	String newText;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Socket s = new Socket("127.0.0.1", 6300);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		InputStream is = s.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		GridPane grid = new GridPane();
		GridPane grid1 = new GridPane();
		GridPane grid2 = new GridPane();
		
		grid2.setVgap(50);
		grid2.setPadding(new Insets(10, 10, 10, 10));
		
		VBox vleft = new VBox();
		VBox vright = new VBox();
		grid1.add(vleft, 0, 0);
		grid1.add(vright, 1, 0);
        
        Scene scene = new Scene(grid, 800, 450);
        primaryStage.setTitle("Hang Man Player 1");
        primaryStage.setScene(scene);
        primaryStage.show();
		primaryStage.setResizable(false);
        
		
		Label label = new Label("Press 'Start' to play!" );
        grid.add(label, 0, 0);
        grid.add(text, 0, 1);
        
        Button start = new Button("Start");
        grid.add(start, 0, 2);
        
        Button ready = new Button("Ready");

        text.setVisible(false);
        
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e){
            	start.setDisable(true);
            		label.setText("You will get a random word from dictionary to guess!\nYou will only be able to guess incorrectly 5 times or you lose");
            		grid.add(ready, 0, 2);
            		
            }
        });
        
        Button a = new Button("A");
        Button b = new Button("B");
        Button c = new Button("C");
        Button d = new Button("D");
        Button e1 = new Button("E");
        Button f = new Button("F");
        Button g = new Button("G");
        Button h = new Button("H");
        Button i = new Button("I");
        Button j = new Button("J");
        Button k = new Button("K");
        Button l = new Button("L");
        Button m = new Button("M");
        Button n = new Button("N");
        Button o = new Button("O");
        Button p = new Button("P");
        Button q = new Button("Q");
        Button r = new Button("R");
        Button s2 = new Button("S");
        Button t = new Button("T");
        Button u = new Button("U");
        Button v = new Button("V");
        Button w = new Button("W");
        Button x = new Button("X");
        Button y = new Button("Y");
        Button z = new Button("Z");
        
        a.setMinSize(35, 35);
        b.setMinSize(35, 35);
        c.setMinSize(35, 35);
        d.setMinSize(35, 35);
        e1.setMinSize(35, 35);
        f.setMinSize(35, 35);
        g.setMinSize(35, 35);
        h.setMinSize(35, 35);
        i.setMinSize(35, 35);
        j.setMinSize(35, 35);
        k.setMinSize(35, 35);
        l.setMinSize(35, 35);
        m.setMinSize(35, 35);
        n.setMinSize(35, 35);
        o.setMinSize(35, 35);
        p.setMinSize(35, 35);
        q.setMinSize(35, 35);
        r.setMinSize(35, 35);
        s2.setMinSize(35, 35);
        t.setMinSize(35, 35);
        u.setMinSize(35, 35);
        v.setMinSize(35, 35);
        w.setMinSize(35, 35);
        x.setMinSize(35, 35);
        y.setMinSize(35, 35);
        z.setMinSize(35, 35);
        
        
        Image one = new Image("hangman1.png");
    	Image two = new Image("hangman2.png");
    	Image three = new Image("hangman3.png");
    	Image four = new Image("hangman4.png");
    	Image five = new Image("hangman5.png");
    	Image six = new Image("hangman6.png");
    	Image seven = new Image("hangman7.png");
    	
    	ImageView one1 = new ImageView(one);
    	ImageView two1 = new ImageView(two);
    	ImageView three1 = new ImageView(three);
    	ImageView four1 = new ImageView(four);
    	ImageView five1 = new ImageView(five);
    	ImageView six1 = new ImageView(six);
    	ImageView seven1 = new ImageView(seven);
    	
    	one1.setFitHeight(250);
    	one1.setFitWidth(250);
    	two1.setFitHeight(250);
    	two1.setFitWidth(250);
    	three1.setFitHeight(250);
    	three1.setFitWidth(250);
    	four1.setFitHeight(250);
    	four1.setFitWidth(250);
    	five1.setFitHeight(250);
    	five1.setFitWidth(250);
    	six1.setFitHeight(250);
    	six1.setFitWidth(250);
    	seven1.setFitHeight(250);
    	seven1.setFitWidth(250);
       
        ready.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String message;
            	
            	try {
					dos.writeUTF("ready");
				} catch (IOException e2) {
					e2.printStackTrace();
				}
            	try {
            		getWord = dis.readUTF();
					//wordLength = dis.readInt();
				} catch (IOException e2) {
					
					e2.printStackTrace();
				}
            	
            	System.out.println(getWord);
            	
            	String array[] = new String[wordLength];
            	for(int i = 0; i < wordLength; i++){
            			array[i] = "__ ";
            	}
        		
        		System.out.println(wordLength);
        	
            	if(text.getText().length() > 20){
            		label.setText("Word/words too long.\nNumber of characters: " + text.getText().length() + "\nMax 20 characters.");
            	}else{
            		
            	ready.setVisible(false);
            	
            	grid.add(grid1, 0, 0);
            	grid.add(grid2, 1, 0);
            	
            	Label guess = new Label("Guess: " + getWord);
            	guess.setFont(Font.font ("Verdana", 10));
            	grid2.add(guess, 0, 0);
            	
            	text.setVisible(false);
            	label.setVisible(false);
            	
        
            	vleft.getChildren().add(a);
            	vleft.getChildren().add(b);
            	vleft.getChildren().add(c);
            	vleft.getChildren().add(d);
            	vleft.getChildren().add(e1);
            	vleft.getChildren().add(f);
            	vleft.getChildren().add(g);
            	vleft.getChildren().add(h);
            	vleft.getChildren().add(i);
            	vleft.getChildren().add(j);
            	vleft.getChildren().add(k);
            	vleft.getChildren().add(l);
            	vleft.getChildren().add(m);
            	vright.getChildren().add(n);
            	vright.getChildren().add(o);
            	vright.getChildren().add(p);
            	vright.getChildren().add(q);
            	vright.getChildren().add(r);
            	vright.getChildren().add(s2);
            	vright.getChildren().add(t);
            	vright.getChildren().add(u);
            	vright.getChildren().add(v);
            	vright.getChildren().add(w);
            	vright.getChildren().add(x);
            	vright.getChildren().add(y);
            	vright.getChildren().add(z);
            	

            	grid2.add(one1, 0, 1);
            	grid2.add(two1, 0, 1);
            	grid2.add(three1, 0, 1);
            	grid2.add(four1, 0, 1);
            	grid2.add(five1, 0, 1);
            	grid2.add(six1, 0, 1);
            	grid2.add(seven1, 0, 1);
            	
            	one1.setVisible(true);
            	two1.setVisible(false);
            	three1.setVisible(false);
            	four1.setVisible(false);
            	five1.setVisible(false);
            	six1.setVisible(false);
            	seven1.setVisible(false);
            	
            	Label win = new Label("YOU WON!");
                Label lose = new Label("Sorry, you lost.");
            	

            	a.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	a.setDisable(true);
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("a");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	
						
                    	
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        
                        
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    	
                    }
                });
                
                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	b.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("b");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('b')){
                    			array[i] = " b ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
                    	
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                        
                    }
                });
                
                c.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	c.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("c");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('c')){
                    			array[i] = " c ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
                    	
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                    	
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                d.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	d.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("d");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('d')){
                    			array[i] = " d ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
                    	//if(!randomWord.contains("d")){
                		//	count++;
                		//}else{
                		//	rightButton++;
                		//}
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    	
                    }
                });
                
                e1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	e1.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("e");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('e')){
                    			array[i] = " e ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                f.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	f.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("f");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('f')){
                    			array[i] = " f ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    	
                    }
                });
                
                g.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("g");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('g')){
                    			array[i] = " g ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	g.setDisable(true);
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    
                    }
                });

                h.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	buttonPress++;
                    	h.setDisable(true);
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("h");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('h')){
                    			array[i] = " h ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                i.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	i.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("i");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('i')){
                    			array[i] = " i ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
			
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        	
                        }
            			if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                j.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	j.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("j");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('j')){
                    			array[i] = " j ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                k.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	k.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("k");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('k')){
                    			array[i] = " k ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                l.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	l.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("l");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('l')){
                    			array[i] = " l ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                m.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	m.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("m");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('m')){
                    			array[i] = " m ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                n.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	n.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("n");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('n')){
                    			array[i] = " n ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                o.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	o.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("o");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('o')){
                    			array[i] = " o ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                p.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	p.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("p");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('p')){
                    			array[i] = " p ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                q.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	q.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("q");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('q')){
                    			array[i] = " q ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                r.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	r.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("r");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('r')){
                    			array[i] = " r ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                s2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	s2.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("s");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('s')){
                    			array[i] = " s ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                t.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	t.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("t");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('t')){
                    			array[i] = " t ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                u.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	u.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("u");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('u')){
                    			array[i] = " u ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                v.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	v.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("v");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('v')){
                    			array[i] = " v ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }else if((count < 6) && (rightButton == wordLength)){/*
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);*/
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                w.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	w.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("w");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('w')){
                    			array[i] = " w ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                x.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	x.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("x");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('x')){
                    			array[i] = " x ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                y.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	y.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("y");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('y')){
                    			array[i] = " y ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                z.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                    	z.setDisable(true);
                    	buttonPress++;
                    	oldText = guess.getText();
                    	System.out.println("oldText: " + oldText);
                    	try {
							dos.writeUTF("z");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	try {
                    		guess.setText(dis.readUTF());	
						} catch (IOException e2) {
							e2.printStackTrace();
						}
                    	
                    	newText = guess.getText();
                    	System.out.println("newText: " + newText);
                    	if(oldText.equals(newText)){
                    		count++;
                    	}
                    	for(int i = 0; i < wordLength; i++){
                    		//if(word[i] == ('z')){
                    			array[i] = " z ";
                    			guess.setText("Guess: " + Arrays.toString(array));
                    		//}
                    		
                    	}
						
                    	if(count == 1){
                        	two1.setVisible(true);
                        	one1.setVisible(false);
                        	System.out.println("count: " + count);
                        	
                        }
                        
                        if(count == 2){
                        	three1.setVisible(true);
                        	two1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 3){
                        	four1.setVisible(true);
                        	three1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 4){
                        	five1.setVisible(true);
                        	four1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 5){
                        	six1.setVisible(true);
                        	five1.setVisible(false);
                        	System.out.println("count: " + count);
                        }
                        
                        if(count == 6){
                        	seven1.setVisible(true);
                        	six1.setVisible(false);
                        	System.out.println("count: " + count);

                        }
                        if(count == 6){
                        	grid2.add(lose, 0, 0);
                        	
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);
                        }
                        if(guess.getText().equals("win")){
                        	grid2.add(win, 0, 0);
                        	a.setVisible(false);
                        	b.setVisible(false);
                        	c.setVisible(false);
                        	d.setVisible(false);
                        	e1.setVisible(false);
                        	f.setVisible(false);
                        	g.setVisible(false);
                        	h.setVisible(false);
                        	i.setVisible(false);
                        	j.setVisible(false);
                        	k.setVisible(false);
                        	l.setVisible(false);
                        	m.setVisible(false);
                        	n.setVisible(false);
                        	o.setVisible(false);
                        	p.setVisible(false);
                        	q.setVisible(false);
                        	r.setVisible(false);
                        	s2.setVisible(false);
                        	t.setVisible(false);
                        	u.setVisible(false);
                        	v.setVisible(false);
                        	w.setVisible(false);
                        	x.setVisible(false);
                        	y.setVisible(false);
                        	z.setVisible(false);
                        
                        	guess.setVisible(false);
                        	one1.setVisible(false);
                        	two1.setVisible(false);
                        	three1.setVisible(false);
                        	four1.setVisible(false);
                        	five1.setVisible(false);
                        	six1.setVisible(false);
                        	seven1.setVisible(false);	
						}
                    }
                });
                
                //System.out.println("buttonPress: " + buttonPress);
                //System.out.println("NoRepeats: " + wordLength);
                
                if(count == 6){
                	grid2.add(lose, 0, 0);
                	
                	a.setVisible(false);
                	b.setVisible(false);
                	c.setVisible(false);
                	d.setVisible(false);
                	e1.setVisible(false);
                	f.setVisible(false);
                	g.setVisible(false);
                	h.setVisible(false);
                	i.setVisible(false);
                	j.setVisible(false);
                	k.setVisible(false);
                	l.setVisible(false);
                	m.setVisible(false);
                	n.setVisible(false);
                	o.setVisible(false);
                	p.setVisible(false);
                	q.setVisible(false);
                	r.setVisible(false);
                	s2.setVisible(false);
                	t.setVisible(false);
                	u.setVisible(false);
                	v.setVisible(false);
                	w.setVisible(false);
                	x.setVisible(false);
                	y.setVisible(false);
                	z.setVisible(false);
                	guess.setVisible(false);
                	one1.setVisible(false);
                	two1.setVisible(false);
                	three1.setVisible(false);
                	four1.setVisible(false);
                	five1.setVisible(false);
                	six1.setVisible(false);
                	seven1.setVisible(false);
                }
                
                
            	}//end of long else
            }
        });

	
	
	}
	


}
