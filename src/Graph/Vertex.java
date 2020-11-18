package Graph;

import javax.swing.*;
import java.awt.*;

public class Vertex {
    private String name;
    private boolean isVisited;
    private JLabel jLabel;
    Vertex(String name){
        this.name = name;
        isVisited = false;
        jLabel = new JLabel();
        jLabel.setText(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public JLabel getjLabel() {
        return jLabel;
    }

}
