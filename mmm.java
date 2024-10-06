import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.image.BufferedImage;

public class mmm extends JFrame{
    public static void main(String[] args){
        JFrame app=new JFrame("Roadblusters");
        work w=new work();
        app.add(w);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500, 700);
        app.setVisible(true);
        app.setResizable(false);
        ImageIcon icon = new ImageIcon("Icon.jpg");
        app.setIconImage(icon.getImage());
    }
}


class work extends JPanel implements ActionListener, KeyListener {
    private int space;
    private int speed;
    private int width = 70;
    private int height = 80;
    private int WIDTH = 500;
    private int HEIGHT = 700;
    private int move = 100;
    private int count = 1;
    private int countPrev=0;
    private Rectangle car;
    private ArrayList<Rectangle> ocars;
    private Random rand;
    boolean linef=true;
    private boolean isPaused = false;
    private boolean isGameOver = false;
    Timer t;

    public work() {
        t = new Timer(2, this);
        rand = new Random();
        ocars = new ArrayList<Rectangle>();
        car = new Rectangle(WIDTH / 2 - 90, HEIGHT - 100, width, height);
        speed = 2;
        space = 400;
        addKeyListener(this);
        setFocusable(true);
        initializeGame();
        // Adding initial cars
        
    }

    private void initializeGame() {
        ocars.clear();
        count=0;
        speed=2;
        for (int i = 0; i < 4; i++) {
            addocars(true);
        }
        car = new Rectangle(WIDTH / 2 - 90, HEIGHT - 100, width, height);
        t.start();
        isGameOver = false;
        isPaused = false;
    }

    public void addocars(boolean first){
        int posx = rand.nextInt()%2;
        int x=0;
        int y=0;
        int Width=width;
        int Height=height;
        if(posx==0){
            x=WIDTH/2-90;
        }else{
            x=WIDTH/2+10;
        }
        if(first){
            ocars.add(new Rectangle(x,y-100-(ocars.size()*space),Width,Height));//space between cars
        }else{
            ocars.add(new  Rectangle(x,ocars.get(ocars.size()-1).y-400,Width, Height));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Scale and draw the background image
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.black);
        g.fillRect(WIDTH / 2 - 100, 0, 200, HEIGHT);
        g.setColor(Color.RED);
        g.fillRect(car.x, car.y, car.width, car.height);
        g.setColor(Color.WHITE);
        g.drawLine(WIDTH / 2, 0, WIDTH/2, HEIGHT);
        g.setColor(Color.MAGENTA);
        for (Rectangle rect : ocars) {
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
        }

        g.setColor(Color.WHITE);
        g.drawString("Press P to Pause.", WIDTH-115, 25);
        g.setColor(Color.WHITE);
        g.drawString("Press Esc to Quit.", WIDTH-115, 10);

        if (isGameOver) {
            g.setColor(Color.WHITE);
            g.drawString("Game Over! Press R to Restart.", WIDTH / 2 - 70, HEIGHT / 2);
        }
        if (isPaused) {
            g.setColor(Color.WHITE);
            g.drawString("Game Paused! Press R to Resume.", WIDTH / 2 - 80, HEIGHT / 2);
        }
        g.setColor(Color.WHITE);
        if(count>countPrev){
            countPrev=count;
            g.drawString("High score: "+countPrev/10, 0, 60);
        }else{
            g.drawString("High score: "+countPrev/10, 0, 60);
        }
        
        g.setColor(Color.WHITE);
        g.drawString("Current score: "+count/10, 0, 100);
        repaint();
    }

    public void actionPerformed(ActionEvent e){
        
        if (isPaused || isGameOver) return;
        Rectangle rect;
        for (int i = 0; i <ocars.size();i++) {
            rect = ocars.get(i);
            if(count%1000==0){
                speed++;
            }
            
            rect.y+=speed;
        }

        for(Rectangle r:ocars){
            if(r.intersects(car)){
                car.y=r.y+height;//collision
                isGameOver = true;
            }else{
                count++;
            }
        }

        for(int i=0;i<ocars.size();i++){
            rect=ocars.get(i);
            if (rect.y+rect.height>HEIGHT) {
                ocars.remove(i);
                addocars(false);
            }
        }
        repaint();
    }

    public void moveLeft(){
        if (car.x-move<WIDTH/2-90){
            System.out.println("\b");
        }else{
            car.x-=move;
        }
    }

    public void moveRight(){
        if (car.x-move>WIDTH/2-115){
            System.out.println("\b");
        }else{
            car.x+=move;
        }
    }
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT:
                moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                moveRight();
                break;
            case KeyEvent.VK_P: // Pause
                if (!isGameOver) isPaused = true;
                break;
            case KeyEvent.VK_R: // Restart or Resume
                if (isGameOver) {
                    initializeGame();
                } else {
                    isPaused = !isPaused; // Toggle pause/resume
                }
                break;
            case KeyEvent.VK_ESCAPE: // End game
                System.exit(0);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        throw new UnsupportedOperationException("Not support yet.");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not support yet.");
    }
}