import javax.swing.*;
import java.awt.*;
import java.util.*;


public class PrimitivesApp {
    private final Button addButton;
    private JFrame frame;
    private DrawerPanel drawerPanel;

    public static void main(String[] args) {
        PrimitivesApp app = new PrimitivesApp();
        app.start();
    }

    public PrimitivesApp(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 260);

        drawerPanel = new DrawerPanel();
        drawerPanel.setSize(400, 200);

        Container mainContainer = frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.setSize(400, 30);

        mainContainer.add(bottomPanel, BorderLayout.SOUTH);
        mainContainer.add(drawerPanel, BorderLayout.CENTER);

        addButton = new Button("Add");
        addButton.addActionListener(e -> onAddClick());
        bottomPanel.add(addButton);

    }

    private void onAddClick() {

         Random rand = new Random();
         int num = rand.nextInt(3);
         if(num == 0){
            drawerPanel.addRectangle();
        }else if(num == 1){
            drawerPanel.addCircle();
        }else if(num == 2){
             drawerPanel.addTri();
         }

        drawerPanel.repaint();
    }


    private void start() {
        frame.setVisible(true);
    }
}